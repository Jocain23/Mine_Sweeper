/***************************************************
*The Start Up Panel is made up of two subpanels. The 
*first of which displays the TJHSST logo and who created
*the program. The second panel is the one the user interacts
*with. It gives a drop down member where players can pick 
*three different modes. These are easy medium and hard. 
*If the player decides to they can enter their own values
*for side length and the number of mines. They go from ranges
*of 4-24 for the sidelength, and 1-143 for mines.
*@author Hardeep Mann, Jonluke O'Cain and Vayun Malik
*@version 1.0
 ****************************************************/
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Start_Up_Panel extends JPanel {

	/**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   private JTextField numCellsTextField = new JTextField(10);
   private JTextField nummMinesTextField = new JTextField(10);

   private int numCellsInSide = 0;
   private int numMines = 0;
   private Minesweeper_Driver driver;

   public Start_Up_Panel(Minesweeper_Driver driver) throws IOException {
   
      this.driver = driver;
   
      JPanel p1 = new JPanel();
      JPanel p2 = new JPanel();
   
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS) );
      this.add(p1);
      this.add(p2);
   
      BufferedImage tjLogo = ImageIO.read(this.getClass().getResource("Tjlogo.png"));
      JLabel tjLogoLabel = new JLabel(new ImageIcon(tjLogo));
      p1.add(tjLogoLabel);
   
      JLabel projectInfo = new JLabel("<html>This game was designed and developed<br>by TJ students: <br><br>"
         	+ "&nbsp;&nbsp;&nbsp;&nbsp;Hardeep Mann<br>"
         	+ "&nbsp;&nbsp;&nbsp;&nbsp;Jonluke O'Cain<br>"
         	+ "&nbsp;&nbsp;&nbsp;&nbsp;Vayun Malik<br><br>"
         	+ "under the guidance of<br>"
         	+ "&nbsp;&nbsp;&nbsp;&nbsp; the great Mr. Rose");
   	
      p1.add(projectInfo); 
   	
   	// set border for the project info panel
      p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "TJ Project - MineSweeper"));
   	
   
   	// add components to the preference panel
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.anchor = GridBagConstraints.WEST;
      constraints.insets = new Insets(10, 10, 10, 10);
   
      p2.setLayout(new GridBagLayout());
   
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.anchor = GridBagConstraints.EAST;
      JLabel labelDifficultyLevel = new JLabel("Suggested Level Values: ");
      p2.add(labelDifficultyLevel, constraints);
   
      constraints.anchor = GridBagConstraints.WEST;
   
      String[] difficultyLevels = { "Easy", "Medium", "Hard" };
      JComboBox cc = new JComboBox(difficultyLevels);
   	
      constraints.gridx = 1;
      constraints.gridy = 0;
      p2.add(cc, constraints);
      cc.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (cc.getSelectedIndex() == 0) {
                  numCellsTextField.setText("12");
                  nummMinesTextField.setText("18");
               
               } else if (cc.getSelectedIndex() == 1) {
                  numCellsTextField.setText("14");
                  nummMinesTextField.setText("32");
               } else {
                  numCellsTextField.setText("20");
                  nummMinesTextField.setText("48");
               }
            
               System.out.println("Selection: " + ((JComboBox) e.getSource()).getSelectedItem());
            }
         });
   	
      cc.setSelectedIndex(0);
   
      constraints.gridx = 0;
      constraints.gridy = 1;
      constraints.anchor = GridBagConstraints.EAST;
      JLabel labelNumCells = new JLabel("Cells in a side: ");
      p2.add(labelNumCells, constraints);
   
      constraints.gridx = 1;
      p2.add(numCellsTextField, constraints);
      numCellsTextField.addActionListener(new Listener1());
   
      constraints.gridx = 0;
      constraints.gridy = 2;
      JLabel labelNumMines = new JLabel("Number of Mines: ");
      p2.add(labelNumMines, constraints);
   
      constraints.gridx = 1;
      p2.add(nummMinesTextField, constraints);
      nummMinesTextField.addActionListener(new Listener2());
   
      constraints.gridx = 0;
      constraints.gridy = 3;
      constraints.gridwidth = 2;
      constraints.anchor = GridBagConstraints.CENTER;
   
      JButton buttoPlay = new JButton("Play");
      p2.add(buttoPlay, constraints);
   
      buttoPlay.addActionListener(new Listener3());
   
   	// set border for the preference panel
      p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Game Preferences"));
   }


	/****************************************
	 * Serves as the user imput for set_num_bombs()
	 *****************************************/
   private class Listener1 implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         System.out.println("Cellss...... " + numCellsTextField.getText());
         processCellsTextField();
      
      }
   
   }

	/****************************************
	 * Serves as the user imput for set_side_length()
	 *****************************************/
   private class Listener2 implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         System.out.println("Mines...... " + nummMinesTextField.getText());
         processMinesTextField();
      
      }
   
   }

	/**************************************
	 * Once the user has entered all of the information pressing this button will
	 * generate the playboard and start the game.
	 **************************************/

   private class Listener3 implements ActionListener {
      public void actionPerformed(ActionEvent e) {
      
         if (processCellsTextField() && processMinesTextField()) {
            System.out.println("Playing can proceed......");
            driver.actionfromStart_Up_Panel(numCellsInSide, numMines);
         }
      }
   }

   public boolean processMinesTextField() {
      boolean ret = true;
      try {
         numMines = Integer.parseInt(nummMinesTextField.getText());
         int totalCells = numCellsInSide * numCellsInSide;
         if ((numMines <= 0) || (numMines >= totalCells)) {
            ret = false;
         	// int limitMines = totalCell
            JOptionPane.showMessageDialog(this,
               	"Number of Mines:: Only integer values between 1 -" + (totalCells - 1) + "  allowed.");
         }
      
      } catch (NumberFormatException e) {
         ret = false;
         JOptionPane.showMessageDialog(this, "Number of Mines::Only integer values allowed!!");
      }
   
      return ret;
   }

   public boolean processCellsTextField() {
      boolean ret = true;
      try {
         numCellsInSide = Integer.parseInt(numCellsTextField.getText());
         if ((numCellsInSide < 4) || (numCellsInSide > 24)) {
            ret = false;
            JOptionPane.showMessageDialog(numCellsTextField,
               	"Number of Cells::Only integer values between 4 - 24 allowed.");
         }
      
      } catch (NumberFormatException e) {
         ret = false;
         JOptionPane.showMessageDialog(numCellsTextField, "Number of Cells::Only integer values allowed!!");
      }
   
      return ret;
   }

}

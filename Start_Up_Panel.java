/*********************************************
The Start up panel that gets the user input. 
It will ask the user for a side-length and the number of
mines. When these two are entered they will be saved as 
integer variables side_length and num_bombs respectively. 
Once the user has entered all of the information a 
generate button will be displayed which the user can 
click to generate the playboard and start the game.
@author Hardeep Mann, Jonluke O'Cain and Vayun Malik
@version 0.1
**********************************************/ 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start_Up_Panel extends JPanel
{
   private JLabel title_label, author_label, side_length_label, num_mines_label;
   private JTextField length_box, mines_box;
   private int side_length, num_mines;
   public Start_Up_Panel()
   {
      setLayout(new FlowLayout());
      title_label = new JLabel("MINESWEEPER");
      title_label.setFont(new Font("Serif", Font.BOLD, 75));
      title_label.setForeground(Color.blue);
      add(title_label);
      
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      add(panel);
      
      length_box = new JTextField("Side length", 10);
      length_box.setHorizontalAlignment(SwingConstants.LEFT);
      panel.add(length_box);
     
      mines_box = new JTextField("Number of mines", 10);
      mines_box.setHorizontalAlignment(SwingConstants.LEFT);
      panel.add(mines_box);
      
      JButton button = new JButton("Next");
      button.addActionListener(new Listener1());
      panel.add(button);
      
      author_label = new JLabel("By Hardeep Mann, Jonluke O'Cain, and Vayun Malik, under the supervision of the great Mr. Rose. ");
      add(author_label);
   }
   
   public static void set_side_length()
   {
   }
   /*******************************
   Sets the number of squares on each side
   @param side_length
   *******************************/

   public static void set_num_bombs()
   {
   }
   /*******************************
   Sets the number of squares which will be bombs 
   @param num_bombs
   *******************************/
   public int side_length()
   {
      return 99;// to compile
   }
   public int num_bombs()
   {
     
      return 99;// to compile
   }
   
   private class Listener1 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         /****************************************
         Once the user has entered all of the information pressing this
         button will generate the playboard and start the game.
         *****************************************/
         side_length = Integer.parseInt(length_box.getText());
         num_mines = Integer.parseInt(mines_box.getText());
         JFrame frame = new JFrame("Mine Sweeper");
         frame.setSize(1000, 450);
         frame.setLocation(150, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Playboard_Panel(side_length, num_mines));
         frame.setVisible(true);
      }
     
   }
}

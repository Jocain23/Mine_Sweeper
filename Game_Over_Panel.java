/***************************************************
The game over panel is the panel shown to the user after 
the game ends. It recieves whether or not the user has won
or lost from the playboard panel, and displays either 
a picture of a trophy with a victory noise or "Try Again"
with the noise of an explosion depending on whether or not
the user wins the game. It also gives the user the chance 
to play the game again or exit the application.
@author Hardeep Mann, Jonluke O'Cain and Vayun Malik
@version 1.0
 ****************************************************/
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game_Over_Panel extends JPanel {
   private Minesweeper_Driver driver;

	// This panel is shown to the user when the game is ended.
   public Game_Over_Panel(Minesweeper_Driver driver, boolean isWinner) throws IOException {
      this.driver = driver;
   
      setLayout(new FlowLayout(FlowLayout.CENTER));
   
      JPanel p1 = new JPanel();
      add(p1);
      p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
   
      BufferedImage resultImg;
   
      if (isWinner) {
         resultImg = ImageIO.read(this.getClass().getResource("gold.png"));
      } else {
         resultImg = ImageIO.read(this.getClass().getResource("mine_medium.png"));
      }
   
      PlaySound.playSoundGameOver(isWinner, 1);
   
      JLabel resultLabel = new JLabel(new ImageIcon(resultImg));
      p1.add(resultLabel);
   
      JButton button1 = new JButton("Try Again");
      button1.addActionListener(new Listener1());
      add(button1);
   
      JButton button2 = new JButton("Exit");
      button2.addActionListener(new Listener2());
      add(button2);
   
   }

   private class Listener1 implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         System.out.println("Here1");
         driver.actionfromGameover_Panel(true);
      
      	/// the user can click this button to try again
      }
   }

   private class Listener2 implements ActionListener {
      public void actionPerformed(ActionEvent e) {
      	/// the user can click this button to exit the program
         System.exit(0);
      }
   }
}

   //Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
   //Last Updated: 4/29/2021
   //Period: 2
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
public class Game_Over_Panel extends JPanel
{
   //This panel is shown to the user when the game is ended.
      public Game_Over_Panel()
      {
            /// sets up the panel
            setLayout(new FlowLayout());
            
            JButton button1 = new JButton("Try Again");
            button1.addActionListener(new Listener1());
            add(button1);
            
            JButton button2 = new JButton("Exit");
            button2.addActionListener(new Listener2());
            add(button2);
      }
   private class Listener1 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         /// the user can click this button to try again
      }
    }
    
    private class Listener2 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         /// the user can click this button to exit the program
      }
     }
    public static void getResult()
    {
      /// This method gets the result of whether its a win or a loss from the play board panel. Then it will use that result to display the correct text for the user.
    }
   }

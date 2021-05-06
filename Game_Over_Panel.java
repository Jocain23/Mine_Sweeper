  //Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
   //Last Updated: 5/6/2021
   //Period: 2
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.JFrame;
public class Game_Over_Panel extends JPanel
{
   //This panel is shown to the user when the game is ended.
      private JLabel label1;
      private String result;
      public Game_Over_Panel()
      {
            // sets up the panel
            setLayout(new FlowLayout());
            
            JButton button1 = new JButton("Try Again");
            button1.addActionListener(new Listener1());
            add(button1);
            
            JButton button2 = new JButton("Exit");
            button2.addActionListener(new Listener2());
            add(button2);
            
            label1 = new JLabel(" ");
            label1.setFont(new Font("Times New Roman", Font.BOLD, 100));
            label1.setForeground(Color.blue);
            getResult();
            add(label1);
      }
   private class Listener1 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         // the user can click this button to try again
         JFrame frame = new JFrame("Mine Sweeper");
         frame.setSize(500, 200);
         frame.setLocation(150, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Start_Up_Panel());
         frame.setVisible(true);
      }
    }
    
    private class Listener2 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         // the user can click this button to exit the program
         System.exit(0);
      }
     }
      public void getResult()
    {
      result = "lose";
      // This method gets the result of whether its a win or a loss from the play board panel. 
      // Then it will use that result to display the correct text for the user.
      if (result == "win")
      {
         label1.setText("Congratulations You Won!!");
      }
      else
         label1.setText("Sorry, You Lost.");
    }
   }

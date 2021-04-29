   //Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
   //Last Updated: 4/29/2021
   //Period: 2
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Playboard_Panel extends JPanel
{
   public Playboard_Panel()
   {
       /// Sets up the panel
   }
   public static void Initial_Generate()
   {
      /// Generates the initial map with each square being empty
   }
   
   public static void Final_Generate()
   {
      /// This method is called when the first square is revealed. This places all the mines. 
   }

   public static void Mine_Check(int x, int y)
   {
      /// Starts by setting a count to 0. Then it assigns each square a number based on how many mines are in its vicinity. It then returns the count.
   }
   public static void Spread(int x, int y)
   {
      /// All of the surrounding squares display themselves. 
      /// It also checks for victory and tells the game over panel the result. 
   }
   private class Listener1 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         /// Is called when the square is flagged.
      }
   }

   private class Listener2 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         /// Is called when the square is clicked on.
      }
   }

}

   //Name: Hardeep Mann, Jonluke O'Cain, and Vayun Malik
   //Date: 4/29/2021
   //Period: 2
   import javax.swing.JFrame;
public class Minesweeper_Driver
{
   //This is the class that will set everything up. 
   public static void main(String[] args)
   {
   //This method will create the start up panel with a predetermined size.
   //When the start up panel gets the size and number of mines from the user it will send that information to the playboard panel. 
   //Then the driver will create the playboard panel, and then create the game over panel when the game ends.
         JFrame frame = new JFrame("Mine Sweeper");
         frame.setSize(500, 150);
         frame.setLocation(150, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Start_Up_Panel());
         frame.setContentPane(new PlayBoard_Panel());
         frame.setContentPane(new Game_Over_Panel());
         frame.setVisible(true);
   }
}

   	//Name: Hardeep Mann and Jonluke O'Cain
   //Date: 4/27/2021
   //Period: 2
   import javax.swing.JFrame;
public class Minesweeper_Driver
{
   public static void main(String[] args)
   {
         JFrame frame = new JFrame("Mine Sweeper");
         frame.setSize(500, 150);
         frame.setLocation(150, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Start_Up_Panel());
         frame.setContentPane(new Playboard_Panel());
         frame.setContentPane(new Game_Over_Panel());
         frame.setVisible(true);
   }
}

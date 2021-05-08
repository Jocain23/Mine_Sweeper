    //Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
   //Last Updated: 5/8/2021
   //Period: 2
   import java.util.*;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.JFrame;
   public class Playboard_Panel extends JPanel
   {
      public int length;
      public int num_squares;
      public int mines;
      public Playboard_Panel(int side_length, int num_mines)
      {
         setLayout(new BorderLayout());
      
         JPanel panel = new JPanel();
         panel.setLayout(new FlowLayout());
         add(panel, BorderLayout.SOUTH);
         
         length = side_length;
         num_squares = length * length;
         mines = num_mines;
         
         JPanel panel2 = new JPanel();
         panel2.setLayout(new GridLayout(length, length));
         add(panel2, BorderLayout.NORTH); 
         
         
         Square matrix[][] = new Square[length][length];
         for(int j = 0; j < length; j++)
         {
            for(int t = 0; t < length; t++) 
            {
               matrix[t][j] = new Square(false);
               JButton button = new JButton(t + " " + j);
               button.addActionListener(new Listener());
               panel2.add(button);
            
            }
         }
         Set<String> hash_Set = new HashSet<String>();

         
         
      }
      public void Initial_Generate()
   {
      /// Generates the initial map with each square being empty
         
         
      
   }
      public static void Final_Generate()
   {
      /// This method is called when the first square is revealed. This places all the mines. 
   }
      public int Mine_Check(int count, int y)
   {
      /// Starts by setting a count to 0. Then it assigns each square a number based on how many mines are in its vicinity. It then returns the count.
      count = 0;
      return count;
   }
      public static void Spread(int x, int y)
   {
      /// All of the surrounding squares display themselves. 
      /// It also checks for victory and tells the game over panel the result.
      JFrame frame = new JFrame("Mine Sweeper");
      frame.setSize(800, 200);
      frame.setLocation(150, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Game_Over_Panel());
      frame.setVisible(true); 
   }
        private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            // generates a map of empty squares
         }
      }
}

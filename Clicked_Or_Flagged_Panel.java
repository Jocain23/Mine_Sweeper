   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   public class Clicked_Or_Flagged_Panel extends JPanel
   {
      public Clicked_Or_Flagged_Panel()
      {
         setLayout(new BorderLayout());
         
         JPanel panel = new JPanel();
         panel.setLayout(new FlowLayout());
         add(panel, BorderLayout.SOUTH);
         
         JButton button1 = new JButton("Revealed");
         button1.addActionListener(new Listener1());
         panel.add(button1);
         
         JButton button2 = new JButton("Flagged");
         button2.addActionListener(new Listener2());
         panel.add(button1);
      }
      private class Listener1 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            // generates a map of empty squares
         }
      }
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            // generates a map of empty squares
         }
      }
}
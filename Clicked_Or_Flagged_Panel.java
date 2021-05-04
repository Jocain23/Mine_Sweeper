   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   public class Clicked_Or_Flagged_Panel extends JPanel
   {
      public Clicked_Or_Flagged_Panel(Square arg)
      {
         setLayout(new BorderLayout());
         
         JPanel panel = new JPanel();
         panel.setLayout(new FlowLayout());
         add(panel, BorderLayout.SOUTH);
         
         JButton button1 = new JButton("Reveal");
         button1.addActionListener(new Listener1());
         panel.add(button1);
         
         JButton button2 = new JButton("Flagg");
         button2.addActionListener(new Listener2());
         panel.add(button1);
      }
      private class Listener1 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
          Square.clicked_on();
         }
      }
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
          Square.flagged();  
         }
      }
}

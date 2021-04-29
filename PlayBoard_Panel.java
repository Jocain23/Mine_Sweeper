   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   public class PlayBoard_Panel extends JPanel
   {
      public PlayBoard_Panel()
      {
         setLayout(new BorderLayout());
      
         JPanel panel = new JPanel();
         panel.setLayout(new FlowLayout());
         add(panel, BorderLayout.SOUTH);
         
         JButton button1 = new JButton("High");
         button1.addActionListener(new Listener1());
         panel.add(button1);
         
         JButton button2 = new JButton("Low");
         button2.addActionListener(new Listener2());
         panel.add(button2);
      }
        private class Listener1 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            // generates a map of empty squares
         }
      }
       
        private class Listener1 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            //places the mines and gives all the squares their values
         }
      }
}

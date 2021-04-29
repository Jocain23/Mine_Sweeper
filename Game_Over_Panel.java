   //Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
   //Date: 4/27/2021
   //Period: 2
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
public class Game_Over_Panel extends JPanel
{
      public Game_Over_Panel()
      {
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
      
      }
    }
    
    private class Listener2 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
      
      }
     }
    public static void getResult()
    {
    }
   }

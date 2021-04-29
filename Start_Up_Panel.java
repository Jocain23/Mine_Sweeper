/*********************************************
The Start up panel that gets the user input. 
It will ask the user for a side-length and the number of
mines. It will give three preset recommendations of 
easy medium and hard that the player can choose from. 
When these two are entered they will be saved as integer 
variables side_length and num_bombs respectively. 
Once the user has entered all of the information a 
generate button will be displayed which the user can 
click to generate the playboard and start the game.

@author Hardeep Mann, Jonluke O'Cain and Vayun Malik
@version 0.1
**********************************************/ 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start_Up_Panel extends JPanel
{
       public Start_Up_Panel()
       {
       
       }
   
   public static void set_side_length()
   {
   }
   /*******************************
   Sets the number of squares on each side
   @param side_length
   *******************************/

   public static void set_num_bombs()
   {
   }
   /*******************************
   Sets the number of squares which will be bombs 
   @param num_bombs
   *******************************/
   public int side_length()
   {
   return 99;// to compile
   }
      public int num_bombs()
   {
     
   return 99;// to compile
   }
   
    private class Listener1 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
      
      }
     
    }
    /****************************************
    Serves as the user imput for set_num_bombs() 
    *****************************************/

     private class Listener2 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
      
      }

    }
     /****************************************
    Serves as the user imput for set_side_length() 
    *****************************************/
     private class Listener3 implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
      }
      /**************************************
      Once the user has entered all of the information pressing this
      button will generate the playboard and start the game.
      **************************************/
    }
    }

    /*************************************************
 Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
 Last Updated: 5/6/2021
Period: 2
**************************************************/
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public abstract class Square
{
 

  
   //This class exhibits polymorphic behavior and defines the square objects. 
   //The square objects have three different states which are clicked_on, flagged, and untouched. 
   //The first state is untouched and all squares start out this way. 

   public static boolean is_Mine;
   public boolean clicked = false; 
   // The boolean varible clicked starts false and set to true when clicked, Used for checking win conditions
   //The boolean variable is_Mine is true when the square has a mine, and false otherwise.
   public JLabel label1 = new JLabel(" ");
   public abstract void display();
   
   public void clicked_on()
   {
      //Whenever a square is interacted with the state changes to clicked_on. 
      //In this state the square opens a menu that allows the user to either flag or reveal the square. 
      //When the square is flagged it transitions into the flagged state.
     if (is_Mine == true)
     {
     Game_Over_Panel Jeff = new Game_Over_Panel();
     }
     
     clicked = true;
     this.display();
      

   }

   
   public void flagged()
   {
      label1.setText("F");
   }
}

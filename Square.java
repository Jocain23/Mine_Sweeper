   //Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
   //Last Updated: 4/29/2021
   //Period: 2


public abstract class Square
{
   //This class exhibits polymorphic behavior and defines the square objects. 
   //The square objects have three different states which are clicked_on, flagged, and untouched. 
   //The first state is untouched and all squares start out this way. 

   boolean is_Mine;
   //The boolean variable is_Mine is true when the square has a mine, and false otherwise.
   public abstract void display();
   
   public static void clicked_on()
   {
      //Whenever a square is interacted with the state changes to clicked_on. 
      //In this state the square opens a menu that allows the user to either flag or reveal the square. 
      //When the square is flagged it transitions into the flagged state.
   }
   
   public static void flagged()
   {
      //This is the state when the square is flagged.
   }
}

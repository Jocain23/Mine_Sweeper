      //Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
   //Last Updated: 5/6/2021
   //Period: 2
   
public class Mine extends Square 
{
   //This class extends the abstract Square class. It represents the state when the square does contain a mine.
   boolean is_Mine = true;
   public void display()
   {
      //This method displays a mine when the square has a mine.
    label1.setText("x");
    Game_Over_Panel Jeff = new Game_Over_Panel();
    return;
   }
}

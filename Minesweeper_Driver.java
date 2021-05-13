/*******************************************************
* Minesweeper_Driver calls everything else and ties the 
*whole game together. It calls all of the panels.
*@author Jonluke O'Cain, Hardeep Mann, Vayun Malik
*@version 1.0
*******************************************************/
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Minesweeper_Driver {
   JFrame frameStartup = null;
   JFrame framePlayboard = null;
   JFrame frameGameOver = null;
   StopWatch timerLabel = null;
   boolean displayIcons = true;
/************************************
* Calls the start up panel
*
***********************************/
   public void showStart_Up_Panel() {
      frameStartup = new JFrame("Mine Sweeper_StartUp");
   	// frameStartup.setSize(500, 150);
      frameStartup.setLocation(150, 100);
      frameStartup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      try {
         frameStartup.setContentPane(new Start_Up_Panel(this));
      } catch (IOException e) {
         e.printStackTrace();
      }
   
      frameStartup.pack();
      frameStartup.setVisible(true);
   }
/************************************
* Hides the start_Up_Panel and calls
* the Playboard_Panel with the varibles
* from start_Up_Panel 
*@param cells number of square to be generated
*@param mines number of mines to be place in the squares
***********************************/
   public void actionfromStart_Up_Panel(int cells, int mines) {
      System.out.println("User Entered: Cells in a side:  " + cells + " Mines: " + mines);
      frameStartup.setVisible(false);
   
      showPlayboard_Panel(cells, mines);
   }
/************************************
* Displays the  Playboard_Panel with the varibles
* for the number of Squares and the Number of Mines.
* Also sets some of the formating for Playboard_Panel 
*and calls StopWatch
*@param cells number of square to be generated
*@param mines number of mines to be place in the squares
************************************/
   public void showPlayboard_Panel(int cells, int mines) {
      if (framePlayboard != null) {
         framePlayboard.setVisible(false);
      }
      framePlayboard = new JFrame("Mine Sweeper_Playboard");
      if (cells < 15) {
         framePlayboard.setSize(800, 600);
      } else {
         framePlayboard.setSize(1024, 720);
         displayIcons = false;
      }
   
      framePlayboard.setLocation(150, 100);
      framePlayboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
   
      JPanel timerPanel = new JPanel();
      timerLabel = new StopWatch();
      timerPanel.add(timerLabel);
      timerLabel.startStopWatch();
   
      Playboard_Panel playboard_Panel = new Playboard_Panel(cells, mines, displayIcons, this);
   
      mainPanel.add(timerPanel);
      mainPanel.add(playboard_Panel);
   
      framePlayboard.setContentPane(mainPanel);
      framePlayboard.setVisible(true);
   
   }
/**************************
*Calls Game_Over_Panel after win conditon
*@param isWinner Tells the game if player won
**************************/
   public void actionPlayboard_Panel(boolean isWinner) {
      System.out.println("actionPlayboard_Panel");
   
      timerLabel.stopStopWatch();
      showGameover_Panel(isWinner);
   }
/**************************
*Displays and formats Game_Over_Panel after win conditon
*@param isWinner Tells the game if player won
**************************/
   public void showGameover_Panel(boolean isWinner) {
   
      System.out.println("showGameover_Panel");
   	// frameStartup.setSize(500, 150);
      frameGameOver = new JFrame("Mine Sweeper_Gameover");
      frameGameOver.setLocation(200, 200);
      frameGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      try {
         frameGameOver.setContentPane(new Game_Over_Panel(this, isWinner));
      } catch (IOException e) {
         e.printStackTrace();
      }
   
      frameGameOver.setAlwaysOnTop(true);
   
      frameGameOver.pack();
      frameGameOver.setVisible(true);
   }
/*******************************************
*Restarts game, calling start_Up_Panel
*@param replay Tells the game if the player wants to play again
*********************************************/
   public void actionfromGameover_Panel(boolean replay) {
      System.out.println("User Entered: to replay:  " + replay);
      frameGameOver.setVisible(false);
   
      if (replay) {
         framePlayboard.setVisible(false);
         frameStartup.setVisible(true);
      }
   }

   public static void main(String[] args) {
   
      Minesweeper_Driver driver = new Minesweeper_Driver();
      driver.showStart_Up_Panel();
   
   }

}

/***************************************************
The playboard panel is the panel where the game takes
place. It recieves the side length and number of mines
from the start up panel, and creates the map accordingly.
At first the map is just many empty squares, but once the
player clicks on their first square it fills the map with
bombs. It also checks for the result of the game and tells
the game over panel accordingly.
@author Hardeep Mann, Jonluke O'Cain and Vayun Malik
@version 1.0
 ****************************************************/
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Playboard_Panel extends JPanel {
   private int cellsInSide = 0;
   private int mines = 0;
   private Square[][] squares;

   private int start_X = -1;
   private int start_Y = -1;
   private int numFlagsUsed = 0;

   private boolean displayIcons = true;
   private Minesweeper_Driver driver;
   private Set<String> checked = new HashSet<String>();

   public Playboard_Panel(int cellsInSide, int mines, boolean displayIcons, Minesweeper_Driver driver) {
      this.driver = driver;
   
      this.cellsInSide = cellsInSide;
      this.mines = mines;
   
      this.displayIcons = displayIcons;
   
      this.setLayout(new BorderLayout());
      Initial_Generate();
   }

   public void Initial_Generate() {
   
   	/// Generates the initial map with each square
   
      squares = new Square[cellsInSide][cellsInSide];
   
      Container grid = new Container();
      grid.setLayout(new GridLayout(cellsInSide, cellsInSide));
   
      for (int x = 0; x < cellsInSide; x++) {
         for (int y = 0; y < cellsInSide; y++) {
            squares[x][y] = new Square(x, y);
            squares[x][y].setFont(new Font("Arial", Font.PLAIN, 12));
            squares[x][y].addActionListener(actionListener);
            squares[x][y].addMouseListener(mouseListener);
            squares[x][y].displayOrig();
            grid.add(squares[x][y]);
         }
      }
   
      this.add(grid, BorderLayout.CENTER);
   }

   public void Final_Generate() {
      Set<String> safeSquareAndMinesLocation = new HashSet<String>();
      safeSquareAndMinesLocation.add(start_X + " " + start_Y);
   
      long seed = System.currentTimeMillis();
      Random randomX = new Random(seed);
      Random randomY = new Random(seed * 2);
   
      int totalMines = 0;
      int numTries = 0;
   
      while (totalMines < mines && numTries < 100000) {
      
         numTries++;
      
         int x = randomX.nextInt(cellsInSide);
         int y = randomY.nextInt(cellsInSide);
      
         if (safeSquareAndMinesLocation.add(x + " " + y)) {
            totalMines++;
            squares[x][y].setIsMine(true);
         } else {
         	// System.out.println("DuplicateMine NOT added "+ mines + " " + totalMines + " "
         	// + x + " " + y);
         }
      }
   
      safeSquareAndMinesLocation.remove(start_X + " " + start_Y);
   
      System.out.println("First selected square at: " + start_X + " " + start_Y);
      System.out.println("Mines are at: " + safeSquareAndMinesLocation.toString());
   }

   private final ActionListener actionListener = 
      actionEvent -> {
         Object source = actionEvent.getSource();
      
         if (start_X == -1) {
            start_X = ((Square) source).getXLoc();
            start_Y = ((Square) source).getYLoc();
         
            Final_Generate();
            Square.updateMinesTochingCount(squares);
         
         /** For debugging purposes only **/
         /*
         for (int x = 0; x < cellsInSide; x++) {
         	for (int y = 0; y < cellsInSide; y++) {
         		squares[x][y].displayForDebug();
         	}
         }
         */
         
            if (((Square) source).getMinesTouching() == 0) {
               lookDisplaySafeSquares(((Square) source));
            } else {
               ((Square) source).display(displayIcons);
               ((Square) source).setEnabled(false);
            }
            System.out.println("FirstTime Square selected : ActionListener Square is: " + ((Square) source).getXLoc()
               + " " + (((Square) source).getYLoc()));
         } else {
         
            if ((((Square) source).getMinesTouching() == 0) && !((Square) source).isMine()) {
               System.out.println("getMinesTouching == 0.........");
               lookDisplaySafeSquares(((Square) source));
               checkPlayboardResults();
            } else {
               ((Square) source).display(displayIcons);
               ((Square) source).setEnabled(false);
               if (((Square) source).isMine()) {
                  System.out.println("HIT the mine.........");
                  disablePlayboard();
                  driver.actionPlayboard_Panel(false);
               } else {
                  System.out.println("DID NOT HIT the mine.........");
                  checkPlayboardResults();
               }
            }
         }
      
      };

   private int checkPlayboardResults() {
      int ret = 1;
   
      outer: for (int x = 0; x < cellsInSide; x++) {
         for (int y = 0; y < cellsInSide; y++) {
            if (squares[x][y].isEnabled()) {
               if (squares[x][y].isFlagged()) {
                  if (squares[x][y].isMine()) {
                  	// System.out.println("Mine flagged properly: " + squares[x][y].toString());
                     ret = 1;
                  } else {
                  	// System.out.println("Mine flagged improperly: " + squares[x][y].toString());
                     ret = 0;
                     break outer;
                  }
               } else {
                  System.out.println("Play on.....");
                  ret = 2;
                  break outer;
               }
            }
         }
      }
   
      if (ret == 0) {
         System.out.println("LOOooOSER");
         disablePlayboard();
         driver.actionPlayboard_Panel(false);
      } else if (ret == 1) {
         System.out.println("WINNER---------------");
         disablePlayboard();
         driver.actionPlayboard_Panel(true);
      } else {
         System.out.println("...... do not give up.......");
      }
   
      return ret;
   }

   private void lookDisplaySafeSquares(Square sq) {
      if (checked.add(sq.toString())) {
      
         sq.setEnabled(false);
         sq.display(displayIcons);
      
         System.out.println("lookDisplaySafeSquares around: " + sq.toString());
      
         Square[] neighbors = Square.squareNeighbors(squares, sq);
         for (int j = 0; j < neighbors.length; j++) {
            if (neighbors[j] != null) {
            	/////////////////////////////////
               if ((neighbors[j].getMinesTouching() != 0) && (!neighbors[j].isMine())
               		&& (!neighbors[j].isFlagged())) {
                  neighbors[j].display(displayIcons);  
                  neighbors[j].setEnabled(false);  
               }
            	/////////////////////////////////
            
               if ((neighbors[j].getMinesTouching() == 0) && (!neighbors[j].isMine())
               		&& neighbors[j].isEnabled()) {
                  lookDisplaySafeSquares(neighbors[j]);
               }
            }
         }
      }
   }

   private void disablePlayboard() {
      for (int x = 0; x < cellsInSide; x++) {
         for (int y = 0; y < cellsInSide; y++) {
            squares[x][y].setEnabled(false);
         }
      }
   }

   MouseListener mouseListener = 
      new MouseAdapter() {
         public void mouseReleased(MouseEvent mouseEvent) {
            Object source = mouseEvent.getSource();
         
            if (SwingUtilities.isRightMouseButton(mouseEvent)) {
               if ((start_X != -1) && (((Square) source).isEnabled())) {
               
                  if (((Square) source).isFlagged()) {
                     ((Square) source).displayOrig();
                     ((Square) source).setFlagged(false);
                     numFlagsUsed--;
                     PlaySound.playSoundFile("sounds_flag.wav", 0);
                  } else {
                     PlaySound.playSoundFile("sounds_flag.wav", 0);
                     if (numFlagsUsed < mines) {
                        ((Square) source).displayFlag(displayIcons);
                        ((Square) source).setFlagged(true);
                        numFlagsUsed++;
                        if (numFlagsUsed == mines) {
                           checkPlayboardResults();
                        }
                     } else {
                        System.out.println("All flags used: " + numFlagsUsed);
                        showMessage("All flags have been used.");
                     }
                  }
               }
            }
            System.out.println();
         }
      };

   private void showMessage(String msg) {
      JOptionPane.showMessageDialog(this, msg);
   }
}

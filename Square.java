/*********************************************************************************
*A square is a Button that maintains information about its location, and whether it is a mine.
*A square has mutiple display states determined by user input and starting conditions. 
*It also knows how to return its location in both the X and Y axis, if its been left flagged or 
*how many Mines are adjacent to it. 
*@author Jonluke O'Cain, Vauyun Malik, Hardeep Mann
*@version 1.0
*********************************************************************************/
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;


public class Square extends JButton {
/***************************************************************************
*contructs a square with booleans is_Mine and is_Flagged false and integers x and y.
*@param x x location
*@param y y location
*@param is_Flagged flagged status
*@param is_Mine    
***************************************************************************/

   private int x = 0;
   private int y = 0;
   private int minesTouching = 0;
   private boolean isFlagged = false;
   private boolean isMine = false;

   Square(int x, int y) {
      this.x = x;
      this.y = y;
   }
 /********************************************
*Returns the Whether the Square is flagged
@return is_Flagged flagged status
********************************************/
   public boolean isFlagged() {
      return isFlagged;
   }
 /********************************************
*Sets the is_Flagged boolean to the input boolean
@param is_Flagged changes flagged status
********************************************/

   public void setFlagged(boolean isFlagged) {
      this.isFlagged = isFlagged;
   }
 /********************************************
*Returns the Whether the Square is a mine
@return is_Mine Mine status
********************************************/
   public boolean isMine() {
      return isMine;
   }
 /********************************************
*Sets the is_Mine boolean to the input boolean
@param is_Mine changes whether is a mine
********************************************/
   public void setIsMine(boolean isMine) {
      this.isMine = isMine;
   }
 /********************************************
*Returns the Square's x location
@return x x location
********************************************/
   public int getXLoc() {
      return x;
   }
 /********************************************
*Tells the Square its x location
@param x x location
********************************************/
   public void setXLoc(int x) {
      this.x = x;
   }
 /********************************************
*Returns the Square's y location
@return y y location
********************************************/
   public int getYLoc() {
      return y;
   }
 /********************************************
*Tells the Square its y location
@param y y location
********************************************/
   public void setYLoc(int y) {
      this.y = y;
   }
 /********************************************
*Returns how many of the surrounding squares have mines
@return minesTouching number of surrounding mines
********************************************/
   public int getMinesTouching() {
      return minesTouching;
   }
 /********************************************
*Tells the Square how many of the surrounding squares have mines
@param minesTouching number of surrounding mines
********************************************/
   public void setMinesTouching(int minesTouching) {
      this.minesTouching = minesTouching;
   }

   boolean isEqual(Square s) {
      boolean ret = false;
      if (((this.x == s.getXLoc()) && (this.y == s.getYLoc()))) {
         ret = true;
      }
      return ret;
   }

   public String toString() {
      String s = "X: " + x + " Y: " + y;
      return s;
   }

	// The boolean variable is_Mine is true when the square has a mine, and false
	// otherwise.
   public void display(boolean displayIcons) {
      this.setIcon(null);
      System.out.println("In function display:Mines Touching:: " + this.getMinesTouching());
      if (isMine) {
         this.setBackground(Color.RED);
         this.setText("M");
         if (displayIcons) {
            try {
               BufferedImage resultImg;
               resultImg = ImageIO.read(this.getClass().getResource("mine_vsmall1.png"));
               Icon icon = new javax.swing.ImageIcon(resultImg);
               this.setIcon(icon);
            } catch (IOException e) {
            	// TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      } else {
         Color grass = new Color(51, 255, 82);
         this.setBackground(grass);
         this.setText(Integer.toString(this.getMinesTouching()));
      }
   
   }

   public void displayForDebug() {
      this.setIcon(null);
   
      System.out.println("In function displayForDebug:Mines Touching:: " + this.getMinesTouching());
   
      if (isMine) {
         this.setBackground(Color.MAGENTA);
         this.setText("M");
      } else {
         this.setBackground(Color.cyan);
         this.setText(Integer.toString(this.getMinesTouching()));
      }
   
   }

   public void displayFlag(boolean displayIcons) {
   
      System.out.println("In function displayFlag:Mines Touching:: " + this.getMinesTouching());
   
      this.setBackground(Color.ORANGE);
      this.setText("F");
      if (displayIcons) {
         try {
            BufferedImage resultImg;
            resultImg = ImageIO.read(this.getClass().getResource("flag4.png"));
            Icon icon = new javax.swing.ImageIcon(resultImg);
            this.setIcon(icon);
         } catch (IOException e) {
         	// TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }

   public void displayOrig() {
      System.out.println("In function displayOrig:Mines Touching: " + this.getMinesTouching());
   
      this.setBackground(Color.LIGHT_GRAY);
      this.setIcon(null);
      this.setText("");
   }

   public void reset() {
      x = y = minesTouching = 0;
      isFlagged = isMine = false;
   }

   public void flagged() {
   	// This is the state when the square is flagged.
   }

   public static Square[] squareNeighbors(Square[][] squares, Square focus) {
   
      int squaresInSide = squares[0].length;
      Square[] myNeighbours = new Square[8];
   
      int focusX = focus.getXLoc();
      int focusY = focus.getYLoc();
   
   	// Row above focus sqaure if any
      int neighborNum = 0;
   
      for (int i = -1; i < 2; i++) {
         int currectY = focusY + i;
         if ((currectY >= 0) && (currectY < squaresInSide)) {
            for (int j = -1; j < 2; j++) {
               int currectX = focusX + j;
               if ((currectX >= 0) && (currectX < squaresInSide)) {
                  if ((currectX == focusX) && (currectY == focusY)) {
                  	// do not count the focus square in
                  } else {
                  	// System.out.println("squareNeighbors: " + currectX + " " + currectY);
                     myNeighbours[neighborNum] = squares[currectX][currectY];
                     neighborNum++;
                  }
               }
            }
         }
      
      }
   
      System.out.print("Focus: " + focus.toString() + "  squareNeighbors: ");
      for (int j = 0; j < myNeighbours.length; j++) {
         if (myNeighbours[j] != null) {
            System.out.print(myNeighbours[j].toString() + "::");
         
         }
      }
      System.out.println();
      return myNeighbours;
   }

   public static void updateMinesTochingCount(Square[][] squares) {
      int cellsInSide = squares[0].length;
      for (int x = 0; x < cellsInSide; x++) {
         for (int y = 0; y < cellsInSide; y++) {
            Square[] neighbors = Square.squareNeighbors(squares, squares[x][y]);
            int mines = 0;
            for (int j = 0; j < neighbors.length; j++) {
               if (neighbors[j] != null) {
                  if (neighbors[j].isMine()) {
                     mines++;
                  }
               }
            }
            squares[x][y].setMinesTouching(mines);
         }
      }
   
   }

}

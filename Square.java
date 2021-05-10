import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;

//Name: Hardeep Mann, Jonluke O`Cain, and Vayun Malik
//Last Updated: 4/29/2021
//Period: 2

public class Square extends JButton {

	// This class exhibits polymorphic behavior and defines the square objects.
	// The square objects have three different states which are clicked_on, flagged,
	// and untouched.
	// The first state is untouched and all squares start out this way.

   private int x = 0;
   private int y = 0;
   private int minesTouching = 0;
   private boolean isFlagged = false;
   private boolean isMine = false;

   Square(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public boolean isFlagged() {
      return isFlagged;
   }

   public void setFlagged(boolean isFlagged) {
      this.isFlagged = isFlagged;
   }

   public boolean isMine() {
      return isMine;
   }

   public void setIsMine(boolean isMine) {
      this.isMine = isMine;
   }

   public int getXLoc() {
      return x;
   }

   public void setXLoc(int x) {
      this.x = x;
   }

   public int getYLoc() {
      return y;
   }

   public void setYLoc(int y) {
      this.y = y;
   }

   public int getMinesTouching() {
      return minesTouching;
   }

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

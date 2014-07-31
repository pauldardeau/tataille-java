// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 * Rect identifies the coordinates and size of a control or window
 * @author paul
 */
public class Rect {
   public int x;
   public int y;
   public int width;
   public int height;
   
   /**
    * Default constructor. Sets position values and size values to 0.
    */
   public Rect() {
      x = 0;
      y = 0;
      width = 0;
      height = 0;
   }
   
   /**
    * Constructs a Rect instance with values for coordinates and size
    * @param xVal the x coordinate position
    * @param yVal the y coordinate position
    * @param widthVal the width
    * @param heightVal the height
    */
   public Rect(int xVal, int yVal, int widthVal, int heightVal) {
      x = xVal;
      y = yVal;
      width = widthVal;
      height = heightVal;
   }
}

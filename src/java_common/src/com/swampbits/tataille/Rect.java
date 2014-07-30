// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 *
 * @author paul
 */
public class Rect {
   public int x;
   public int y;
   public int width;
   public int height;
    
   public Rect() {
      x = 0;
      y = 0;
      width = 0;
      height = 0;
   }
    
   public Rect(int xVal, int yVal, int widthVal, int heightVal) {
      x = xVal;
      y = yVal;
      width = widthVal;
      height = heightVal;
   }
}

// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 *
 * @author paul
 */
public interface DisplayEngineWidget {
   public boolean hideControl();
   public boolean showControl();
   public boolean setControlVisible(boolean isVisible);
    
   public boolean enableControl();
   public boolean disableControl();
   public boolean setControlEnabled(boolean isEnabled);
    
   public boolean setControlSize(int width, int height);
   public boolean setControlPos(int x, int y);
   public boolean setControlRect(Rect rect);
}

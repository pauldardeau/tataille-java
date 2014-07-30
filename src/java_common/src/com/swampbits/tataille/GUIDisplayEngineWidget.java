// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 *
 * @author paul
 */
public abstract class GUIDisplayEngineWidget implements DisplayEngineWidget {
   
   private final ControlId m_cid;
    
   public GUIDisplayEngineWidget(ControlId cid) {
      m_cid = cid;
   }
    
   public ControlId getControlId() {
      return m_cid;
   }
    
   @Override
   public boolean hideControl() {
      return setControlVisible(false);
   }
    
   @Override
   public boolean showControl() {
      return setControlVisible(true);
   }
    
   @Override
   public boolean enableControl() {
      return setControlEnabled(true);
   }
    
   @Override
   public boolean disableControl() {
      return setControlEnabled(false);
   }
    
}

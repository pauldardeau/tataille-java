// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 *
 * @author paul
 */
public abstract class GUIDisplayEngineWidget implements DisplayEngineWidget {
   
   private final ControlInfo m_controlInfo;
    
   public GUIDisplayEngineWidget(ControlInfo controlInfo) {
      m_controlInfo = controlInfo;
   }
   
   public ControlInfo getControlInfo() {
      return m_controlInfo;
   }
    
   public ControlId getControlId() {
      return m_controlInfo.cid;
   }
   
   public boolean isControlType(DisplayEngine.ControlType controlType) {
      if (m_controlInfo != null) {
         return m_controlInfo.controlType == controlType;
      }
      
      return false;
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

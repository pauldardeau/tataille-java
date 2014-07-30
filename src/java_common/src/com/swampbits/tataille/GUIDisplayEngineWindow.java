// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author paul
 */
public abstract class GUIDisplayEngineWindow implements DisplayEngineWindow {
   
   private final int m_windowId;
   private final HashMap<ControlId, GUIDisplayEngineWidget> m_mapIdToControl;
   private final HashMap<String, ArrayList<ControlId>> m_mapGroups;
    
   public GUIDisplayEngineWindow(int windowId) {
      m_windowId = windowId;
      m_mapIdToControl = new HashMap<>();
      m_mapGroups = new HashMap<>();
   }
    
   public boolean registerControl(ControlId cid, GUIDisplayEngineWidget control) {
      m_mapIdToControl.put(cid, control);
      return true;
   }
    
   public void registerGroup(String groupName, ControlId cid) {
      ArrayList<ControlId> listGroupControls = m_mapGroups.get(groupName);
      if (listGroupControls != null) {
         listGroupControls.add(cid);
      } else {
         listGroupControls = new ArrayList<>();
         listGroupControls.add(cid);
         m_mapGroups.put(groupName, listGroupControls);
      }
   }
    
   public ArrayList<ControlId> controlsForGroup(String groupName) {
      return m_mapGroups.get(groupName);
   }
    
   public GUIDisplayEngineWidget controlFromCid(ControlId cid) {
      return m_mapIdToControl.get(cid);
   }
    
   public int getWindowId() {
      return m_windowId;
   }
    
   @Override
   public boolean hideWindow() {
      return setWindowVisible(false);
   }
    
   @Override
   public boolean showWindow() {
      return setWindowVisible(true);
   }
    
   @Override
   public boolean setControlVisible(ControlId cid, boolean isVisible) {
      GUIDisplayEngineWidget control = controlFromCid(cid);
      if (control != null) {
         return control.setControlVisible(isVisible);
      }
      
      return false;
   }
    
   @Override
   public boolean setControlEnabled(ControlId cid, boolean isEnabled) {
      GUIDisplayEngineWidget control = controlFromCid(cid);
      if (control != null) {
         return control.setControlEnabled(isEnabled);
      }
      
      return false;
   }
    
   @Override
   public boolean setGroupVisible(String groupName, boolean isVisible) {
      return false;
   }
    
   @Override
   public boolean setGroupEnabled(String groupName, boolean isEnabled) {
      return false;
   }
    
   @Override
   public boolean setControlSize(ControlId cid, int width, int height) {
      GUIDisplayEngineWidget control = controlFromCid(cid);
      if (control != null) {
         return control.setControlSize(width, height);
      }
      
      return false;
   }
    
   @Override
   public boolean setControlPos(ControlId cid, int x, int y) {
      GUIDisplayEngineWidget control = controlFromCid(cid);
      if (control != null) {
         return control.setControlPos(x, y);
      }
      
      return false;
   }
    
   @Override
   public boolean setControlRect(ControlId cid, Rect rect) {
      GUIDisplayEngineWidget control = controlFromCid(cid);
      if (control != null) {
         return control.setControlRect(rect);
      }
      
      return false;
   }

}

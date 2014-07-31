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
   private final HashMap<ControlId, CheckBoxHandler> m_mapCheckBoxHandlers;
   private final HashMap<ControlId, ListSelectionHandler> m_mapListSelectionHandlers;
   private final HashMap<ControlId, PushButtonHandler> m_mapPushButtonHandlers;
   private final HashMap<ControlId, SliderHandler> m_mapSliderHandlers;
   private final HashMap<ControlId, TabViewHandler> m_mapTabViewHandlers;

   
   public GUIDisplayEngineWindow(int windowId) {
      m_windowId = windowId;
      m_mapIdToControl = new HashMap<>();
      m_mapGroups = new HashMap<>();
      m_mapCheckBoxHandlers = new HashMap<>();
      m_mapListSelectionHandlers = new HashMap<>();
      m_mapPushButtonHandlers = new HashMap<>();
      m_mapSliderHandlers = new HashMap<>();
      m_mapTabViewHandlers = new HashMap<>();
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
   
   @Override
   public boolean setCheckBoxHandler(ControlId cid, CheckBoxHandler handler) {
      GUIDisplayEngineWidget widget = m_mapIdToControl.get(cid);
      if (widget != null) {
         if (widget.isControlType(DisplayEngine.ControlType.CHECK_BOX)) {
            m_mapCheckBoxHandlers.put(cid, handler);
            return true;
         } else {
            // log something
         }
      } else {
         // log something
      }
      
      return false;
   }
   
   @Override
   public boolean setListSelectionHandler(ControlId cid, ListSelectionHandler handler) {
      GUIDisplayEngineWidget widget = m_mapIdToControl.get(cid);
      if (widget != null) {
         if (widget.isControlType(DisplayEngine.ControlType.COMBO_BOX) ||
             widget.isControlType(DisplayEngine.ControlType.LIST_BOX)) {
            m_mapListSelectionHandlers.put(cid, handler);
            return true;
         } else {
            // log something
         }
      } else {
         // log something
      }
      
      return false;
   }
   
   @Override
   public boolean setPushButtonHandler(ControlId cid, PushButtonHandler handler) {
      GUIDisplayEngineWidget widget = m_mapIdToControl.get(cid);
      if (widget != null) {
         if (widget.isControlType(DisplayEngine.ControlType.PUSH_BUTTON)) {
            m_mapPushButtonHandlers.put(cid, handler);
            return true;
         } else {
            // log something
         }
      } else {
         // log something
      }
      
      return false;
   }
   
   @Override
   public boolean setSliderHandler(ControlId cid, SliderHandler handler) {
      GUIDisplayEngineWidget widget = m_mapIdToControl.get(cid);
      if (widget != null) {
         if (widget.isControlType(DisplayEngine.ControlType.SLIDER)) {
            m_mapSliderHandlers.put(cid, handler);
            return true;
         } else {
            // log something
         }
      } else {
         // log something
      }
      
      return false;
   }
   
   @Override
   public boolean setTabViewHandler(ControlId cid, TabViewHandler handler) {
      GUIDisplayEngineWidget widget = m_mapIdToControl.get(cid);
      if (widget != null) {
         if (widget.isControlType(DisplayEngine.ControlType.TAB_VIEW)) {
            m_mapTabViewHandlers.put(cid, handler);
            return true;
         } else {
            // log something
         }
      } else {
         // log something
      }
      
      return false;
   }
   
   public void dispatchPushButtonClicked(ControlId cid) {
      if (cid != null) {
         PushButtonHandler handler = m_mapPushButtonHandlers.get(cid);
         if (handler != null) {
            handler.pushButtonClicked();
         }
      }
   }
   
   public void dispatchCheckBoxToggled(ControlId cid, boolean isChecked) {
      if (cid != null) {
         CheckBoxHandler handler = m_mapCheckBoxHandlers.get(cid);
         if (handler != null) {
            handler.checkBoxToggled(isChecked);
         }
      }
   }
   
   public void dispatchSliderValueChanged(ControlId cid, int selectedValue) {
      if (cid != null) {
         SliderHandler handler = m_mapSliderHandlers.get(cid);
         if (handler != null) {
            handler.valueSelected(selectedValue);
         }
      }
   }
   
   public void dispatchTabViewItemSelected(ControlId cid, int tabIndex, String tabValue) {
      if (cid != null) {
         TabViewHandler handler = m_mapTabViewHandlers.get(cid);
         if (handler != null) {
            handler.tabSelected(tabIndex, tabValue);
         }
      }
   }
   
   public void dispatchListItemSelected(ControlId cid, int selectionIndex, String selectedValue) {
      if (cid != null) {
         ListSelectionHandler handler = m_mapListSelectionHandlers.get(cid);
         if (handler != null) {
            handler.listItemSelected(selectionIndex, selectedValue);
         }
      }
   }

}

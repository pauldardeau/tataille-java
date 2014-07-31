// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author paul
 */
public abstract class GUIDisplayEngine implements DisplayEngine {
   
   private final HashMap<Integer, GUIDisplayEngineWindow> m_mapIdToWindow;
    
   public GUIDisplayEngine() {
      m_mapIdToWindow = new HashMap<>();
   }
    
   @Override
   public String getDisplayEngineLanguage() {
      return "java";
   }
    
   public static List<String> tokenize(String text, String delimiter) {
      StringTokenizer st = new StringTokenizer(text, delimiter);
      ArrayList<String> listTokens = new ArrayList<>(st.countTokens());
        
      while (st.hasMoreTokens()) {
         listTokens.add(st.nextToken());
      }
        
      return listTokens;
   }
    
   public GUIDisplayEngineWindow getWindowForControlInfo(ControlInfo ci) {
      if ((ci != null) && (ci.cid != null)) {
         return getWindowForControlId(ci.cid);
      }
        
      return null;
   }
    
   public GUIDisplayEngineWindow getWindowForControlId(ControlId cid) {
      if (cid != null) {
         return getWindowForId(cid.windowId);
      }
        
      return null;
   }
    
   public GUIDisplayEngineWindow getWindowForId(int windowId) {
      return getWindowForId(new Integer(windowId));
   }
    
   public GUIDisplayEngineWindow getWindowForId(Integer windowId) {
      return m_mapIdToWindow.get(windowId);
   }
    
   public void registerWindow(int windowId, GUIDisplayEngineWindow window) {
      m_mapIdToWindow.put(windowId, window);
   }
    
   @Override
   public boolean setWindowRect(int windowId, Rect rect) {
      GUIDisplayEngineWindow window = getWindowForId(windowId);
      if (window != null) {
         return window.setWindowRect(rect);
      }
      
      return false;
   }
    
   @Override
   public boolean setWindowSize(int windowId, int width, int height) {
      GUIDisplayEngineWindow window = getWindowForId(windowId);
      if (window != null) {
         return window.setWindowSize(width, height);
      }
      
      return false;
   }
    
   @Override
   public boolean setWindowPos(int windowId, int x, int y) {
      GUIDisplayEngineWindow window = getWindowForId(windowId);
      if (window != null) {
         return window.setWindowPos(x, y);
      }
      
      return false;
   }
    
   @Override
   public boolean setWindowVisible(int windowId, boolean isVisible) {
      GUIDisplayEngineWindow window = getWindowForId(windowId);
      if (window != null) {
         return window.setWindowVisible(isVisible);
      }
      
      return false;
   }
    
   @Override
   public boolean setWindowTitle(int windowId, String windowTitle) {
      GUIDisplayEngineWindow window = getWindowForId(windowId);
      if (window != null) {
         return window.setWindowTitle(windowTitle);
      }
      
      return false;
   }
    
   @Override
   public boolean closeWindow(int windowId) {
      GUIDisplayEngineWindow window = getWindowForId(windowId);
      if (window != null) {
         return window.closeWindow();
      }
      
      return false;
   }

   @Override
   public boolean hideWindow(int windowId) {
      return setWindowVisible(windowId, false);
   }
    
   @Override
   public boolean showWindow(int windowId) {
      return setWindowVisible(windowId, true);
   }

   @Override
   public boolean hideControl(ControlId cid) {
      return setControlVisible(cid, false);
   }
    
   @Override
   public boolean showControl(ControlId cid) {
      return setControlVisible(cid, true);
   }
    
   @Override
   public boolean hideGroup(int windowId, String groupName) {
      return setGroupVisible(windowId, groupName, false);
   }
    
   @Override
   public boolean showGroup(int windowId, String groupName) {
      return setGroupVisible(windowId, groupName, true);
   }

   @Override
   public boolean enableControl(ControlId cid) {
      return setControlEnabled(cid, true);
   }
    
   @Override
   public boolean disableControl(ControlId cid) {
      return setControlEnabled(cid, false);
   }
    
   @Override
   public boolean enableGroup(int windowId, String groupName) {
      return setGroupEnabled(windowId, groupName, true);
   }
    
   @Override
   public boolean disableGroup(int windowId, String groupName) {
      return setGroupEnabled(windowId, groupName, false);
   }

   @Override
   public boolean createPushButton(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.PUSH_BUTTON;
         return window.createPushButton(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createStaticText(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.STATIC_TEXT;
         return window.createStaticText(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createEntryField(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.ENTRY_FIELD;
         return window.createEntryField(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createTextView(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.TEXT_VIEW;
         return window.createTextView(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createComboBox(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.COMBO_BOX;
         return window.createComboBox(ci);
      }
      
      return false;   
   }
    
   @Override
   public boolean createListBox(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.LIST_BOX;
         return window.createListBox(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createListView(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.LIST_VIEW;
         return window.createListView(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createTabView(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.TAB_VIEW;
         return window.createTabView(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createPanel(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.PANEL;
         return window.createPanel(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createGroupBox(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.GROUP_BOX;
         return window.createGroupBox(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createSlider(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.SLIDER;
         return window.createSlider(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createCheckBox(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.CHECK_BOX;
         return window.createCheckBox(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createTree(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.TREE;
         return window.createTree(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createProgressBar(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.PROGRESS_BAR;
         return window.createProgressBar(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createImageView(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.IMAGE_VIEW;
         return window.createImageView(ci);
      }
      
      return false;
   }
    
   @Override
   public boolean createPasswordField(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.PASSWORD_FIELD;
         return window.createPasswordField(ci);
      }
      
      return false;
   }

   @Override
   public boolean createHtmlBrowser(ControlInfo ci) {
      GUIDisplayEngineWindow window = this.getWindowForControlInfo(ci);
      if (window != null) {
         ci.controlType = DisplayEngine.ControlType.HTML_BROWSER;
         return window.createHtmlBrowser(ci);
      }
        
      return false;
   }
    
   @Override
   public boolean setControlVisible(ControlId cid, boolean isVisible) {
      GUIDisplayEngineWindow window = this.getWindowForControlId(cid);
      if (window != null) {
         return window.setControlVisible(cid, isVisible);
      }
        
      return false;
   }
    
   @Override
   public boolean setControlEnabled(ControlId cid, boolean isEnabled) {
      GUIDisplayEngineWindow window = this.getWindowForControlId(cid);
      if (window != null) {
         return window.setControlEnabled(cid, isEnabled);
      }
        
      return false;
   }
    
   @Override
   public boolean setGroupVisible(int windowId, String groupName, boolean isVisible) {
      GUIDisplayEngineWindow window = this.getWindowForId(windowId);
      if (window != null) {
         return window.setGroupVisible(groupName, isVisible);
      }

      return false;
   }
    
   @Override
   public boolean setGroupEnabled(int windowId, String groupName, boolean isEnabled) {
      GUIDisplayEngineWindow window = this.getWindowForId(windowId);
      if (window != null) {
         return window.setGroupEnabled(groupName, isEnabled);
      }

      return false;
   }
    
   @Override
   public boolean setControlSize(ControlId cid, int width, int height) {
      GUIDisplayEngineWindow window = this.getWindowForControlId(cid);
      if (window != null) {
         return window.setControlSize(cid, width, height);
      }
        
      return false;
   }
    
   @Override
   public boolean setControlPos(ControlId cid, int x, int y) {
      GUIDisplayEngineWindow window = this.getWindowForControlId(cid);
      if (window != null) {
         return window.setControlPos(cid, x, y);
      }
        
      return false;
    }
    
   @Override
   public boolean setControlRect(ControlId cid, Rect rect) {
      GUIDisplayEngineWindow window = this.getWindowForControlId(cid);
      if (window != null) {
         return window.setControlRect(cid, rect);
      }
        
      return false;
   }
    
}

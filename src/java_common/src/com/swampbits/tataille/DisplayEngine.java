// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 *
 * @author paul
 */
public interface DisplayEngine {
    
   public enum ControlType {
      CHECK_BOX,
      COMBO_BOX,
      ENTRY_FIELD,
      GROUP_BOX,
      HTML_BROWSER,
      IMAGE_VIEW,
      LIST_BOX,
      LIST_VIEW,
      PANEL,
      PASSWORD_FIELD,
      PROGRESS_BAR,
      PUSH_BUTTON,
      SLIDER,
      STATIC_TEXT,
      TAB_VIEW,
      TEXT_VIEW,
      TREE
    };
    
   public static final int ID_MAIN_WINDOW = 0;
   public static final String DEFAULT_VALUES_DELIMITER = ",";
    
   public void run();
    
   public String getDisplayEngineName();
   public String getDisplayEngineTechnology();
   public String getDisplayEngineLanguage();
   public String getDisplayEngineVersion();
    
   public boolean createWindow(int windowId, Rect rect);
   public boolean setWindowRect(int windowId, Rect rect);
   public boolean setWindowSize(int windowId, int width, int height);
   public boolean setWindowPos(int windowId, int x, int y);
   public boolean hideWindow(int windowId);
   public boolean showWindow(int windowId);
   public boolean setWindowVisible(int windowId, boolean isVisible);
   public boolean setWindowTitle(int windowId, String windowTitle);
   public boolean closeWindow(int windowId);

   public boolean createCheckBox(ControlInfo ci);
   public boolean createComboBox(ControlInfo ci);
   public boolean createEntryField(ControlInfo ci);
   public boolean createGroupBox(ControlInfo ci);
   public boolean createHtmlBrowser(ControlInfo ci);
   public boolean createImageView(ControlInfo ci);
   public boolean createListBox(ControlInfo ci);
   public boolean createListView(ControlInfo ci);
   public boolean createPanel(ControlInfo ci);
   public boolean createPasswordField(ControlInfo ci);
   public boolean createProgressBar(ControlInfo ci);
   public boolean createPushButton(ControlInfo ci);
   public boolean createSlider(ControlInfo ci);
   public boolean createStaticText(ControlInfo ci);
   public boolean createTabView(ControlInfo ci);
   public boolean createTextView(ControlInfo ci);
   public boolean createTree(ControlInfo ci);
    
   public boolean hideControl(ControlId cid);
   public boolean showControl(ControlId cid);
   public boolean hideGroup(int windowId, String groupName);
   public boolean showGroup(int windowId, String groupName);
   public boolean setControlVisible(ControlId cid, boolean isVisible);
   public boolean setGroupVisible(int windowId, String groupName, boolean isVisible);
    
   public boolean enableControl(ControlId cid);
   public boolean disableControl(ControlId cid);
   public boolean enableGroup(int windowId, String groupName);
   public boolean disableGroup(int windowId, String groupName);
   public boolean setControlEnabled(ControlId cid, boolean isEnabled);
   public boolean setGroupEnabled(int windowId, String groupName, boolean isEnabled);
    
   public boolean setControlSize(ControlId cid, int width, int height);
   public boolean setControlPos(ControlId cid, int x, int y);
   public boolean setControlRect(ControlId cid, Rect rect);
}

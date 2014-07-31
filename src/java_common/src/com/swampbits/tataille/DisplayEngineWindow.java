// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 *
 * @author paul
 */
public interface DisplayEngineWindow {
   
   public boolean setWindowRect(Rect rect);
   public boolean setWindowSize(int width, int height);
   public boolean setWindowPos(int x, int y);
   public boolean hideWindow();
   public boolean showWindow();
   public boolean setWindowVisible(boolean isVisible);
   public boolean setWindowTitle(String windowTitle);
   public boolean closeWindow();
    
   public boolean setControlVisible(ControlId cid, boolean isVisible);
   public boolean setControlEnabled(ControlId cid, boolean isEnabled);
   public boolean setGroupVisible(String groupName, boolean isVisible);
   public boolean setGroupEnabled(String groupName, boolean isEnabled);
   public boolean setControlSize(ControlId cid, int width, int height);
   public boolean setControlPos(ControlId cid, int x, int y);
   public boolean setControlRect(ControlId cid, Rect rect);

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
    
   public boolean setCheckBoxHandler(ControlId cid, CheckBoxHandler handler);
   public boolean setListSelectionHandler(ControlId cid, ListSelectionHandler handler);
   public boolean setPushButtonHandler(ControlId cid, PushButtonHandler handler);
   public boolean setSliderHandler(ControlId cid, SliderHandler handler);
   public boolean setTabViewHandler(ControlId cid, TabViewHandler handler);

}

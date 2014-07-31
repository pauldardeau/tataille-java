// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille.swt;

import java.util.HashMap;
import org.eclipse.swt.widgets.*;

import com.swampbits.tataille.*;

/**
 *
 * @author paul
 */
public class SWTDisplayEngine extends GUIDisplayEngine implements DisplayEngine
{
   private final HashMap<Integer, SWTDisplayEngineWindow> m_mapIdToWindows;
   private final Display m_display;
   private final SWTDisplayEngineWindow m_mainWindow;
    
    
   public SWTDisplayEngine(int width, int height, String title) {
      m_mapIdToWindows = new HashMap<>();
      m_display = new Display();
      m_mainWindow = new SWTDisplayEngineWindow(this, ID_MAIN_WINDOW);
      m_mainWindow.setWindowSize(width, height);
      m_mainWindow.setWindowTitle(title);
      this.registerWindow(ID_MAIN_WINDOW, m_mainWindow);
   }
    
   @Override
   public void run() {
      if ((m_display != null) && (m_mainWindow != null)) {
         m_mainWindow.run(m_display);
      }
   }
    
   public Display getDisplay() {
      return m_display;
   }
    
   public boolean isMainWindow(SWTDisplayEngineWindow displayEngineWindow) {
      if (displayEngineWindow != null) {
         return ID_MAIN_WINDOW == displayEngineWindow.getWindowId();
      }
        
      return false;
   }
    
   @Override
   public String getDisplayEngineName() {
      return "SWTDisplayEngine";
   }
    
   @Override
   public String getDisplayEngineTechnology() {
      return "Java SWT";
   }
    
   @Override
   public String getDisplayEngineVersion() {
      return "0.1";
   }
    
   @Override
   public boolean createWindow(int windowId, Rect rect) {
      //TODO: implement createWindow
      return false;
   }
    
   public void deregisterWindow(SWTDisplayEngineWindow displayEngineWindow) {
      if (displayEngineWindow != null) {
         Integer windowId = displayEngineWindow.getWindowId();
         if (m_mapIdToWindows.containsKey(windowId)) {
            m_mapIdToWindows.remove(windowId);
         }
      }
   }

}

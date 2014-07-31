// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille.swing;

import java.util.HashMap;

import javax.swing.*;

import com.swampbits.tataille.*;

/**
 *
 * @author paul
 */
public class SwingDisplayEngine extends GUIDisplayEngine implements DisplayEngine
{
   private final HashMap<Integer, SwingDisplayEngineWindow> m_mapIdToWindows;
   private final SwingDisplayEngineWindow m_mainWindow;

   public SwingDisplayEngine(int width, int height, String title) {
      m_mapIdToWindows = new HashMap<>();
      m_mainWindow = new SwingDisplayEngineWindow(this, ID_MAIN_WINDOW);
      m_mainWindow.setWindowSize(width, height);
      m_mainWindow.setWindowTitle(title);
      this.registerWindow(ID_MAIN_WINDOW, m_mainWindow);
   }
    
   @Override
   public void run() {
javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               JFrame.setDefaultLookAndFeelDecorated(true);
               m_mainWindow.setWindowVisible(true);
               
               /*
               m_frame = new JFrame( DEFAULT_TITLE );
               m_panel = new JPanel();
               m_panel.setLayout( null );
               m_frame.getContentPane().add( m_panel );
               m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               m_frame.addComponentListener( m_frameResizeListener );
               setWindowSize( 350, 400 );
               setup();
               m_isStarting = false;
               m_frame.setVisible( true );
               m_frame.addWindowListener( m_windowListener );
               m_frame.addKeyListener( m_windowKeyListener );
                       */
            }
        });
   }
    
   @Override
   public String getDisplayEngineName() {
      return "SwingDisplayEngine";
   }
    
   @Override
   public String getDisplayEngineTechnology() {
      return "Java Swing";
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
    
   public SwingDisplayEngineWindow swingWindowFromId(int windowId) {
      GUIDisplayEngineWindow window = this.getWindowForId(windowId);
      if (window != null) {
         return (SwingDisplayEngineWindow) window;
      }
        
      return null;
   }    

}

// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille.swing;

import java.util.ArrayList;
import java.util.HashMap;

import java.awt.event.*;
import javax.swing.SwingConstants;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.JTree;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;

import com.swampbits.tataille.ControlId;
import com.swampbits.tataille.ControlInfo;
import com.swampbits.tataille.DisplayEngine;
import com.swampbits.tataille.DisplayEngineWindow;
import com.swampbits.tataille.GUIDisplayEngineWindow;
import com.swampbits.tataille.Rect;


class PushButtonListener implements ActionListener {
   private final SwingDisplayEngineWindow m_deWindow;
   
   public PushButtonListener(SwingDisplayEngineWindow deWindow) {
      m_deWindow = deWindow;
   }
   @Override
   public void actionPerformed(ActionEvent event) {
      JButton button = (JButton) event.getSource();
      m_deWindow.pushButtonClicked(button);
   }
}

/**
 *
 * @author paul
 */
public class SwingDisplayEngineWindow extends GUIDisplayEngineWindow implements DisplayEngineWindow
{
   private final JFrame m_swingFrame;
   private final JPanel m_panel;
   private final SwingDisplayEngine m_displayEngine;
   private final HashMap<JComponent, ControlId> m_mapComponentToCid;
   
    
   public SwingDisplayEngineWindow(SwingDisplayEngine displayEngine, int windowId) {
      super(windowId);
      m_displayEngine = displayEngine;
      m_swingFrame = new JFrame("Swing!");
      m_swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      m_panel = new JPanel();
      m_panel.setLayout(null);
      m_swingFrame.getContentPane().add(m_panel);
      m_mapComponentToCid = new HashMap<>();
   }
    
   public static int swingOrientationForControl(ControlInfo ci) {
      if (ci != null) {
         int orient;
            
         if (ci.rect.height > ci.rect.width) {
            orient = SwingConstants.VERTICAL;
         } else {
            orient = SwingConstants.HORIZONTAL;
         }
            
         return orient;
      }
        
      return SwingConstants.HORIZONTAL;
   }
    
   public void pushButtonClicked(JButton button) {
      System.out.println("push button clicked");
      ControlId cid = m_mapComponentToCid.get(button);
      if (cid != null) {
         
      }
   }
    
   @Override
   public boolean setWindowRect(Rect rect) {
      if (m_swingFrame != null) {
         m_swingFrame.setBounds(rect.x, rect.y, rect.width, rect.height);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean setWindowSize(int width, int height) {
      if (m_swingFrame != null) {
         m_swingFrame.setSize(width, height);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean setWindowPos(int x, int y) {
      if (m_swingFrame != null) {
         m_swingFrame.setLocation(x, y);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean setWindowVisible(boolean isVisible) {
      if (m_swingFrame != null) {
         m_swingFrame.setVisible(isVisible);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean setWindowTitle(String windowTitle) {
      if (m_swingFrame != null) {
         m_swingFrame.setTitle(windowTitle);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean closeWindow() {
      if (m_swingFrame != null) {
         m_swingFrame.dispatchEvent(new WindowEvent(m_swingFrame, WindowEvent.WINDOW_CLOSING));
         return true;
      }
        
      return false;
   }
    
   public boolean initializeControl(JComponent component, ControlInfo ci) {
      SwingDisplayEngineWidget w = new SwingDisplayEngineWidget(component, ci.cid);
      component.setBounds(ci.rect.x, ci.rect.y, ci.rect.width, ci.rect.height);
        
      if ((ci.helpCaption != null) && (ci.helpCaption.length() > 0)) {
         component.setToolTipText(ci.helpCaption);
      }
        
      if (!ci.isEnabled) {
         component.setEnabled(false);
      }
        
      if (!ci.isVisible) {
         component.setVisible(false);
      }
        
      if (ci.haveGroupName()) {
         registerGroup(ci.groupName, ci.cid);
      }

      m_panel.add(component);
      m_mapComponentToCid.put(component, ci.cid);

      return registerControl(ci.cid, w);
   }
    
   @Override
   public boolean createPushButton(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JButton button;
            
         if (ci.haveText()) {
            button = new JButton(ci.text);
         } else {
            button = new JButton();
         }
            
         button.addActionListener(new PushButtonListener(this));

         return initializeControl(button, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createStaticText(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JLabel label;
            
         if (ci.haveText()) {
            label = new JLabel(ci.text);
         } else {
            label = new JLabel();
         }

         return initializeControl(label, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createEntryField(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JTextField textField;
            
         if (ci.haveText()) {
            textField = new JTextField(ci.text);
         } else {
            textField = new JTextField();
         }
            
         return initializeControl(textField, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createTextView(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JTextArea textArea;
            
         if (ci.haveText()) {
            textArea = new JTextArea(ci.text);
         } else {
            textArea = new JTextArea();
         }
            
         return initializeControl(textArea, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createComboBox(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JComboBox comboBox;
            
         if (ci.haveValues()) {
            comboBox = new JComboBox(ci.getValues(DisplayEngine.DEFAULT_VALUES_DELIMITER).toArray());
         } else {
            comboBox = new JComboBox();
         }
            
         //TODO: setup selection listener
            
         return initializeControl(comboBox, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createListBox(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JList list;
            
         if (ci.haveValues()) {
            list = new JList(ci.getValues(DisplayEngine.DEFAULT_VALUES_DELIMITER).toArray());
         } else {
            list = new JList();
         }
            
         JScrollPane scrollPane = new JScrollPane(list);
            
         //TODO: setup selection listener
            
         return initializeControl(list, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createListView(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JTable table = new JTable();
            
         if (ci.haveValues()) {
            table.setModel(new TatailleTableModel(ci.values));
         }

         JScrollPane scrollPane = new JScrollPane(table);
            
         return initializeControl(table, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createTabView(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JTabbedPane tabbedPane = new JTabbedPane();
         if (ci.haveValues()) {
            ArrayList<String> tabNames = ci.getValues(DisplayEngine.DEFAULT_VALUES_DELIMITER);
            final int numberTabs = tabNames.size();
                
            JPanel panel;
                
            for (int i = 0; i < numberTabs; ++i) {
               panel = new JPanel();
               panel.setLayout(null);
               tabbedPane.add(tabNames.get(i), panel);
            }
         }
            
         //TODO: set up change listener
            
         return initializeControl(tabbedPane, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createPanel(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JPanel panel = new JPanel();
         return initializeControl(panel, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createGroupBox(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JPanel panel = new JPanel();
            
         if (ci.haveText()) {
            panel.setBorder(BorderFactory.createTitledBorder(ci.text));
         }
            
         return initializeControl(panel, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createSlider(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JSlider slider = new JSlider(swingOrientationForControl(ci), 0, 100, 0);
         return initializeControl(slider, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createCheckBox(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         
         JCheckBox checkBox;
         
         if (ci.haveText()) {
            checkBox = new JCheckBox(ci.text);
         } else {
            checkBox = new JCheckBox();
         }
            
         if (ci.isSelected) {
            checkBox.setSelected(true);
         }
            
         return initializeControl(checkBox, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createTree(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         //TODO: implement createTree
      }
        
      return false;
   }
    
   @Override
   public boolean createProgressBar(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JProgressBar progressBar = new JProgressBar(swingOrientationForControl(ci), 0, 100);
         return initializeControl(progressBar, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createImageView(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         //TODO: implement createImageView
      }
        
      return false;
   }
    
   @Override
   public boolean createPasswordField(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         JPasswordField passwordField = new JPasswordField();
         return initializeControl(passwordField, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createHtmlBrowser(ControlInfo ci) {
      if ((ci != null) && (m_swingFrame != null)) {
         //TODO: implement createHtmlBrowser
      }
        
      return false;
   }
}

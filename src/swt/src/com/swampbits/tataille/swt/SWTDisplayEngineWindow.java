// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille.swt;

import java.util.ArrayList;

import org.eclipse.swt.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;

import com.swampbits.tataille.ControlInfo;
import com.swampbits.tataille.DisplayEngine;
import com.swampbits.tataille.DisplayEngineWindow;
import com.swampbits.tataille.GUIDisplayEngineWindow;
import com.swampbits.tataille.Rect;


// https://www.eclipse.org/swt/widgets/
// http://www.mkyong.com/tag/swt/

/**
 *
 * @author paul
 */
public class SWTDisplayEngineWindow extends GUIDisplayEngineWindow
                                    implements DisplayEngineWindow,
                                               ShellListener
{
   private Shell m_shell;
   private final SWTDisplayEngine m_displayEngine;
   private final Composite m_panel;
    
   public SWTDisplayEngineWindow(SWTDisplayEngine displayEngine, int windowId) {
      super(windowId);
      m_displayEngine = displayEngine;
      m_shell = new Shell(displayEngine.getDisplay(), SWT.SHELL_TRIM);
      m_panel = new Composite(m_shell, SWT.NONE);
   }
    
   public void run(Display display) {
      m_shell.open();
        
      while (!m_shell.isDisposed()) {
         if (!display.readAndDispatch()) {
            display.sleep();
         }
      }
   }
    
   @Override
   public void shellActivated(ShellEvent e) {
        
   }
    
   @Override
   public void shellClosed(ShellEvent e) {
      m_shell = null;
      m_displayEngine.deregisterWindow(this);
   }

   @Override
   public void shellDeactivated(ShellEvent e) {
        
   }

   @Override
   public void shellDeiconified(ShellEvent e) {
        
   }

   @Override
   public void shellIconified(ShellEvent e) {
        
   }

   @Override
   public boolean setWindowRect(Rect rect) {
      if (m_shell != null) {
         m_shell.setBounds(rect.x, rect.y, rect.width, rect.height);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean setWindowSize(int width, int height) {
      if (m_shell != null) {
         m_shell.setSize(width, height);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean setWindowPos(int x, int y) {
      if (m_shell != null) {
         m_shell.setLocation(x, y);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean setWindowVisible(boolean isVisible) {
      if (m_shell != null) {
         m_shell.setVisible(isVisible);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean setWindowTitle(String windowTitle) {
      if (m_shell != null) {
         m_shell.setText(windowTitle);
         return true;
      }
        
      return false;
   }
    
   @Override
   public boolean closeWindow() {
      if (m_shell != null) {
         m_shell.close();
         m_shell.dispose();
         m_shell = null;
         m_displayEngine.deregisterWindow(this);
         return true;
      }
        
      return false;
   }
    
   public boolean initializeControl(Control control, ControlInfo ci) {
      SWTDisplayEngineWidget w = new SWTDisplayEngineWidget(control, ci);
      control.setBounds(ci.rect.x, ci.rect.y, ci.rect.width, ci.rect.height);
        
      if (ci.haveHelpCaption()) {
         control.setToolTipText(ci.helpCaption);
      }
        
      if (ci.haveGroupName()) {
         registerGroup(ci.groupName, ci.cid);
      }
        
      control.setVisible(ci.isVisible);
        
      return registerControl(ci.cid, w);
   }
    
   public Composite getParent(ControlInfo ci) {
      if (ci.cid.parentId == -1) {
         return m_panel; // m_shell
      } else {
         //TODO: lookup the parent control using the parent ID
      }
      
      return null;
   }
    
   public int getOrientation(ControlInfo ci) {
      if (ci.rect.width > ci.rect.height) {
         return SWT.HORIZONTAL;
      } else {
         return SWT.VERTICAL;
      }
   }
    
   @Override
   public boolean createPushButton(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Button button = new Button(getParent(ci), SWT.PUSH);
            
         if (ci.haveText()) {
            button.setText(ci.text);
         }
            
         return initializeControl(button, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createStaticText(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Text text = new Text(getParent(ci), SWT.NONE);
            
         if (ci.haveText()) {
            text.setText(ci.text);
         }

         return initializeControl(text, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createEntryField(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Text text = new Text(getParent(ci), SWT.BORDER);
            
         if (ci.haveText()) {
            text.setText(ci.text);
         }

         return initializeControl(text, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createTextView(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Text text = new Text(getParent(ci), SWT.MULTI);
            
         if (ci.haveText()) {
            text.setText(ci.text);
         }
            
         return initializeControl(text, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createComboBox(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Combo combo = new Combo(getParent(ci), SWT.DROP_DOWN);

         if (ci.haveValues()) {
            ArrayList<String> listValues =
                        ci.getValues(DisplayEngine.DEFAULT_VALUES_DELIMITER);
            final int numberValues = listValues.size();
                
            for (int i = 0; i < numberValues; ++i) {
               combo.add(listValues.get(i));
            }
         }
            
         //TODO: add selection listener
            
         return initializeControl(combo, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createListBox(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         List list = new List(getParent(ci), SWT.SINGLE);
            
         if (ci.haveValues()) {
            ArrayList<String> listValues =
                        ci.getValues(DisplayEngine.DEFAULT_VALUES_DELIMITER);
            final int numberValues = listValues.size();
                
            for (int i = 0; i < numberValues; ++i) {
               list.add(listValues.get(i));
            }
         }
            
         //TODO: add selection listener
            
         return initializeControl(list, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createListView(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Table table = new Table(getParent(ci), SWT.BORDER | SWT.FULL_SELECTION);
            
         if (ci.haveValues()) {
            ArrayList<String> listValues =
                        ci.getValues(DisplayEngine.DEFAULT_VALUES_DELIMITER);
            final int numberValues = listValues.size();
                
            for (int i = 0; i < numberValues; ++i) {
               TableColumn column = new TableColumn(table, SWT.NONE);
               column.setText(listValues.get(i));
            }
         }
            
         //TODO: add selection listener
            
         return initializeControl(table, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createTabView(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         TabFolder tabFolder = new TabFolder(getParent(ci), SWT.NONE);
            
         return initializeControl(tabFolder, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createPanel(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Composite composite = new Composite(getParent(ci), SWT.NONE);
            
         return initializeControl(composite, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createGroupBox(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Group group = new Group(getParent(ci), SWT.SHADOW_ETCHED_IN);
            
         if (ci.haveText()) {
            group.setText(ci.text);
         }
            
         return initializeControl(group, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createSlider(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Scale scale = new Scale(getParent(ci), getOrientation(ci));
         scale.setMinimum(0);
         scale.setMaximum(100);
            
         return initializeControl(scale, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createCheckBox(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Button checkBox = new Button(getParent(ci), SWT.CHECK);
            
         if (ci.isSelected) {
            checkBox.setSelection(true);
         }
            
         return initializeControl(checkBox, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createTree(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Tree tree = new Tree(getParent(ci), SWT.VIRTUAL | SWT.BORDER);
            
         //TODO: populate tree
            
         return initializeControl(tree, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createProgressBar(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         ProgressBar progressBar = new ProgressBar(getParent(ci), getOrientation(ci));
            
         return initializeControl(progressBar, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createImageView(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         //TODO: implement createImageView
      }
        
      return false;
   }
    
   @Override
   public boolean createPasswordField(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Text text = new Text(getParent(ci), SWT.BORDER | SWT.PASSWORD);
            
         if (ci.haveText()) {
            text.setText(ci.text);
         }

         return initializeControl(text, ci);
      }
        
      return false;
   }
    
   @Override
   public boolean createHtmlBrowser(ControlInfo ci) {
      if ((ci != null) && (m_shell != null)) {
         Browser browser = new Browser(getParent(ci), SWT.NONE);
            
         if (ci.haveText()) {
            if (ci.text.startsWith("<")) {
               browser.setText(ci.text);
            } else {
               browser.setUrl(ci.text);
            }
         }
            
         return initializeControl(browser, ci);
      }
        
      return false;
   }
}

// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille.test;

import com.swampbits.tataille.ControlId;
import com.swampbits.tataille.ControlInfo;
import com.swampbits.tataille.DisplayEngine;
import com.swampbits.tataille.Rect;

/**
 *
 * @author paul
 */
public class TatailleTester {
   
   private static final int LEFT_EDGE = 25;
   private static final int TOP = 15;
   private static final int LBL_CUSTOMER_WIDTH = 65;
   private static final int LBL_CUSTOMER_HEIGHT = 30;
   private static final int EF_CUSTOMER_WIDTH = 200;
   private static final int EF_CUSTOMER_HEIGHT = 30;
   private static final int LIST_WIDTH = 130;
   private static final int LIST_HEIGHT = 270;
   private static final int LISTVIEW_WIDTH = 325;
   private static final int LISTVIEW_HEIGHT = LIST_HEIGHT;
   private static final int BUTTON_WIDTH = 120;
   private static final int BUTTON_HEIGHT = 32;
   private static final String VALUES_DELIMITER = ",";

   
   private final DisplayEngine m_de;
   private ControlId m_cidCustomerLabel;
   private ControlId m_cidEntryField;
   private ControlId m_cidListBox;
   private ControlId m_cidListView;
   private ControlId m_cidPushButton;
   
   
   public TatailleTester(DisplayEngine displayEngine) {
      m_de = displayEngine;
   }
   
   public void run() {
      ControlInfo ci;
      int windowId = DisplayEngine.ID_MAIN_WINDOW;
      int controlId = 0;
      int x = LEFT_EDGE;
      int y = TOP;
      
      m_cidCustomerLabel = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidCustomerLabel);
      ci.rect = new Rect(x, y, LBL_CUSTOMER_WIDTH, LBL_CUSTOMER_HEIGHT);
      ci.text = "Customer:";
      m_de.createStaticText(ci);
      
      x += LBL_CUSTOMER_WIDTH;
      x += 10;
      
      m_cidEntryField = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidEntryField);
      ci.rect = new Rect(x, y, EF_CUSTOMER_WIDTH, EF_CUSTOMER_HEIGHT);
      m_de.createEntryField(ci);
      
      x = LEFT_EDGE;
      y += EF_CUSTOMER_HEIGHT;
      y += 15;
      
      m_cidListBox = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidListBox);
      ci.rect = new Rect(x, y, LIST_WIDTH, LIST_HEIGHT);
      ci.values = "Cheeseburger,Chips,Drink,French Fries,Grilled Cheese,Hamburger,Hot Dog,Peanuts";
      ci.valuesDelimiter = VALUES_DELIMITER;
      m_de.createListBox(ci);
      
      x += LIST_WIDTH;
      x += 30;
      
      m_cidListView = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidListView);
      ci.rect = new Rect(x, y, LISTVIEW_WIDTH, LISTVIEW_HEIGHT);
      ci.values = "Peanuts,Popcorn,Chips";
      ci.valuesDelimiter = VALUES_DELIMITER;
      m_de.createListView(ci);
      
      y += LISTVIEW_HEIGHT;
      y += 30;
      
      m_cidPushButton = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidPushButton);
      ci.rect = new Rect(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
      ci.text = "Place Order";
      m_de.createPushButton(ci);
      
      m_de.run();
   }
    
}

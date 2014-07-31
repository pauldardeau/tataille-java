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
   
   private static final int BUTTON_WIDTH = 120;
   private static final int BUTTON_HEIGHT = 33;
   private static final int LABEL_HEIGHT = 30;
   private static final int LEFT_EDGE = 25;
   private static final int TOP = 15;
   private static final int LBL_CUSTOMER_WIDTH = 65;
   private static final int LBL_CUSTOMER_HEIGHT = LABEL_HEIGHT;
   private static final int EF_CUSTOMER_WIDTH = 200;
   private static final int EF_CUSTOMER_HEIGHT = 30;
   private static final int CK_DELIVERY_WIDTH = 100;
   private static final int CK_DELIVERY_HEIGHT = 30;
   private static final int CK_RUSH_WIDTH = 100;
   private static final int CK_RUSH_HEIGHT = 30;
   private static final int LIST_WIDTH = 130;
   private static final int LIST_HEIGHT = 270;
   private static final int LISTVIEW_WIDTH = 325;
   private static final int LISTVIEW_HEIGHT = LIST_HEIGHT;
   private static final int BTN_ADD_WIDTH = BUTTON_WIDTH;
   private static final int BTN_ADD_HEIGHT = BUTTON_HEIGHT;
   private static final int BTN_REMOVE_WIDTH = BUTTON_WIDTH;
   private static final int BTN_REMOVE_HEIGHT = BUTTON_HEIGHT;
   private static final int BTN_ORDER_WIDTH = BUTTON_WIDTH;
   private static final int BTN_ORDER_HEIGHT = BUTTON_HEIGHT;
   private static final int LBL_ORDERTOTAL_WIDTH = 65;
   private static final int LBL_ORDERTOTAL_HEIGHT = LABEL_HEIGHT;
   private static final String VALUES_DELIMITER = ",";

   
   private final DisplayEngine m_de;
   private ControlId m_cidCustomerLabel;
   private ControlId m_cidEntryField;
   private ControlId m_cidCheckDelivery;
   private ControlId m_cidCheckRush;
   private ControlId m_cidListBox;
   private ControlId m_cidListView;
   private ControlId m_cidAddButton;
   private ControlId m_cidRemoveButton;
   private ControlId m_cidOrderButton;
   private ControlId m_cidOrderTotal;
   
   
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
      
      x += EF_CUSTOMER_WIDTH;
      x += 20;
      
      m_cidCheckDelivery = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidCheckDelivery);
      ci.rect = new Rect(x, y, CK_DELIVERY_WIDTH, CK_DELIVERY_HEIGHT);
      ci.text = "Delivery";
      ci.helpCaption = "check if this order is for delivery";
      m_de.createCheckBox(ci);

      x += CK_DELIVERY_WIDTH;
      x += 20;
      
      m_cidCheckRush = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidCheckRush);
      ci.rect = new Rect(x, y, CK_RUSH_WIDTH, CK_RUSH_HEIGHT);
      ci.text = "Rush";
      ci.helpCaption = "check if this is a rush order";
      m_de.createCheckBox(ci);
      
      x += CK_RUSH_WIDTH;
      x += 15;
      
      m_cidOrderTotal = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidOrderTotal);
      ci.rect = new Rect(x, y, LBL_ORDERTOTAL_WIDTH, LBL_ORDERTOTAL_HEIGHT);
      ci.text = "0.00";
      ci.helpCaption = "total cost of order";
      m_de.createStaticText(ci);

      x = LEFT_EDGE;
      y += EF_CUSTOMER_HEIGHT;
      y += 15;
      
      m_cidListBox = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidListBox);
      ci.rect = new Rect(x, y, LIST_WIDTH, LIST_HEIGHT);
      ci.values = "Cheeseburger,Chips,Drink,French Fries,Grilled Cheese,Hamburger,Hot Dog,Peanuts";
      ci.valuesDelimiter = VALUES_DELIMITER;
      ci.helpCaption = "list of items available for order";
      m_de.createListBox(ci);
      
      x += LIST_WIDTH;
      x += 30;
      
      m_cidListView = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidListView);
      ci.rect = new Rect(x, y, LISTVIEW_WIDTH, LISTVIEW_HEIGHT);
      ci.values = "Qty,Item,Price";
      ci.valuesDelimiter = VALUES_DELIMITER;
      ci.helpCaption = "list of items on order";
      m_de.createListView(ci);
      
      y += LISTVIEW_HEIGHT;
      y += 30;
      
      x = LEFT_EDGE;

      m_cidAddButton = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidAddButton);
      ci.rect = new Rect(x, y, BTN_ADD_WIDTH, BTN_ADD_HEIGHT);
      ci.text = "Add Item";
      //ci.isEnabled = false;
      m_de.createPushButton(ci);

      x += LIST_WIDTH;
      x += 30;
      
      m_cidRemoveButton = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidRemoveButton);
      ci.rect = new Rect(x, y, BTN_REMOVE_WIDTH, BTN_REMOVE_HEIGHT);
      ci.text = "Remove Item";
      ci.isEnabled = false;
      m_de.createPushButton(ci);
      
      x += 150;

      m_cidOrderButton = new ControlId(windowId, controlId++);
      ci = new ControlInfo(m_cidOrderButton);
      ci.rect = new Rect(x, y, BTN_ORDER_WIDTH, BTN_ORDER_HEIGHT);
      ci.text = "Place Order";
      ci.isEnabled = false;
      m_de.createPushButton(ci);
      
      m_de.run();
   }
    
}

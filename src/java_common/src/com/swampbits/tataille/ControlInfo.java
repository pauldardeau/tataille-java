// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class ControlInfo {
   public DisplayEngine.ControlType controlType;
   public ControlId cid;
   public String controlName;
   public String groupName;
   public String text;
   public String helpCaption;
   public String values;
   public String valuesDelimiter;
   public Rect rect;
   public boolean isSelected;
   public boolean isVisible;
   public boolean isEnabled;
    
    
   public ControlInfo() {
      isSelected = false;
      isVisible = true;
      isEnabled = true;
   }
    
   public ControlInfo(ControlId cid) {
      this.cid = cid;
      isSelected = false;
      isVisible = true;
      isEnabled = true;
   }
    
   public static boolean haveStringValue(String s) {
      return ((s != null) && (s.length() > 0));
   }

   public ArrayList<String> getValues(String defaultDelimiter) {
      String delimiter = defaultDelimiter;
                
      if (haveValuesDelimiter()) {
         delimiter = valuesDelimiter;
      }
                
      return GUIDisplayEngine.tokenize(values, delimiter);
   }
    
   public boolean haveGroupName() {
      return haveStringValue(groupName);
   }
    
   public boolean haveControlName() {
      return haveStringValue(controlName);
   }
    
   public boolean haveHelpCaption() {
      return haveStringValue(helpCaption);
   }
    
   public boolean haveText() {
      return haveStringValue(text);
   }
    
   public boolean haveValues() {
      return haveStringValue(values);
   }
    
   public boolean haveValuesDelimiter() {
      return haveStringValue(valuesDelimiter);
   }
}

// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

import java.util.List;


/**
 * ControlInfo is a data structure that holds parameters for a graphical control
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
    
   
   /**
    * Default constructor
    */
   public ControlInfo() {
      isSelected = false;
      isVisible = true;
      isEnabled = true;
   }
   
   /**
    * Constructs a ControlInfo instance using the ControlId
    * @param cid the control identifiers for the control
    */
   public ControlInfo(ControlId cid) {
      this.cid = cid;
      isSelected = false;
      isVisible = true;
      isEnabled = true;
   }
   
   /**
    * Determines if a string value is non-null and non-empty
    * @param s the string to examine
    * @return boolean indicating if string is non-null and non-empty
    */
   public static boolean haveStringValue(String s) {
      return ((s != null) && (s.length() > 0));
   }

   /**
    * Retrieves the parsed list of values with the specified delimiter
    * if no other delimiter is present.
    * @param defaultDelimiter the default delimiter for parsing, if none is specified
    * @return the parsed list of values for the control
    */
   public List<String> getValues(String defaultDelimiter) {
      String delimiter = defaultDelimiter;
                
      if (haveValuesDelimiter()) {
         delimiter = valuesDelimiter;
      }
                
      return GUIDisplayEngine.tokenize(values, delimiter);
   }
   
   /**
    * Determines if a non-null, non-empty value is present for group name
    * @return boolean indicating if the field is non-null and non-empty
    */
   public boolean haveGroupName() {
      return haveStringValue(groupName);
   }
   
   /**
    * Determines if a non-null, non-empty value is present for control name
    * @return boolean indicating if the field is non-null and non-empty
    */
   public boolean haveControlName() {
      return haveStringValue(controlName);
   }
   
   /**
    * Determines if a non-null, non-empty value is present for help caption
    * @return boolean indicating if the field is non-null and non-empty
    */
   public boolean haveHelpCaption() {
      return haveStringValue(helpCaption);
   }
   
   /**
    * Determines if a non-null, non-empty value is present for control text
    * @return boolean indicating if the field is non-null and non-empty
    */
   public boolean haveText() {
      return haveStringValue(text);
   }
   
   /**
    * Determines if a non-null, non-empty value is present for control values
    * @return boolean indicating if the field is non-null and non-empty
    */
   public boolean haveValues() {
      return haveStringValue(values);
   }
   
   /**
    * Determines if a non-null, non-empty value is present for values delimiter
    * @return boolean indicating if the field is non-null and non-empty
    */
   public boolean haveValuesDelimiter() {
      return haveStringValue(valuesDelimiter);
   }
}

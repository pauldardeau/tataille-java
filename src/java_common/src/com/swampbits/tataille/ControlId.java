// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 * A ControlId instance contains the identifiers that uniquely identify a control.
 * Every window has an numeric ID. Each control belongs to a window and each
 * control has its own numeric ID. Controls can be nested, so a parent ID is
 * provided. The parent ID is optional.
 * @author paul
 */
public class ControlId {
   
   public int windowId;
   public int controlId;
   public int parentId;

   /**
    * Default constructor
    */
   public ControlId() {
      windowId = -1;
      controlId = -1;
      parentId = -1;
   }
   
   /**
    * Constructs a ControlId for a non-nested control
    * @param aWindowId the identifier of the window that owns the control
    * @param aControlId the identifier of the control
    */
   public ControlId(int aWindowId, int aControlId) {
      windowId = aWindowId;
      controlId = aControlId;
      parentId = -1;
   }
   
   /**
    * Constructs a ControlId for a nested control
    * @param aWindowId the identifier of the window that owns the control
    * @param aControlId the identifier of the control
    * @param aParentId the identifier of the parent control (in the same window)
    */
   public ControlId(int aWindowId, int aControlId, int aParentId) {
      windowId = aWindowId;
      controlId = aControlId;
      parentId = aParentId;
   }

}

// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille;

/**
 *
 * @author paul
 */
public class ControlId {
   
   public int windowId;
   public int controlId;
   public int parentId;

   public ControlId() {
      windowId = -1;
      controlId = -1;
      parentId = -1;
   }
    
   public ControlId(int aWindowId, int aControlId) {
      windowId = aWindowId;
      controlId = aControlId;
      parentId = -1;
   }
    
   public ControlId(int aWindowId, int aControlId, int aParentId) {
      windowId = aWindowId;
      controlId = aControlId;
      parentId = aParentId;
   }

}

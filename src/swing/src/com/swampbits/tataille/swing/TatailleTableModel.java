// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille.swing;

import com.swampbits.tataille.DisplayEngine;
import com.swampbits.tataille.GUIDisplayEngine;
import java.util.ArrayList;

import javax.swing.table.*;
import javax.swing.event.TableModelListener;

/**
 *
 * @author paul
 */
public class TatailleTableModel implements TableModel
{
   private final ArrayList<String> m_listColumnNames;
    
   public TatailleTableModel(String columnNames) {
      m_listColumnNames = GUIDisplayEngine.tokenize(columnNames, DisplayEngine.DEFAULT_VALUES_DELIMITER);
   }
    
   @Override
   public void addTableModelListener(TableModelListener listener) {
        
   }
    
   @Override
   public Class getColumnClass(int columnIndex) {
      return String.class;
   }
    
   @Override
   public int getColumnCount() {
      return m_listColumnNames.size();
   }
    
   @Override
   public String getColumnName(int columnIndex) {
      return m_listColumnNames.get(columnIndex);
   }
    
   @Override
   public int getRowCount() {
      return 0;
   }
    
   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      return null;
   }
    
   @Override
   public boolean isCellEditable(int rowIndex, int columnIndex) {
      return false;
   }
    
   @Override
   public void removeTableModelListener(TableModelListener listener) {
        
   }
    
   @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
   }
}

// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille.swt;

import org.eclipse.swt.widgets.Control;

import com.swampbits.tataille.ControlInfo;
import com.swampbits.tataille.Rect;
import com.swampbits.tataille.GUIDisplayEngineWidget;
import com.swampbits.tataille.DisplayEngineWidget;

/**
 *
 * @author paul
 */
public class SWTDisplayEngineWidget extends GUIDisplayEngineWidget implements DisplayEngineWidget {
   
    private final Control m_control;
    private final ControlInfo m_ci;
    
    public SWTDisplayEngineWidget(Control control, ControlInfo ci) {
        super(ci.cid);
        m_control = control;
        m_ci = ci;
    }
    
    public Control getControl() {
        return m_control;
    }
    
    public ControlInfo getControlInfo() {
        return m_ci;
    }
    
    @Override
    public boolean setControlVisible(boolean isVisible) {
        if (m_control != null) {
            m_control.setVisible(isVisible);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean setControlEnabled(boolean isEnabled) {
        if (m_control != null) {
            m_control.setEnabled(isEnabled);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean setControlSize(int width, int height) {
        if (m_control != null) {
            m_control.setSize(width, height);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean setControlPos(int x, int y) {
        if (m_control != null) {
            m_control.setLocation(x, y);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean setControlRect(Rect rect) {
        if ((rect != null) && (m_control != null)) {
            m_control.setBounds(rect.x, rect.y, rect.width, rect.height);
            return true;
        }
        
        return false;
    }
}

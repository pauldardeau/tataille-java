// Copyright Paul Dardeau, SwampBits LLC 2014
// BSD License

package com.swampbits.tataille.swing;

import javax.swing.JComponent;

import com.swampbits.tataille.ControlId;
import com.swampbits.tataille.Rect;
import com.swampbits.tataille.GUIDisplayEngineWidget;
import com.swampbits.tataille.DisplayEngineWidget;

/**
 *
 * @author paul
 */
public class SwingDisplayEngineWidget extends GUIDisplayEngineWidget implements DisplayEngineWidget
{
    private final JComponent m_swingComponent;
    
    public SwingDisplayEngineWidget(JComponent component, ControlId cid) {
        super(cid);
        m_swingComponent = component;
    }
    
    @Override
    public boolean setControlVisible(boolean isVisible) {
        if (m_swingComponent != null) {
            m_swingComponent.setVisible(isVisible);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean setControlEnabled(boolean isEnabled) {
        if (m_swingComponent != null) {
            m_swingComponent.setEnabled(isEnabled);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean setControlSize(int width, int height) {
        if (m_swingComponent != null) {
            m_swingComponent.setSize(width, height);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean setControlPos(int x, int y) {
        if (m_swingComponent != null) {
            m_swingComponent.setLocation(x, y);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean setControlRect(Rect rect) {
        if ((rect != null) && (m_swingComponent != null)) {
            m_swingComponent.setBounds(rect.x, rect.y, rect.width, rect.height);
            return true;
        }
        
        return false;
    }
}

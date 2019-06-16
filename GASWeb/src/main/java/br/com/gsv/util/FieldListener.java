package br.com.gsv.util;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class FieldListener implements FocusListener {	
	
	@Override
	public void focusGained(FocusEvent event) {
		Object obj = event.getSource();
      
		if ( obj instanceof JTextField ) {
            JTextField f = ( JTextField ) obj;
            f.setBackground( new Color(248, 250, 253) );
        }
		
	}

	@Override
	public void focusLost(FocusEvent event) {
		Object obj = event.getSource();
		
        if ( obj instanceof JTextField ) {
            JTextField f = ( JTextField ) obj;
            f.setBackground( new Color( 255, 255, 255 ) );
        }
	}

}

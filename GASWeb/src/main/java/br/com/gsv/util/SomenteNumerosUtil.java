package br.com.gsv.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SomenteNumerosUtil extends KeyAdapter{

	@Override
    public void keyTyped(KeyEvent evt) {
       TextFieldNumero(evt);
    }
	
	
	

	private static void TextFieldNumero(KeyEvent evt) {
		String caracteres="0987654321";// lista de caracters que devem ser aceitos
		
		if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o evento estiver não estiver na lista
			evt.consume();//aciona esse propriedade para eliminar a ação do evento
		}
	}
	
	
}

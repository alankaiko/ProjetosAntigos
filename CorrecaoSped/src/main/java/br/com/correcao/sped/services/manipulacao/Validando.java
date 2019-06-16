package br.com.correcao.sped.services.manipulacao;

import javax.servlet.http.Part;
import br.com.correcao.sped.util.MensagemUtil;

public class Validando {
	private static final int maxSize = 2 * 1024 * 1024;
	
	
	

	public static boolean ValidarImportacao(Object valor){
		Part arquivo = (Part) valor;
		boolean c = true;

		if (arquivo.getSize() > maxSize) {
			MensagemUtil.addMsgError("Arquivo muito grande. O arquivo deve ter o tamanho máximo de 2mb.");
			c = false;
		}
		if (!"text/plain".equals(arquivo.getContentType())) {
			MensagemUtil.addMsgError("Tipo de arquivo inválido. O arquivo deve ser do tipo texto.");
			c = false;
		}
		
		return c;
	}

}

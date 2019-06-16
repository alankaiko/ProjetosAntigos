package br.com.correcao.sped.services.manipulacao;

import java.io.FileWriter;
import java.io.IOException;

import br.com.correcao.sped.util.MensagemUtil;

public class GravandoArquivo {
	
	public static void Gravar(String[] arquivoFinal){
		FileWriter gravar = null;
		
		try {
			gravar = new FileWriter("C:\\arquivoCorrigido.txt");
			
			for(String linhas : arquivoFinal)
				gravar.write(linhas + "\r\n");
			gravar.close();
			MensagemUtil.addMsgInfo("ARQUIVO IMPORTADO E MODIFICADO COM SUCESSO!!!");
		} catch (IOException e) {
			System.out.println("Erro no metodo Gravar arquivo");
			e.printStackTrace();
		}
	}
}

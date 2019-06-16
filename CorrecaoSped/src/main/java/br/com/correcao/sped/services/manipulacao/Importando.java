package br.com.correcao.sped.services.manipulacao;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.Part;

import br.com.correcao.sped.util.MensagemUtil;

public class Importando {
	
	public static String ImportarConteudo(Part arquivo){
		String conteudo = null;
		
		try {
			conteudo = new Scanner(arquivo.getInputStream()).useDelimiter("\\A").next();
		}catch (IOException e) {
			System.out.println("DEU MERDA NO METODO IMPORTAR DA CLASSE BEAN");
			e.printStackTrace();
		}
		
		return conteudo;
	}
}

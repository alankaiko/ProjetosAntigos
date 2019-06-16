package br.com.correcao.sped.util;

public class TratarArquivoUtil {
	
	public static String[] ConfiguraArquivo(String conteudo){
		return conteudo.split("\\n");
		
	}
	
	public static String[] QuebrandoEmVetor(String conteudo) {
		return conteudo.split("\\|", -1);		
	}
	
}

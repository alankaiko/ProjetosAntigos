package br.com.gsv.util;

public class ValidaCampos {
	
	
	public static boolean Validar(String texto){
		return !texto.isEmpty();
	}
	
	public static boolean ValidaSistemaOperacional(String texto){
		return texto.contains("Windows");
	}
	
}

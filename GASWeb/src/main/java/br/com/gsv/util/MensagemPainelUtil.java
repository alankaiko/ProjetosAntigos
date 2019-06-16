package br.com.gsv.util;

import javax.swing.JOptionPane;

public class MensagemPainelUtil {
	private static JOptionPane mensagem = new JOptionPane();
	
	@SuppressWarnings("static-access")
	public static void Advertencia(){
		mensagem.showMessageDialog(mensagem, "Preencha os campos Obrigatórios");
	}
	
	@SuppressWarnings("static-access")
	public static void AutenticaUsuario(){
		mensagem.showMessageDialog(mensagem, "Usuário inexistente");
	}
	
	@SuppressWarnings("static-access")
	public static void ErroDuplicacao(String msg){
		mensagem.showMessageDialog(mensagem, msg);
	}
	
	@SuppressWarnings("static-access")
	public static void CampoVazio(String msg){
		mensagem.showMessageDialog(mensagem, msg);
	}
}

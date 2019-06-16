package br.com.banco.modelo;

public enum EnumTipoTransacao {
	SAQUE("Saque"), DEPOSITO("Dep�sito"), TRANSFERENCIA("Transfer�ncia");
	
	private String valor;
	
	private EnumTipoTransacao(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
}

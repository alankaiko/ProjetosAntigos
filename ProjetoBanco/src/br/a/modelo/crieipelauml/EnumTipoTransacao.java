package br.a.modelo.crieipelauml;

public enum EnumTipoTransacao {
	SAQUE("Saque"), DEPOSITO("Depósito"), TRANSFERENCIA("Transferência");
	
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

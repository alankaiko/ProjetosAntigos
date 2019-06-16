package br.a.modelo.crieipelauml;

public enum EnumTipoConta {
	CONTA_PESSOAL("Conta Pessoal"), CONTA_ESPECIAL("Conta Especial");
	
	private String valor;
	
	private EnumTipoConta(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
}

package br.com.gsv.domain.sub;

public enum EnumEvolucaoNivOrientacao {
	STATUS(" "),ORIENTADO("Orientado"), CONFUSO("Confuso"), DESORIENTADO("Desorientado");
	
	private String valor;
	
	private EnumEvolucaoNivOrientacao(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return valor;
	}
	
}

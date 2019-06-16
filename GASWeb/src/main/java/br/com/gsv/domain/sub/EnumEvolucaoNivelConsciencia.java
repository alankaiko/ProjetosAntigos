package br.com.gsv.domain.sub;

public enum EnumEvolucaoNivelConsciencia {
	STATUS(" "),CONSCIENTE("Consciente"), INCONSCIENTE("Inconsciente");
	
	private String valor;
	
	private EnumEvolucaoNivelConsciencia(String valor) {
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

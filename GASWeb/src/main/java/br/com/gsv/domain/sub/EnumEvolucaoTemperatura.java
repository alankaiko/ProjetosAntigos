package br.com.gsv.domain.sub;

public enum EnumEvolucaoTemperatura {
	STATUS(" "),HIPOTERMIA("Hipotermia"), NORMOTERMIA("Normotermia"), SUBFEBRIL("Subfebril"), 
	FEBRE("Febre"), PIREXIA("Pirexia"), HIPERPIREXIA("Hiperpirexia");
	
	private String valor;
	
	private EnumEvolucaoTemperatura(String valor) {
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

package br.com.gsv.domain.sub;

public enum EnumEvolucaoEstGeral {
	STATUS(" "),BOM("Bom"), REGULAR("Regular"), DECAIDO("Decaído"), GRAVE("Grave"), GRAVISSIMO("Gravíssimo");
	
	private String valor;
	
	private EnumEvolucaoEstGeral(String valor) {
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

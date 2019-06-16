package br.com.gsv.domain.sub;

public enum EnumRaca {
	NADA(" "),BRANCO("Branco"), PARDO("Pardo"), NEGRO("Negro"), AMARELO("Amarelo"), INDIGENA("Indígena"), NAODECLARA("Não Declarar");
	
	
	
	private String valor;
	
	private EnumRaca(String valor) {
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

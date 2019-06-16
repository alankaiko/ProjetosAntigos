package br.com.gsv.domain.sub;

public enum EnumEvolucaoPulso {
	STATUS(" "),BRAQUICARDICO("Braquicárdico"), NORMOCARDICO("Normocárdico"), TAQUICARDICO("Taquicárdico");
	
	private String valor;
	
	private EnumEvolucaoPulso(String valor) {
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

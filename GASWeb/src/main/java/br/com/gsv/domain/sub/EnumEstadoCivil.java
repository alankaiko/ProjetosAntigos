package br.com.gsv.domain.sub;

public enum EnumEstadoCivil {
	NADA(" "),SOLTEIRO("Solteiro (a)"), CASADO("Casado (a)"), DIVORCIADO("Divorciado (a)"), 
	SEPARADO("Separado (a)"), VIUVO("Viúvo (a)"), UNIAO_ESTAVEL("União Estável");
	
	private String valor;
	
	private EnumEstadoCivil(String valor) {
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

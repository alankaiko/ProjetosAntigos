package br.com.gsv.domain.sub;

public enum EnumSexo {
	NADA(" "),MASCULINO("Masculino"),FEMININO("Feminino");
	
	private String valor;
	
	private EnumSexo(String valor) {
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

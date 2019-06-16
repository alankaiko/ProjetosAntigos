package br.com.gsv.domain.sub;

public enum EnumStatusAgendamento {
	STATUS(" "),ATENDIDO("Atendido"), ATENDIMENTO("Em Atendimento"), AGENDADO("Agendado"), CANCELADO("Cancelado");
	
	private String valor;
	
	private EnumStatusAgendamento(String valor) {
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

package br.a.modelo.crieipelauml;

import java.util.Date;

public class Transacao {
	private Conta contaCredito;
	private Conta contaDebito;
	private Date data;
	private String descricao;
	private Entidade identificador;
	private EnumTipoTransacao tipoTransacao;
	private Double valor;

	public Conta getContaCredito() {
		return contaCredito;
	}

	public void setContaCredito(Conta contaCredito) {
		this.contaCredito = contaCredito;
	}

	public Conta getContaDebito() {
		return contaDebito;
	}

	public void setContaDebito(Conta contaDebito) {
		this.contaDebito = contaDebito;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Entidade getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Entidade identificador) {
		this.identificador = identificador;
	}

	public EnumTipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(EnumTipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}

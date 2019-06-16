package br.com.banco.modelo;

import java.util.Date;

import br.com.banco.util.UtilData;

public class Transacao extends EntidadeBanco{
	private Date data;
	private Conta contaCredito;
	private Conta contaDebito;
	private double valor;
	private String descricao;
	private EnumTipoTransacao tipoTransacao;
	private Long identificador;
	
	public Transacao(Date data, Conta contaCredito, Conta contaDebito, double valor, String descricao, EnumTipoTransacao tipoTransacao) {
		super();
		this.data = data;
		this.contaCredito = contaCredito;
		this.contaDebito = contaDebito;
		this.valor = valor;
		this.descricao = descricao;
		this.tipoTransacao = tipoTransacao;
	}

	@Override
	public Long getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EnumTipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(EnumTipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	
	public String toString() {
		if (EnumTipoTransacao.TRANSFERENCIA == getTipoTransacao()) {
			return "Transacao data " + UtilData.DDMMAAAA(getData()) + ", conta debito "
			+ getContaDebito().getNumero() + ", conta credito " + getContaCredito().getNumero() + ", valor " +
			getValor() + ", descricao -> " + getDescricao();
			
		} else if (EnumTipoTransacao.DEPOSITO == getTipoTransacao()) {
			return "Deposito data " + UtilData.DDMMAAAA(getData()) + ", conta " +
			getContaCredito().getNumero() + ", valor " + getValor() + ", descricao -> " + getDescricao();
			
		} else if (EnumTipoTransacao.SAQUE == getTipoTransacao()) {
			return "Saque data " + UtilData.DDMMAAAA(getData()) + ", conta " +
			getContaCredito().getNumero() + ", valor " + getValor() + ", descricao -> " + getDescricao();
		}
			return "Nenhum tipo de transação";
	}
}
	
	


package br.a.modelo.crieipelauml;

import java.util.Collection;
import java.util.Date;

public class Conta {
	private Entidade identificador;
	private Agencia agencia;
	private Date dataAbertura;
	private Integer numero;
	private Double saldo;
	private EnumTipoConta tipoConta;
	private Cliente titular;
	private Collection<Transacao> transacoes;

	public Entidade getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Entidade identificador) {
		this.identificador = identificador;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public EnumTipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(EnumTipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Collection<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(Collection<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

}

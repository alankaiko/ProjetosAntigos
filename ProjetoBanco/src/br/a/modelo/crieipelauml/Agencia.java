package br.a.modelo.crieipelauml;

import java.util.Collection;

public class Agencia {
	private Entidade identificador;
	private Banco banco;
	private Collection<Conta> contas;
	private String nome;

	public Entidade getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Entidade identificador) {
		this.identificador = identificador;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Collection<Conta> getContas() {
		return contas;
	}

	public void setContas(Collection<Conta> contas) {
		this.contas = contas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

package br.a.modelo.crieipelauml;

import java.util.Collection;

public class Banco {
	private Collection<Agencia> agencias;
	private Entidade identificador;
	private String nome;
	private int numero;

	public Collection<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(Collection<Agencia> agencias) {
		this.agencias = agencias;
	}

	public Entidade getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Entidade identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}

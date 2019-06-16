package br.a.modelo.crieipelauml;

public class Pessoa {
	private String endereco;
	private Entidade identificador;
	private String nome;
	private String telefone;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}

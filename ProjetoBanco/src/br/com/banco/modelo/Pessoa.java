package br.com.banco.modelo;

public class Pessoa extends EntidadeBanco{
	private String nome;
	private String telefone;
	private String endereco;
	private Long identificador;
	
	public Pessoa() {}
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	@Override
	public Long getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	
	public void ImprimeNome(){
		System.out.println("o nome do meliante: "+ this.nome);
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}

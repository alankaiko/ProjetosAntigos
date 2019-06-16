package br.com.banco.modelo;

final public class Cliente extends Pessoa{
	private String cpf;
	private String rg;
	
	public Cliente() {}
	
	public Cliente(String nome, String cpf){
		super(nome);
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@Override
	public final void ImprimeNome(){
		System.out.println("Nome do cliente e' : " + getNome() + " Nº CPF: " + cpf + " Seu endereco :" + getEndereco());
	}
}

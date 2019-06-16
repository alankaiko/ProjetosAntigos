package br.com.correcao.sped.bean.controller;

import br.com.correcao.sped.registro.editacampo0500.ContaContabil;
import br.com.correcao.sped.registro.editacampo0500.PlanoDeContas;

public class TrabalharRegistro0500 {
	private String[] vetor;
	ContaContabil conta;
	
	public TrabalharRegistro0500(String[] vetor) {
		this.vetor = vetor;
	}
	
	
	
	public String[] InserirEmRegistro0500(){
		for(int i=0; i < this.vetor.length; i++){
			if(this.vetor[i].startsWith("|0500|")){
				conta = new PlanoDeContas(this.vetor[i]);
				this.vetor[i] = conta.DevolveStringCorrigida();
			}
		}
		
		return this.vetor;
	}
	
}

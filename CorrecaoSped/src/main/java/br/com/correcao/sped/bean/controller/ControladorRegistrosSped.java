package br.com.correcao.sped.bean.controller;


public class ControladorRegistrosSped {

	public String[] ModificaReg0500(String[] vetor){
		TrabalharRegistro0500 controle = new TrabalharRegistro0500(vetor);
		vetor = controle.InserirEmRegistro0500();
		return vetor;
	}
	
	public String[] ModificaRegC175(String[] vetor){
		TrabalharRegistroC175 campo = new TrabalharRegistroC175(vetor);
		vetor = campo.InserindoEmRegistro175();
		return vetor;
	}
	
	
}

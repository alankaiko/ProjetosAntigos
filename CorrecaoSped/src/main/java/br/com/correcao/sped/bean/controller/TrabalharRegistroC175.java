package br.com.correcao.sped.bean.controller;

import br.com.correcao.sped.nfc.CFOP;
import br.com.correcao.sped.nfc.InserirCFOPAderup;
import br.com.correcao.sped.nfc.InserirCFOPCentral;
import br.com.correcao.sped.nfc.InserirCFOPPerfilados;

public class TrabalharRegistroC175 {
	
	String[] vetorArquivo;

	public TrabalharRegistroC175(String[] vetorArquivo) {
		this.vetorArquivo = vetorArquivo;
	}

	public String[] InserindoEmRegistro175() {
		for (int i = 0; i < this.vetorArquivo.length; i++) {
			
			if (this.vetorArquivo[i].startsWith("|C100|")) {

				if (this.vetorArquivo[i].contains("97478424000106")) {
					int posicao = i + 1;
					
					while (this.vetorArquivo[posicao].startsWith("|C175|")) {
						CFOP cfop = new InserirCFOPCentral(this.vetorArquivo[posicao]);
						this.vetorArquivo[posicao] = cfop.DevolverStringCorrigida();
						posicao++;
					}
				}
				
				if (this.vetorArquivo[i].contains("97478424000289")) {
					int posicao = i + 1;
					
					while (this.vetorArquivo[posicao].startsWith("|C175|")) {
						CFOP cfop = new InserirCFOPAderup(this.vetorArquivo[posicao]);
						this.vetorArquivo[posicao] = cfop.DevolverStringCorrigida();
						posicao++;
					}
				}
				
				if (this.vetorArquivo[i].contains("01070186000118")) {
					int posicao = i + 1;
					
					while (this.vetorArquivo[posicao].startsWith("|C175|")) {
						CFOP cfop = new InserirCFOPPerfilados(this.vetorArquivo[posicao]);
						this.vetorArquivo[posicao] = cfop.DevolverStringCorrigida();
						posicao++;
					}
				}
			}
		}
		
		return this.vetorArquivo;
	}
	
	
}

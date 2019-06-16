package br.com.correcao.sped.nfc;

import br.com.correcao.sped.util.TratarArquivoUtil;



public class InserirCFOPCentral extends CFOP {

	public InserirCFOPCentral(String linha) {
		this.resourcesName = "/cfopcentral.properties";
		this.arquivo = TratarArquivoUtil.QuebrandoEmVetor(linha);
		InserirContaContabil();
	}

	@Override
	public String DevolverStringCorrigida() {
		return ConcatenaString();
	}

	
	
	

}

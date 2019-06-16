package br.com.correcao.sped.nfc;

import br.com.correcao.sped.util.TratarArquivoUtil;

public class InserirCFOPPerfilados extends CFOP{

	public InserirCFOPPerfilados(String linha) {
		this.resourcesName="/cfopperfilados.properties";
		this.arquivo = TratarArquivoUtil.QuebrandoEmVetor(linha);
		InserirContaContabil();
	}
	
	
	@Override
	public String DevolverStringCorrigida() {
		return ConcatenaString();
	}

}

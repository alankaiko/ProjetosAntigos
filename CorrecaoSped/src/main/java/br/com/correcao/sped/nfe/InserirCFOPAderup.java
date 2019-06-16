package br.com.correcao.sped.nfe;

import br.com.correcao.sped.util.TratarArquivoUtil;

public class InserirCFOPAderup extends CFOP {

	public InserirCFOPAderup(String linha) {
		this.resourcesName = "/cfopaderup.properties";
		this.arquivo = TratarArquivoUtil.QuebrandoEmVetor(linha);
		InserirContaContabil();
	}

	@Override
	public String DevolverStringCorrigida() {
		return ConcatenaString();
	}

}

package br.com.correcao.sped.registro.editacampo0500;

import br.com.correcao.sped.util.TratarArquivoUtil;

public class PlanoDeContas extends ContaContabil{
	
	public PlanoDeContas(String linha) {
		this.resourcesName = "/contas.properties";
		this.vetorArquivo = TratarArquivoUtil.QuebrandoEmVetor(linha);
		InserindoTitulo();
		
	}
	
	@Override
	public String DevolveStringCorrigida() {
		return ConcatenaString();
	}
	
}

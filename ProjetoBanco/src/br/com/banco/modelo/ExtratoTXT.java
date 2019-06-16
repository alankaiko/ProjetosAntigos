package br.com.banco.modelo;

import java.util.Iterator;

import br.com.banco.util.UtilData;

public class ExtratoTXT implements IExtrato{
	protected Conta conta;
	
	public ExtratoTXT(Conta conta) {
		this.conta = conta;
	}
	
	@Override
	public String Formatar() {
		String newLine = System.getProperty("line.separator");
		String resultado = "Extrato de conta " + newLine;
		resultado += String.format("%-20.20s", "Data") + " "+ String.format("%7.7s", "Debito") + " "
				+ String.format("%7.7s", "Credito") + " "+ String.format("%15.15s", "Valor") + " "
				+ String.format("%s", "Descricao") + newLine;
		
		Iterator it = conta.getMovimento().iterator();
		
		while (it.hasNext()) {
			Transacao t = (Transacao) it.next();
			if(t.getTipoTransacao() == EnumTipoTransacao.TRANSFERENCIA){
				resultado += String.format("%-20.20s", UtilData.DDMMAAAA(t.getData()))+ " "
						+ String.format("%7d", t.getContaDebito().getNumero())+ " "
						+ String.format("%7d", t.getContaCredito().getNumero())
						+ " " + String.format("%15.15s", t.getValor()) + " "
						+ String.format("%s", t.getDescricao()) + newLine;
			}
		} return resultado;
	}
		
	
}

package br.com.banco.modelo;

import java.util.Iterator;

import br.com.banco.util.UtilData;

public class ExtratoHTML implements IExtrato{
	protected Conta conta;
	
	public ExtratoHTML(Conta conta){
		this.conta = conta;
	}

	@Override
	public String Formatar() {
		String newLine = System.getProperty("line.separator");
		String resultado = "<html>" + newLine;
		resultado += "<head>" + newLine;
		resultado += "<title>Extrato de Conta</title>" + newLine;
		resultado += "<style type=\"text/css\">" + newLine;
		resultado += "<!--" + newLine;
		resultado += "body { font-family: Verdana, Arial,Helvetica," + "sans-serif; font-weight:normal; font-variant: normal}" + newLine;
		resultado += ".clsIndex { }" + newLine;
		resultado += ".clsTitle { background-color: #CCCCCC;" + "text-align: center }" + newLine;
		resultado += "td { font-size: 9pt; font-family: Verdana, Arial," + "Helvetica, sans-serif;background-color: #EEEEEE}" + newLine;
		resultado += "-->" + newLine;
		resultado += "</style>" + newLine;
		resultado += "</head>" + newLine;
		resultado += "<body>" + newLine;
		resultado += "<h2>Extrato de conta</h2>" + newLine;
		resultado += "<TABLE CLASS=\"clsIndex\">" + newLine;
		resultado += "<tr>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Data</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Debito</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Credito</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Valor</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Descricao</B></TD>" + newLine;
		resultado += "</tr>" + newLine;
		Iterator it = conta.getMovimento().iterator();
		
		while (it.hasNext()) {
			Transacao t = (Transacao) it.next();
			
			if(t.getTipoTransacao() == EnumTipoTransacao.TRANSFERENCIA){
			resultado += "<tr>" + newLine;
			resultado += "<TD align=\"left\">" + UtilData.DDMMAAAA(t.getData())+ "</TD>" + newLine;
			resultado += "<TD align=\"right\">" + t.getContaDebito().getNumero() +"</TD>" + newLine;
			resultado += "<TD align=\"right\">" + t.getContaCredito().getNumero() +"</TD>" + newLine;
					resultado += "<TD align=\"right\">" + t.getValor() + "</TD>" + newLine;
					resultado += "<TD align=\"left\">" + t.getDescricao() + "</TD>" + newLine;
					resultado += "</tr>" + newLine;
			}
		} 
		
		resultado += "</table>" +newLine;
		resultado += "</body>" + newLine;
		resultado += "</html>" + newLine;
		return resultado;
					
	}
	

}

package br.com.gsv.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.text.MaskFormatter;

public class ConverteDadosUtil {
		
	
	//Converte o texto em Integer
	public static Integer RetornaInt(String valor){
		Integer num = 0;
		
		if(!valor.isEmpty()){
			return num = Integer.parseInt(valor);
		}
		
		return num;		
	}
	
	
	//Converte as datas de String para Date para ser armazenadas Desde que a String nao seja nula
	public static Date TransformandoEmDate(String data){
		Date dat = null;
		
		if(data.replaceAll("[_/]", "").isEmpty()){
			//return null;
		}else{
			try {
				DateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
				dat = (Date)formata.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		

		return dat;
	}
	
	
	//Faz o inverso, pega a variavel do tipo Date e transforma em String
	public static String TransformandoEmString(Date data){
		String dat= null;
		
		if(data != null){
			Calendar calen = Calendar.getInstance();
			calen.setTime(data);
			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
			dat = df.format(calen.getTime());
			
		}
		
		return dat;
	}
		
		
	
	//Pega a data do dia atual e transforma em String para ser apresentada pra quem chamar
	public static String RetornaDataAtual(){
		String valor;
		
		Date data = new Date();
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		valor = df.format(calendario.getTime());
		return valor;
	}
	
	
	public static String RetornaHoraAtual(){
		Calendar agora = Calendar.getInstance();
		int ho = agora.get(Calendar.HOUR_OF_DAY);
		int mi = agora.get(Calendar.MINUTE);
		
		String valor = formatar(ho)+ ":"+formatar(mi);
		return valor;
	}
	
	private static String formatar(int num){
		DecimalFormat df = new DecimalFormat("00");
		    
		return df.format(num);
	}
	
	
	
	//Metodo que adiciona mascara ao campo de Cpf
	public static MaskFormatter FormataCPF(){
		MaskFormatter mascaraCpf = null;
		
		try{
			mascaraCpf=new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
		}
		catch(ParseException excp){}
		
		return mascaraCpf;
	}
	
	
	//Metodo que adiciona mascara ao campo de data
	public static MaskFormatter FormataData(){
		MaskFormatter mascaraData = null;
		
		try{
			mascaraData=new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		}
		catch(ParseException excp){}
		
		return mascaraData;
	}
	
	
	//Metodo que adiciona mascara ao campo cep
	public static MaskFormatter FormataCep(){
		MaskFormatter mascaraCep = null;
		
		try{
			mascaraCep=new MaskFormatter("#####-###");
			mascaraCep.setPlaceholderCharacter('_');
		}
		catch(ParseException excp){}
		
		return mascaraCep;
	}
	
	
}
	
	
	

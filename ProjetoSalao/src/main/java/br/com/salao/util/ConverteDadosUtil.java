package br.com.salao.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.swing.text.MaskFormatter;

public class ConverteDadosUtil {
	
	public static Date ConverteDataAgendamento(Date data){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+2"));

		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		String timestamp = formatter.format(cal.getTime());
		return TransformandoEmDate(timestamp);
	}
	
	//Converte o texto em Integer
	public static Integer RetornaInt(String valor){
		Integer num = 0;
		
		if(!valor.isEmpty()){
			return num = Integer.parseInt(valor);
		}
		
		return num;		
	}
	
	
	public static Date TransformandoEmDateService(Date date, String hora){	
		Date aff = null;
		String[] horas = hora.split(":");
		
		Calendar calen = Calendar.getInstance();
		calen.setTime(date);
		calen.set(Calendar.HOUR, Integer.parseInt(horas[0]));
		calen.set(Calendar.MINUTE, Integer.parseInt(horas[1]));
		aff = calen.getTime();
		return aff;
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
	
	
	public static List<String> ListaHoras(){
		List<String> listaHorarios = new ArrayList<String>();
		
		listaHorarios.add("06:00");
		listaHorarios.add("06:30");
		listaHorarios.add("07:00");
		listaHorarios.add("07:30");
		listaHorarios.add("08:00");
		listaHorarios.add("08:30");
		listaHorarios.add("09:00");
		listaHorarios.add("09:30");
		listaHorarios.add("10:00");
		listaHorarios.add("10:30");
		listaHorarios.add("11:00");
		listaHorarios.add("11:30");
		listaHorarios.add("12:00");
		listaHorarios.add("12:30");
		listaHorarios.add("13:00");
		listaHorarios.add("13:30");
		listaHorarios.add("14:00");
		listaHorarios.add("14:30");
		listaHorarios.add("15:00");
		listaHorarios.add("15:30");
		listaHorarios.add("16:00");
		listaHorarios.add("16:30");
		listaHorarios.add("17:00");
		listaHorarios.add("17:30");
		listaHorarios.add("18:00");
		listaHorarios.add("18:30");
		listaHorarios.add("19:00");
		listaHorarios.add("19:30");
		listaHorarios.add("20:00");
		listaHorarios.add("20:30");
		listaHorarios.add("21:00");
		listaHorarios.add("21:30");
		listaHorarios.add("22:00");
		listaHorarios.add("22:30");
		
		
		return listaHorarios;
	}
	
}
	
	
	

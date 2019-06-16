package br.com.banco.util;

import java.util.Calendar;
import java.util.Date;

public class UtilData {
	static int DOMINGO = Calendar.SUNDAY;
	static int SEGUNDA = Calendar.MONDAY;
	static int TERCA = Calendar.TUESDAY;
	static int QUARTA = Calendar.WEDNESDAY;
	static int QUINTA = Calendar.THURSDAY;
	static int SEXTA = Calendar.FRIDAY;
	static int SABADO = Calendar.SATURDAY;
	
	int JANEIRO = Calendar.JANUARY;
	int FEVEREIRO = Calendar.FEBRUARY;
	int MARCO = Calendar.MARCH;
	int ABRIL = Calendar.APRIL;
	int MAIO = Calendar.MAY;
	int JUNHO = Calendar.JUNE;
	int JULHO = Calendar.JULY;
	int AGOSTO = Calendar.AUGUST;
	int SETEMBRO = Calendar.SEPTEMBER;
	int OUTUBRO = Calendar.OCTOBER;
	int NOVEMBRO = Calendar.NOVEMBER;
	int DEZEMBRO = Calendar.DECEMBER;
	
	static int DiaDoMes = Calendar.DAY_OF_MONTH;
	static int DiaDaSemana = Calendar.DAY_OF_WEEK;
	
	static {
		System.out.println("Entrando no bloco estatico.");
		Date data = Calendar.getInstance().getTime();
		System.out.println("Saindo do metodo estatico data = " + agora(data));
	}
	
	public static String agora(Date data) {
		return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
	}
	
	public String DDMMAAAAHHMM(Date data) {
		return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
	}
	
	public static Date data(){
		return Calendar.getInstance().getTime();
	}
	
	public static Calendar data(int dia, int mes, int ano) {
		return data(dia, mes, ano, 0, 0, 0);
	}
	
	public static Calendar data(int dia, int mes, int ano, int hora, int min, int seg) {
		Calendar data = Calendar.getInstance();
		data.set(ano, --mes, dia, hora, min, seg);
		data.set(Calendar.MILLISECOND, 0);
		return data;
	}
	
	
	public static Calendar data(String data) {
		return data(Integer.valueOf(data.split("/")[0]), Integer.valueOf(data.split("/")[1]),
		Integer.valueOf(data.split("/")[2]));
	}
	
	public static Date getDate(Calendar data) {
		return data.getTime();
	}
	
	public static String DDMMAAAA(Date data) {
		return new java.text.SimpleDateFormat("dd/MM/yyyy").format(data);
	}
	
	public int getAno(Date data) {
		final Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		return calendario.get(Calendar.YEAR);
	}
	
	public int getMes(Date data) {
		final Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		return calendario.get(Calendar.MONTH);
	}
	
	public int getDia(Date data) {
		final Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		return calendario.get(Calendar.DAY_OF_MONTH);
	}
	
	public void somarDia(Date data, int numDias) {
		final Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		calendario.add(Calendar.DAY_OF_MONTH, numDias);
	}
	
}

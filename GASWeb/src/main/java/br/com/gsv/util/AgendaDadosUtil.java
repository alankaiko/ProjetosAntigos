package br.com.gsv.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import org.joda.time.DateTime;



public class AgendaDadosUtil {
	
	public static DateTime RetornaData(JSpinner data){
		DateTime valor = new DateTime(data);
		return valor;
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
	
	
	
	
	/*Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR);
		THoraSpinner = new JSpinner(sm);
		THoraSpinner.setBorder(new LineBorder(new Color(0, 0, 0)));
		JSpinner.DateEditor de_THoraSpinner = new JSpinner.DateEditor(THoraSpinner, "HH:mm");
		THoraSpinner.setEditor(de_THoraSpinner);
		THoraSpinner.setBounds(405, 165, 109, 20);*/
	
	
	
	
}

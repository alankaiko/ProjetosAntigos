package br.com.salao.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.salao.Service.ReservasService;
import br.com.salao.modelo.Apartamento;
import br.com.salao.modelo.Reserva;
import br.com.salao.modelo.Salao;
import br.com.salao.util.ConverteDadosUtil;
import br.com.salao.util.MensagemUtil;

@ManagedBean(name="MBAgenda")
@ViewScoped
public class AgendarBean {
	private ScheduleModel eventModel;
	private ScheduleEvent event = new DefaultScheduleEvent();
	private List<Reserva> listaReserva;
	private ReservasService service;
	private Reserva reserva;
	private Date data;
	private List<Apartamento> listaApartamentos;
	private Apartamento apartamento;
	private List<Salao> listaSaloes;
	private Salao salao;
	
	@PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel();
		this.service = new ReservasService();
		this.listaApartamentos = this.service.ListarApartamentos();
		this.listaSaloes = this.service.ListaSalao();
		IniciarObjeto();
		RodarLista();
	}
	
	private void IniciarObjeto(){
		this.reserva = new Reserva();
	}
	
	private void RodarLista() {
		this.listaReserva = this.service.ListandoReservas();
		
		for (Reserva reserva : listaReserva) {
			DefaultScheduleEvent evento = new DefaultScheduleEvent();
			evento.setEndDate(ConverteDadosUtil.TransformandoEmDateService(reserva.getData(), reserva.getHoraInicial()));
			evento.setStartDate(ConverteDadosUtil.TransformandoEmDateService(reserva.getData(), reserva.getHoraFinal()));
			evento.setData(reserva.getId());
			evento.setTitle(reserva.getApartamento().getNumeroApartamento());
			evento.setDescription(reserva.getApartamento().getCliente().getNome());
			evento.setAllDay(false);
			evento.setEditable(true);
			eventModel.addEvent(evento);			
		}
	}
	
	public void ReservarSalao() {
		try {
			if (event.getId() == null)
				eventModel.addEvent(event);
			else
				eventModel.updateEvent(event);
			
			event = new DefaultScheduleEvent();
			this.service.SalvandoReserva(reserva);
			Redirecionar();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	public void PegaApartamento(SelectEvent event) {
		this.reserva.setApartamento(this.apartamento);
	}
	
	public void PegaSalao(SelectEvent event) {
		this.reserva.setSalao(this.salao);
	}

	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoSalao/agendamentos/Agendar.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//--------------------------------------------------------METODOS REFERENTE A TABELA DE EVENTOS PRIMEFACES----------------------------
	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		this.reserva = service.BuscarPorId((Long) event.getData());
	}

	public void onDateSelect(SelectEvent selectEvent) {
		IniciarObjeto();
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date)selectEvent.getObject());
		CorrigeData();
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		MensagemUtil.addMsgInfo("Event movido, Dia " + event.getDayDelta() + ", minuto: " + event.getMinuteDelta());
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		MensagemUtil.addMsgInfo("Evento remodelado, dia: " + event.getDayDelta() +", minuto: " + event.getMinuteDelta());
	}
	
	//Esse metodo e pra isso
	//nao sei porque diabos eu tenho converter a data do objeto Event 
	//pra String e depois para data. se nao fizer isso, a data vem errada (dia seguinte)
	private void CorrigeData() {
		if (event.getEndDate() != null) {
			this.reserva.setData(ConverteDadosUtil.ConverteDataAgendamento(this.event.getStartDate()));
		}
	}
	
	
	
	//metodo que pega a lista de horas da classe util
	//logicamente exclui das horas cadastradas em determinado dia
	public List<String> getHorasLista() {
		CorrigeData();

		List<String> listaDoBanco = service.ListarHorariosDisponiveis(this.data);
		List<String> listaDeHoras = ConverteDadosUtil.ListaHoras();

		listaDoBanco.remove(this.reserva.getHoraInicial());
		listaDeHoras.removeAll(listaDoBanco);

		return listaDeHoras;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public List<Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public List<Apartamento> getListaApartamentos() {
		return listaApartamentos;
	}
	
	public Apartamento getApartamento() {
		return apartamento;
	}
	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
	public Salao getSalao() {
		return salao;
	}
	
	public void setSalao(Salao salao) {
		this.salao = salao;
	}
	
	public List<Salao> getListaSaloes() {
		return listaSaloes;
	}
}

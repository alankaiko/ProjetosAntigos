package br.com.gsv.beans;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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

import br.com.gsv.domain.Agenda;
import br.com.gsv.domain.Funcionario;
import br.com.gsv.domain.Paciente;
import br.com.gsv.domain.Prontuario;
import br.com.gsv.domain.sub.EnumEstadoCivil;
import br.com.gsv.domain.sub.EnumRaca;
import br.com.gsv.domain.sub.EnumSexo;
import br.com.gsv.domain.sub.EnumStatusAgendamento;
import br.com.gsv.domain.sub.EnumTipoAgendamento;
import br.com.gsv.util.AgendaDadosUtil;
import br.com.gsv.util.ConverteDadosUtil;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.AgendaService;

@ManagedBean(name = "MBAgendamento")
@ViewScoped
public class AgendaClinica {
	private ScheduleModel eventModel;
	private ScheduleEvent event = new DefaultScheduleEvent();
	private List<Agenda> listaAgenda;
	private AgendaService service;
	private Agenda agenda;
	private List<Paciente> listaPaciente;
	private Paciente paciente;
	private List<Funcionario> listaFuncionario;
	private Funcionario funcionario;
	private Date data;
	private List<Prontuario> listaProntuarios;
	private Agenda agendaSelecionado;

	@PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel();
		service = new AgendaService();
		agenda = new Agenda();
		listaFuncionario = service.ListandoFuncionarios();
		listaPaciente = service.ListandoPacientes();
		RodarLista();
	}
	
	private void RodarLista() {
		listaAgenda = service.ListarTotalAgenda();
		
		for (Agenda agenda : listaAgenda) {
			DefaultScheduleEvent evento = new DefaultScheduleEvent();
			evento.setEndDate(agenda.getData());
			evento.setStartDate(agenda.getData());
			evento.setData(agenda.getId());
			evento.setTitle(agenda.getPaciente().getNome());
			evento.setDescription(agenda.getStatusAgendamento().toString());
			evento.setAllDay(false);
			evento.setEditable(true);

			eventModel.addEvent(evento);
		}
	}
	
	
	public void Excluir(){
		try {
			this.service.Remover(this.agendaSelecionado);
			
			Mensagem.mensagemInfo("Agendamento removido!!");
		} catch (Exception e) {
			throw e;
		}		
	}

	public void PegaPaciente(SelectEvent event) {
		this.agenda.setPaciente(this.paciente);
		this.listaProntuarios = this.service.ListarProntuariosPorCliente(this.paciente.getId());
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
	
	public void SalvarPaciente(){
		if((this.agenda.getPaciente().getId() == null) && (this.agenda.getPaciente().getNome() != "")){
			this.service.SalvandoPaciente(this.agenda.getPaciente());
			this.paciente = this.service.BuscarPorNomePaciente(this.agenda.getPaciente().getNome());
			
		}
		
	}
	

	public void addEvent() {
		if(this.agenda.getPaciente().getNome() != ""){
			this.agenda.setPaciente(paciente);
			
			if (event.getId() == null)
				eventModel.addEvent(event);
			else
				eventModel.updateEvent(event);
	
			event = new DefaultScheduleEvent();
			this.service.Salvar(agenda);
			Redirecionar();
		}
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		this.agenda = service.BuscandoId((Long) event.getData());
	}

	public void onDateSelect(SelectEvent selectEvent) {
		this.agenda = new Agenda();
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
		CorrigeData();
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(
			FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta()
			+ ", Minute delta:" + event.getMinuteDelta());
		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(
			FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() +
			", Minute delta:" + event.getMinuteDelta());
		addMessage(message);
	}

	//passar mensagens mas ainda nao usei
	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	//metodo que pega a lista de horas da classe util
	//logicamente exclui das horas cadastradas em determinado dia
	public List<String> getHorasLista() {
		AgendaService service = new AgendaService();
		CorrigeData();

		List<String> listaDoBanco = service.ListarHorarios(this.data);
		List<String> listaDeHoras = AgendaDadosUtil.ListaHoras();

		listaDoBanco.remove(this.agenda.getHoraDesejada());
		listaDeHoras.removeAll(listaDoBanco);

		return listaDeHoras;
	}

	
	//Esse metodo e pra isso
	//nao sei porque diabos eu tenho converter a data do objeto Event 
	//pra String e depois para data. se nao fizer isso, a data vem errada (dia seguinte)
	private void CorrigeData() {
		if (event.getEndDate() != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			formatter.setTimeZone(TimeZone.getTimeZone("GMT+2"));

			Calendar cal = Calendar.getInstance();
			cal.setTime(event.getStartDate());
			String timestamp = formatter.format(cal.getTime());
			this.data = ConverteDadosUtil.TransformandoEmDate(timestamp);
			this.agenda.setData(this.data);
		}
	}

	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/agendas/GerenciarAgendas.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public EnumEstadoCivil[] getEstadoCivil(){
		return EnumEstadoCivil.values();
	}
	
	public EnumStatusAgendamento[] getStatusAgendamento() {
		return EnumStatusAgendamento.values();
	}

	public EnumTipoAgendamento[] getTipoAgendamento() {
		return EnumTipoAgendamento.values();
	}
	
	public EnumSexo[] getSexo(){
		return EnumSexo.values();
	}
	
	public EnumRaca[] getRaca(){
		return EnumRaca.values();
	}

	public List<Agenda> getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(List<Agenda> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}

	public AgendaService getService() {
		return service;
	}

	public void setService(AgendaService service) {
		this.service = service;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public List<Prontuario> getListaProntuarios() {
		return listaProntuarios;
	}
	
	public Agenda getAgendaSelecionado() {
		return agendaSelecionado;
	}
	
	public void setAgendaSelecionado(Agenda agendaSelecionado) {
		this.agendaSelecionado = agendaSelecionado;
	}
}

package br.com.gsv.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gsv.domain.Agenda;
import br.com.projeto.gsv.service.AgendaService;


@ManagedBean(name="MBHistoricoAgendamento")
@ViewScoped
public class HistoricoAgenda {
	private List<Agenda> listaAgenda;
	private AgendaService service;
	private String nome;
	
	public HistoricoAgenda() {
		this.service = new AgendaService();
	}
	
	public Long getIdPaciente(){
		return this.listaAgenda.get(0).getPaciente().getId();
	}
	
	public String getNomeCliente(){
		return this.listaAgenda.get(0).getPaciente().getNome();
	}
	
	public void ListarPorPaciente(){
		this.listaAgenda = this.service.AgendaPorPaciente(this.nome);
	}
	
	public List<Agenda> getListaAgenda() {
		return listaAgenda;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}

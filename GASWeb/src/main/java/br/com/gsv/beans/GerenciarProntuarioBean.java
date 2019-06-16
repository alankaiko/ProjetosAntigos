package br.com.gsv.beans;


import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Prontuario;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.ProntuarioService;


@ManagedBean(name="MBProntuario")
@ViewScoped
public class GerenciarProntuarioBean {
	private ProntuarioService service;
	private Prontuario prontuario;
	private List<Prontuario> listaProntuarios;
	
	@PostConstruct
	public void Inicializar() {
		prontuario = new Prontuario();
		service = new ProntuarioService();
	}
	
	public void ListarGeral(){
		this.listaProntuarios = service.ListandoProntuarios();
	}
	
	
	public void Excluir(){
		try {
			this.service.Remover(this.prontuario);
			
			Mensagem.mensagemInfo("Prontuário do cliente: "+ this.prontuario.getPaciente().getNome()+ " excluído");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/prontuarios/GerenciarProntuarios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Prontuario getProntuario() {
		return prontuario;
	}
	
	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}
	
	public List<Prontuario> getListaProntuarios() {
		return listaProntuarios;
	}
	
	public void setListaProntuarios(List<Prontuario> listaProntuarios) {
		this.listaProntuarios = listaProntuarios;
	}
}

package br.com.gsv.beans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Prontuario;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.ProntuarioService;


@ManagedBean
@ViewScoped
public class ConsultaProntuario {
	private Prontuario prontuarioSelecionado;
	private ProntuarioService service;
	private List<Prontuario> listaProntuarios;
	private Date data;
	
	
	public ConsultaProntuario() {
		this.service = new ProntuarioService();
	}
	
	public void ListarGeral(){
		this.listaProntuarios = service.ListandoProntuarios();
	}
	
	
	public void Excluir(){
		try {
			this.service.Remover(this.prontuarioSelecionado);
			
			Mensagem.mensagemInfo("Prontuário de "+ this.prontuarioSelecionado.getPaciente().getNome()+ " excluído com sucesso");
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
	
	
	public List<Prontuario> getListaProntuarios() {
		return listaProntuarios;
	}
	
	public Prontuario getProntuarioSelecionado() {
		return prontuarioSelecionado;
	}
	
	public void setProntuarioSelecionado(Prontuario prontuarioSelecionado) {
		this.prontuarioSelecionado = prontuarioSelecionado;
	}	
	
	public void setData(Date data) {
		this.data = data;
	}
}

package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Paciente;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.PacienteService;

@ManagedBean(name="MBPaciente")
@ViewScoped
public class ConsultaPaciente {
	private List<Paciente> listaPaciente;
	private Paciente pacienteSelecionado;
	private PacienteService service;
	
	public ConsultaPaciente() {
		this.service = new PacienteService();
	}
	
	public void ListarPacientes(){
		this.listaPaciente = service.ListandoPacientes();
	}
	
	
	public void Excluir(){
		try {
			this.service.Remover(this.pacienteSelecionado);
			
			Mensagem.mensagemInfo("Cliente "+ this.pacienteSelecionado.getNome()+ " Excluído com Sucesso");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/pacientes/GerenciarPacientes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}
	
	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}
	
	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}
	
}

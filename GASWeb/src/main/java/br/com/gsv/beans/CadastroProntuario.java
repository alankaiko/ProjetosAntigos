package br.com.gsv.beans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.gsv.domain.Funcionario;
import br.com.gsv.domain.Paciente;
import br.com.gsv.domain.Prontuario;
import br.com.gsv.util.ConverteDadosUtil;
import br.com.projeto.gsv.service.ProntuarioService;

@ManagedBean(name="MBCadProntuario")
@ViewScoped
public class CadastroProntuario {
	private Prontuario prontuario;
	private ProntuarioService service;
	private Long id;
	private List<Paciente> listaPaciente;
	private List<Funcionario> listaFuncionario;
	
	
	public CadastroProntuario() {
		this.service = new ProntuarioService();
		this.prontuario = new Prontuario();
		this.listaPaciente = service.ListandoPacientes();
		this.listaFuncionario = service.ListandoFuncionarios();
	}
	
	public void Salvando(){
		this.service.Salvar(prontuario);
	}
	
	
	public void PegaPaciente(SelectEvent event) {
		ConferirData();
	}
	
	public void PegaFuncionario(SelectEvent event){
	
	}
	
	public void ConferirData(){		
		Date data = new Date();
		this.prontuario.setData(data);
		this.prontuario.setHora(ConverteDadosUtil.RetornaHoraAtual());
	}
	
	
		
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/prontuarios/GerenciarProntuarios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void CarregarProntuarioEditar(){
		if(this.id != null)
			this.prontuario = service.BuscandoId(id);
	}
	
	
	
	
	
	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}
	
	public Prontuario getProntuario() {
		return prontuario;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Paciente> getListaPaciente() {
		return listaPaciente;
	}
	
	
	
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}
}

package br.com.gsv.beans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Convenio;
import br.com.gsv.domain.Paciente;
import br.com.gsv.domain.sub.EnumEstadoCivil;
import br.com.gsv.domain.sub.EnumRaca;
import br.com.gsv.domain.sub.EnumSexo;
import br.com.gsv.util.ListasUtil;
import br.com.projeto.gsv.service.PacienteService;

@ManagedBean(name="MBCadPaciente")
@ViewScoped
public class CadastroPaciente {
	private List<String> listaEstados;
	private Paciente paciente;
	private PacienteService service;
	private Long id;
	private List<Convenio> listaConvenio;
	
	public CadastroPaciente() {
		this.service = new PacienteService();
		this.paciente = new Paciente();
	}
	
	public void Inicializar(){
		this.listaEstados = ListasUtil.Estados();
		AtualizaConvenio();
		VerificarDataDeCadastro();
		VerificaConvenio();
	}
	
	public void AtualizaConvenio(){
		this.listaConvenio = service.ConvenioListaCompleta();
	}
	
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/pacientes/GerenciarPacientes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.paciente);
	}

	public void CarregarPacienteEditar(){
		if(this.id != null)
			this.paciente = service.BuscandoId(this.id);
	}
	
	public void VerificarDataDeCadastro() {
		if(this.id == null){
			Date data = new Date();
			this.paciente.setDataCad(data);
		}
	}
	
	public void VerificaConvenio(){
		if(this.paciente.getConvenio().equals(null)){
			Convenio convenio = new Convenio();
			this.paciente.setConvenio(convenio);
		}
	}
	
	
	public EnumEstadoCivil[] getEstadoCivil(){
		return EnumEstadoCivil.values();
	}
	
	public EnumSexo[] getSexo(){
		return EnumSexo.values();
	}
	
	public EnumRaca[] getRaca(){
		return EnumRaca.values();
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Convenio> getListaConvenio() {
		return listaConvenio;
	}
	
	public List<String> getListaEstados() {
		return listaEstados;
	}
}

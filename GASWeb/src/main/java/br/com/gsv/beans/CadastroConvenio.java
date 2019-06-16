package br.com.gsv.beans;

import java.io.IOException;




import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Convenio;
import br.com.projeto.gsv.service.ConvenioService;

@ManagedBean(name="MBCadConvenio")
@ViewScoped
public class CadastroConvenio {
	private Convenio convenio;
	private ConvenioService service;
	private Long id;
	
	public CadastroConvenio() {
		this.service = new ConvenioService();
		this.convenio = new Convenio();
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/convenios/GerenciarConvenios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.convenio);
	}
	
	public void CarregarConvenioEditar(){
		if(this.id != null){
			this.convenio = service.BuscandoId(this.id);
			
		}
	}
	
	
	public Convenio getConvenio() {
		return convenio;
	}
	
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}

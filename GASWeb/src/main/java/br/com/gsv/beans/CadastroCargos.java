package br.com.gsv.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.sub.Grupo;
import br.com.projeto.gsv.service.GrupoService;

@ManagedBean(name="MBCadCargo")
@ViewScoped
public class CadastroCargos {
	private Grupo grupo;
	private GrupoService service;
	private Long id;
	
	public CadastroCargos() {
		this.service = new GrupoService();
		this.grupo = new Grupo();
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/cargos/GerenciarCargos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.grupo);
	}
	
	public void CarregarGrupoEditar(){
		if(this.id != null){
			this.grupo = service.BuscandoId(this.id);
			
		}
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}

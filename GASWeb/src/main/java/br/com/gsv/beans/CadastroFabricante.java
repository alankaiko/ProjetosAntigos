package br.com.gsv.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Fabricante;
import br.com.projeto.gsv.service.FabricanteService;

@ManagedBean(name="MBCadFabricante")
@ViewScoped
public class CadastroFabricante {
	private Fabricante fabricante;
	private FabricanteService service;
	private Long id;
	
	public CadastroFabricante() {
		this.service = new FabricanteService();
		this.fabricante = new Fabricante();
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/fabricantes/GerenciarFabricantes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.fabricante);
	}
	
	public void CarregarFabricanteEditar(){
		if(this.id != null){
			this.fabricante = service.BuscandoId(this.id);
			
		}
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}

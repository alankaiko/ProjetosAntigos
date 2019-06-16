package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Fabricante;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.FabricanteService;



@ManagedBean(name="MBFabricante")
@ViewScoped
public class ConsultaFabricante {
	private Fabricante fabricanteSelecionado;
	private FabricanteService service;
	private List<Fabricante> listaFabricante;
	
	public ConsultaFabricante() {
		service = new FabricanteService();
	}
	
	public void ListarGeral(){
		this.listaFabricante = service.ListandoFabricantes();
	}

	public void Excluir(){
		try {
			this.service.Remover(this.fabricanteSelecionado);
			
			Mensagem.mensagemInfo("Cliente "+ this.fabricanteSelecionado.getDescricao()+ " excluído com sucesso");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/fabricantes/GerenciarFabricantes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}
	
	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
	public List<Fabricante> getListaFabricante() {
		return listaFabricante;
	}
}

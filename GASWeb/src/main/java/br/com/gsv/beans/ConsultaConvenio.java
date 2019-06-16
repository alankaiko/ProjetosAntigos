package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Convenio;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.ConvenioService;



@ManagedBean(name="MBConvenio")
@ViewScoped
public class ConsultaConvenio {
	private Convenio convenioSelecionado;
	private ConvenioService service;
	private List<Convenio> listaConvenio;
	
	public ConsultaConvenio() {
		service = new ConvenioService();
	}
	
	public void ListarGeral(){
		this.listaConvenio = service.ListandoConvenios();
	}

	public void Excluir(){
		try {
			this.service.Remover(this.convenioSelecionado);
			
			Mensagem.mensagemInfo("Cliente "+ this.convenioSelecionado.getNome()+ " Excluído com Sucesso");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/convenios/GerenciarConvenios.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Convenio> getListaConvenio() {
		return listaConvenio;
	}
	
	public Convenio getConvenioSelecionado() {
		return convenioSelecionado;
	}
	
	public void setConvenioSelecionado(Convenio convenioSelecionado) {
		this.convenioSelecionado = convenioSelecionado;
	}
}

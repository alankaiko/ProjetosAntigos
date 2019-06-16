package br.com.salao.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.salao.Service.ApartamentoService;
import br.com.salao.modelo.Apartamento;


@ManagedBean
@ViewScoped
public class PesquisaApartamento {
	private Apartamento apartamento;
	private ApartamentoService service;
	private List<Apartamento> listarApartamentos;
	
	public PesquisaApartamento() {
		this.service = new ApartamentoService();
	}
	
	public void CarregarLista(){
		this.listarApartamentos = this.service.ListarApartamentos();
	}
	
	public void ExcluirCliente(){
		try {
			this.service.ExcluirAp(this.apartamento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoSalao/apartamentos/PesquisaApartamentos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Apartamento getApartamento() {
		return apartamento;
	}
	
	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
	public List<Apartamento> getListarApartamentos() {
		return listarApartamentos;
	}
}

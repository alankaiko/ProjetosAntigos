package br.com.salao.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.salao.Service.SalaoService;
import br.com.salao.modelo.Salao;

@ManagedBean
@ViewScoped
public class PesquisaSalao {
	private List<Salao> listaSalao;
	private SalaoService service;
	private Salao salao;
	
	public PesquisaSalao() {
		this.service = new SalaoService();
	}
	
	
	public void ListarTodos(){
		this.listaSalao = this.service.ListandoSalao();
	}
	
	public void Excluir(){
		try {
			this.service.RemoverSalao(salao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoSalao/salao/PesquisaSaloes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Salao> getListaSalao() {
		return listaSalao;
	}
	
	public Salao getSalao() {
		return salao;
	}
	public void setSalao(Salao salao) {
		this.salao = salao;
	}
}

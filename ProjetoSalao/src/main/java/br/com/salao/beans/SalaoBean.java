package br.com.salao.beans;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.salao.Service.SalaoService;
import br.com.salao.modelo.Salao;
import br.com.salao.util.MensagemUtil;

@ManagedBean
@ViewScoped
public class SalaoBean {
	private Salao salao;
	private SalaoService service;
	private Long id;
	
	public SalaoBean() {
		this.salao = new Salao();
		this.service = new SalaoService();
	}
	
	public void SalvarSalao(){
		try {
			this.service.SalvandoSaloes(this.salao);
			MensagemUtil.addMsgInfo("Cadastro realizado "+this.salao.getNomeSalao());
		} catch (SQLException e) {
			System.out.println("erro ao salvar cliente"+ e.getMessage());
			
		}
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoSalao/salao/PesquisaSaloes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Excluir(){
		try {
			this.service.RemoverSalao(this.salao);
		} catch (SQLException e) {
			System.out.println("erro ao remover Salão"+ e.getMessage());
		}
	}
	
	public void CarregarSalaoEditar(){
		if(this.id != null){
			this.salao = service.BuscarPorId(this.id);
		}
	}
	
	
	public Salao getSalao() {
		return salao;
	}
	
	public void setSalao(Salao salao) {
		this.salao = salao;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}

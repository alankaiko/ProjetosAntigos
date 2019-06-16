package br.com.salao.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.salao.Service.ApartamentoService;
import br.com.salao.modelo.Apartamento;
import br.com.salao.modelo.Cliente;
import br.com.salao.util.MensagemUtil;

@ManagedBean
@ViewScoped
public class ApartamentoBean {
	private Apartamento apartamento;
	private ApartamentoService service;
	private List<Cliente> listaClientes;
	private Long id;
	
	public ApartamentoBean() {
		this.apartamento = new Apartamento();
		this.service = new ApartamentoService();
		this.listaClientes = this.service.ListaDeClientes();
	}
	
public void PegaCliente(SelectEvent event){}
	
	public void SalvandoApartamento(){
		try {
			this.service.SalvarAp(this.apartamento);
			MensagemUtil.addMsgInfo("Cadastro concluido, Apartamento= " +this.apartamento.getNumeroApartamento());
		} catch (SQLException e) {
			MensagemUtil.addMsgError("erro ao gravar");
			e.printStackTrace();
		}
	}
	
	public void RemoverApartamento(){
		try {
			this.service.ExcluirAp(this.apartamento);
		} catch (SQLException e) {
			MensagemUtil.addMsgError("erro ao gremover");
			e.printStackTrace();
		}
	}
	
	public void CarregarApartamento(){
		if(this.id != null)
			this.apartamento = this.service.BuscarPorId(id);
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
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}

package br.com.salao.beans;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.salao.Service.ClienteService;
import br.com.salao.modelo.Cliente;
import br.com.salao.util.MensagemUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {
	private Cliente cliente;
	private ClienteService service;
	private Long id;
	
	public ClienteBean() {
		this.cliente = new Cliente();
		this.service = new ClienteService();
	}
	
	public void SalvarCliente(){
		try {
			this.service.SalvandoCliente(this.cliente);
			MensagemUtil.addMsgInfo("Cadastro realizado "+this.cliente.getNome());
		} catch (SQLException e) {
			System.out.println("erro ao salvar cliente"+ e.getMessage());
			
		}
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoSalao/clientes/PesquisaClientes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void RemoverCliente(){
		try {
			this.service.RemoverCliente(this.cliente);
		} catch (SQLException e) {
			System.out.println("erro ao remover cliente"+ e.getMessage());
		}
	}
	
	public void CarregarClienteEditar(){
		if(this.id != null){
			this.cliente = service.BuscarPorId(this.id);
		}
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}

package br.com.salao.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.salao.Service.ClienteService;
import br.com.salao.modelo.Cliente;

@ManagedBean
@ViewScoped
public class PesquisaCliente {
	private List<Cliente> listaCliente;
	private ClienteService service;
	private Cliente cliente;
	
	public PesquisaCliente() {
		this.service = new ClienteService();
	}
	
	public void ListarTodos(){
		this.listaCliente = this.service.ListandoClientes();
	}
	
	public void ExcluirCliente(){
		try {
			this.service.RemoverCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/ProjetoSalao/clientes/PesquisaClientes.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
}

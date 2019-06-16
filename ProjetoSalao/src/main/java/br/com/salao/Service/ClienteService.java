package br.com.salao.Service;

import java.sql.SQLException;
import java.util.List;

import br.com.salao.modelo.Cliente;
import br.com.salao.repository.ClienteRepository;

public class ClienteService {
	private ClienteRepository repositorio;
	
	public ClienteService() {
		this.repositorio = new ClienteRepository();
	}
	
	public void SalvandoCliente(Cliente cliente) throws SQLException{
		this.repositorio.Salvar(cliente);
	}
	
	public void RemoverCliente(Cliente cliente)throws SQLException{
		this.repositorio.Excluir(cliente);
	}
	
	public List<Cliente> ListandoClientes(){
		return this.repositorio.ListarClientes();
	}
	
	public Cliente BuscarPorId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
}

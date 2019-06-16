package br.com.salao.Service;

import java.sql.SQLException;
import java.util.List;

import br.com.salao.modelo.Apartamento;
import br.com.salao.modelo.Cliente;
import br.com.salao.repository.ApartamentoRepository;

public class ApartamentoService {
	private ApartamentoRepository repositorio;
	
	public ApartamentoService() {
		this.repositorio = new ApartamentoRepository();
	}
	
	public void SalvarAp(Apartamento apartamento)throws SQLException{
		this.repositorio.Salvar(apartamento);
	}
	
	public void ExcluirAp(Apartamento apartamento) throws SQLException{
		this.repositorio.Excluir(apartamento);
	}
	
	public List<Apartamento> ListarApartamentos(){
		return this.repositorio.ListarApartamentos();
	}
	
	public Apartamento BuscarPorId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<Cliente> ListaDeClientes(){
		ClienteService serviceCli = new ClienteService();
		return serviceCli.ListandoClientes();
	}
}

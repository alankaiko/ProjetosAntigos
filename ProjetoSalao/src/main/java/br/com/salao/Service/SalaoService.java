package br.com.salao.Service;

import java.sql.SQLException;
import java.util.List;

import br.com.salao.modelo.Salao;
import br.com.salao.repository.SalaoRepository;

public class SalaoService {
	private SalaoRepository repositorio;
	
	public SalaoService() {
		this.repositorio = new SalaoRepository();
	}
	
	public void SalvandoSaloes(Salao salao) throws SQLException{
		this.repositorio.Salvar(salao);
	}
	
	public void RemoverSalao(Salao salao)throws SQLException{
		this.repositorio.Excluir(salao);
	}
	
	public List<Salao> ListandoSalao(){
		return this.repositorio.ListarSaloes();
	}
	
	public Salao BuscarPorId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
}

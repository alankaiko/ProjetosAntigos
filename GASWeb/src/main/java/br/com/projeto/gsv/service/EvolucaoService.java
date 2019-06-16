package br.com.projeto.gsv.service;

import java.util.List;

import br.com.gsv.domain.Evolucao;
import br.com.projeto.gsv.repository.EvolucaoRepository;

public class EvolucaoService {
	private EvolucaoRepository repositorio = new EvolucaoRepository();
	
	public void Salvando(Evolucao evolucao){
		this.repositorio.Salvar(evolucao);
	}
	
	public void Remover(Evolucao evolucao){
		this.repositorio.Remover(evolucao);
	}
	
	public List<Evolucao> ListandoTudo(){
		return this.repositorio.ListarEvolucao();
	}
	
	public Evolucao BuscandoPelaId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<Evolucao> BuscarPorPaciente(Long id){
		return this.repositorio.BuscarPorDeterminadoPaciente(id);
	}
}

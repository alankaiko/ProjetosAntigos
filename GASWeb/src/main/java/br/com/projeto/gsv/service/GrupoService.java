package br.com.projeto.gsv.service;

import java.util.List;

import br.com.gsv.domain.sub.Grupo;
import br.com.projeto.gsv.repository.GrupoRepository;

public class GrupoService {
	private GrupoRepository repositorio = new GrupoRepository();

	
	public void Salvar(Grupo grupo){
		this.repositorio.Guardar(grupo);
	}
	
	public void Remover(Grupo grupo){
		this.repositorio.Remover(grupo);
	}
	
	public List<Grupo> ListandoGrupos(){
		return repositorio.ListarGrupo();
	}
	
	public Grupo BuscandoId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<Grupo> BuscandoPeloNome(String nome){
		return this.repositorio.BuscarPeloNome(nome);
	}
	
}

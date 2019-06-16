package br.com.projeto.gsv.service;

import java.util.List;

import br.com.gsv.domain.Fabricante;
import br.com.gsv.domain.Funcionario;
import br.com.gsv.domain.Produto;
import br.com.projeto.gsv.repository.ProdutoRepository;

public class ProdutoService {
	private  ProdutoRepository repositorio = new ProdutoRepository();

	
	public void Salvar(Produto produto){
		this.repositorio.Guardar(produto);
	}
	
	public void Remover(Produto produto){
		this.repositorio.Remover(produto);
	}
	
	public List<Produto> ListandoProdutos(){
		return repositorio.ListarProdutos();
	}
	
	public Produto BuscandoCodigo(String codigo){
		return this.repositorio.BuscarPorCodigo(codigo);
	}
	
	public List<Produto> BuscandoPelaDescricao(String descricao){
		return this.repositorio.BuscarPeloNome(descricao);
	}
	
	
	public Produto BuscandoId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	//Acessa o método Service do Objeto Fabricante para retornar uma lista completa de todos os Fabricantes
	public List<Fabricante> FabricanteListaCompleta(){
		FabricanteService serviceFab = new FabricanteService();
		return serviceFab.ListandoFabricantes();
	}
}

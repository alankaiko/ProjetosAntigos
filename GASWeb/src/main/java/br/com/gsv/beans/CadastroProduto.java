package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Fabricante;
import br.com.gsv.domain.Produto;
import br.com.projeto.gsv.service.ProdutoService;

@ManagedBean(name="MBCadProduto")
@ViewScoped
public class CadastroProduto {
	private Produto produto;
	private ProdutoService service;
	private String codigo;
	private List<Fabricante> listaFabricante;
	
	public CadastroProduto() {
		this.service = new ProdutoService();
		this.produto = new Produto();
	}
	
	public void Inicializar(){
		this.listaFabricante = service.FabricanteListaCompleta();
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/produtos/GerenciarProdutos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Salvando(){
		this.service.Salvar(this.produto);
	}
	
	public void CarregarProdutoEditar(){
		if(this.codigo != null){
			this.produto = service.BuscandoCodigo(this.codigo);
			
		}
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public List<Fabricante> getListaFabricante() {
		return listaFabricante;
	}
}

package br.com.gsv.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.gsv.domain.Produto;
import br.com.gsv.util.Mensagem;
import br.com.projeto.gsv.service.ProdutoService;



@ManagedBean(name="MBProduto")
@ViewScoped
public class ConsultaProduto {
	private Produto produtoSelecionado;
	private ProdutoService service;
	private List<Produto> listaProduto;
	
	public ConsultaProduto() {
		service = new ProdutoService();
	}
	
	public void ListarGeral(){
		this.listaProduto = service.ListandoProdutos();
	}

	public void Excluir(){
		try {
			this.service.Remover(this.produtoSelecionado);
			
			Mensagem.mensagemInfo("Produto "+ this.produtoSelecionado.getDescricao()+ " excluído com sucesso");
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void Redirecionar(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/GASWeb/produtos/GerenciarProdutos.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
}

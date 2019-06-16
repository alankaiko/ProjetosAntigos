package br.com.exemplo.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.exemplo.domain.Pessoa;
import br.com.exemplo.service.PessoaService;

@ManagedBean(name="MBPessoa")
public class PessoaBean {
	private Pessoa pessoa;
	private PessoaService service;
	private List<Pessoa> listaPessoa;
	private Long id;
	
	@PostConstruct
	public void Iniciar() {
		this.service = new PessoaService();
		this.pessoa = new Pessoa();
	}
	
	public void CarregarLista(){
		this.listaPessoa = this.service.ListarTudo();
	}
	
	
	public void SalvandoPessoa(){
		this.service.Salvar(pessoa);
	}
	
	public void AtualizandoPessoa(){
		this.service.AtualizarDados(this.pessoa);
	}
	
	public void ExcluirNego(){
		this.service.Deletar(this.pessoa.getId());
	}
	
	public void CarregarPessoa(){
		if(this.id != null)
			this.pessoa = this.service.BuscarPessoa(this.id);
	}
	
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}

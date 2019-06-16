package br.com.exemplo.service;

import java.util.List;

import br.com.exemplo.dao.PessoaDao;
import br.com.exemplo.domain.Pessoa;
import br.com.exemplo.util.MensagemUtil;

public class PessoaService {
	private PessoaDao dao;
	
	public PessoaService() {
		dao = new PessoaDao();
	}
	
	public void Salvar(Pessoa pessoa){
		this.dao.Salvar(pessoa);	
		MensagemUtil.addMsgInfo("Cliente "+ pessoa.getNome()+ " registrado!!");
	}
	
	public void Deletar(Long id){
		this.dao.Deletar(id);
		MensagemUtil.addMsgInfo("Cliente "+ " deletado!!");
	}
	
	public List<Pessoa> ListarTudo(){
		return this.dao.ListaPessoas();
	}
	
	public void AtualizarDados(Pessoa pessoa){
		this.dao.AtualizarDados(pessoa);
	}
	
	public Pessoa BuscarPessoa(Long id){
		return this.dao.BuscarPelaId(id);
	}
}

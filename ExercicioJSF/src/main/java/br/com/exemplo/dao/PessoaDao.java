package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.domain.Pessoa;
import br.com.exemplo.util.Conexoes;


public class PessoaDao {
	private Connection conexao;
	
	public PessoaDao() {
		super();
		conexao = Conexoes.getConectar();
	}
	
	public void Salvar(Pessoa pessoa){
		String sql = "insert into pessoa(nome, idade, cpf) values(?,?,?)";
		
		
		try {
			PreparedStatement prepara = this.conexao.prepareStatement(sql);
			prepara.setString(1, pessoa.getNome());
			prepara.setInt(2, pessoa.getIdade());
			prepara.setString(3, pessoa.getCpf());
			
			prepara.execute();
			prepara.close();
		} catch (Exception e) {
			System.out.println("erro no metodo salvar nego");
			e.printStackTrace();
		}
	}
	
	public void AtualizarDados(Pessoa pessoa){
		String sql = "update pessoa set nome=?, idade=?, cpf? where id=?";
		
		PreparedStatement prepara;
		try {
			prepara = conexao.prepareStatement(sql);
			prepara.setString(1, pessoa.getNome());
			prepara.setInt(2, pessoa.getIdade());
			prepara.setString(3, pessoa.getCpf());
			prepara.setLong(4, pessoa.getId());
			
			prepara.close();
		} catch (SQLException e) {
			System.out.println("erro nometodo atualizar nego");
			e.printStackTrace();
		}
		
	}
	
	public void Deletar(Long id){
		String sql = "delete from pessoa where id=?";
		
		try {
			PreparedStatement prepara = this.conexao.prepareStatement(sql);
			prepara.setLong(1, id);
			
			prepara.execute();
			prepara.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Pessoa> ListaPessoas(){
		String sql = "select id, nome, idade, cpf from pessoa order by id";
		List<Pessoa> lista= new ArrayList<Pessoa>();
		
		try {
			PreparedStatement prepara = this.conexao.prepareStatement(sql);
			ResultSet resultado = prepara.executeQuery();
			
			while(resultado.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultado.getLong("id"));
				pessoa.setNome(resultado.getString("nome"));
				pessoa.setIdade(resultado.getInt("idade"));
				pessoa.setCpf(resultado.getString("cpf"));
				lista.add(pessoa);
			}
			prepara.close();
		} catch (Exception e) {
			System.out.println("erro no metodo listar pessoas");
		}
		
		return lista;
	}
	
	public Pessoa BuscarPelaId(Long id){
		String sql= "select * from pessoa where id=?";
		Pessoa pessoa= new Pessoa();
		
		try {
			PreparedStatement prepara = conexao.prepareStatement(sql);
			prepara.setLong(1, id);
			
			ResultSet resultado = prepara.executeQuery();
			 
			while(resultado.next()){
				pessoa.setId(resultado.getLong("id"));
				pessoa.setNome(resultado.getString("nome"));
				pessoa.setIdade(resultado.getInt("idade"));
				pessoa.setCpf(resultado.getString("cpf"));
			}			
			prepara.close();
		} catch (Exception e) {
			System.out.println("erro no metodo buscar pela id");
			e.printStackTrace();
		}
		
		return pessoa;
	}
	
}
















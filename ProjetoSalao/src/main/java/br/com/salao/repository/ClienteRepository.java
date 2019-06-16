package br.com.salao.repository;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.salao.modelo.Cliente;
import br.com.salao.util.HibernateUtil;

public class ClienteRepository {
	private Session sessao;
	
	public void Salvar(Cliente cliente)throws SQLException{
		sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = sessao.beginTransaction();
		sessao.merge(cliente);
		transacao.commit();
		sessao.close();
	}
	
	public void Excluir(Cliente cliente)throws SQLException{
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(cliente);
		transacao.commit();
		sessao.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> ListarClientes(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Cliente> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Cliente.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		return lista;
	}
	
	public Cliente BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Cliente.buscarPorId");
			consulta.setLong("id", id);
			cliente = (Cliente) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return cliente;
	}
}

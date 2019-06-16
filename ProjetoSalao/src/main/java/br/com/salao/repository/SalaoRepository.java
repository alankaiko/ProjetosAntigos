package br.com.salao.repository;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.salao.modelo.Salao;
import br.com.salao.util.HibernateUtil;

public class SalaoRepository {
	private Session sessao;
	
	public void Salvar(Salao salao)throws SQLException{
		sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = sessao.beginTransaction();
		sessao.merge(salao);
		transacao.commit();
		sessao.close();
	}
	
	public void Excluir(Salao salao)throws SQLException{
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(salao);
		transacao.commit();
		sessao.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Salao> ListarSaloes(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Salao> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Salao.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		return lista;
	}
	
	public Salao BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Salao salao = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Salao.buscarPorId");
			consulta.setLong("id", id);
			salao = (Salao) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return salao;
	}
}

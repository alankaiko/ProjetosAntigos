package br.com.salao.repository;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.salao.modelo.Apartamento;
import br.com.salao.util.HibernateUtil;

public class ApartamentoRepository {
	private Session sessao;
	
	public void Salvar(Apartamento apartamento)throws SQLException{
		sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = sessao.beginTransaction();
		sessao.merge(apartamento);
		transacao.commit();
		sessao.close();
	}
	
	public void Excluir(Apartamento apartamento)throws SQLException{
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(apartamento);
		transacao.commit();
		sessao.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Apartamento> ListarApartamentos(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Apartamento> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Apartamento.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		return lista;
	}
	
	public Apartamento BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Apartamento apartamento = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Apartamento.buscarPorId");
			consulta.setLong("id", id);
			apartamento = (Apartamento) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return apartamento;
	}
}

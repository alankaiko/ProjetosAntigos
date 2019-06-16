package br.com.projeto.gsv.repository;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gsv.domain.Evolucao;
import br.com.gsv.util.HibernateUtil;

public class EvolucaoRepository {
	Session sessao;
	Transaction transacao = null;
	
	public void Salvar(Evolucao evolucao){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(evolucao);
			transacao.commit();
		} catch (Exception e) {
			if(transacao != null)
				transacao.rollback();
			
			throw e;
		}finally{
			sessao.close();
		}
	}
	
	public void Remover(Evolucao evolucao){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(evolucao);
			transacao.commit();
		} catch (Exception e) {
			if(transacao != null)
				transacao.rollback();
			
			throw e;
		}finally{
			sessao.close();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Evolucao> ListarEvolucao(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Evolucao> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Evolucao.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		return lista;
	}
	
	
	public Evolucao BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Evolucao evolucao = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Evolucao.buscarPorId");
			consulta.setLong("id", id);
			evolucao = (Evolucao) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return evolucao;
	}
	
	@SuppressWarnings("unchecked")
	public List<Evolucao> BuscarPorDeterminadoPaciente(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Evolucao> lista = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Evolucao.buscarPorNome");
			consulta.setLong("id",id);
			lista = consulta.list();
		} catch (RuntimeException e) {
			
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
}




















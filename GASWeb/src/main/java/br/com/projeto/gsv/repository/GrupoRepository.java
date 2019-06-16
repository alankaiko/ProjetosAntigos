package br.com.projeto.gsv.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gsv.domain.sub.Grupo;
import br.com.gsv.util.HibernateUtil;

public class GrupoRepository {
	Session sessao;
	Transaction transacao = null;
	
	//Metodo que salva um novo cliente Pessoa Fisica ou Pessoa Juridica
	public void Guardar(Grupo grupo){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(grupo);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			
			System.out.println("Erro no metodo Guardar Grupos repository");
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	public void Remover(Grupo grupo) {
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(grupo);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	
	public Grupo BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Grupo grupo = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Grupo.buscarPorId");
			consulta.setLong("id", id);
			grupo = (Grupo) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return grupo;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Grupo> ListarGrupo(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Grupo> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Grupo.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Grupo> BuscarPeloNome(String nome){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Grupo> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Grupo.buscarPeloNome");
			consulta.setString("nome", "%"+nome+"%");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
}

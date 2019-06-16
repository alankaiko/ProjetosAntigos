package br.com.projeto.gsv.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gsv.domain.Fabricante;
import br.com.gsv.domain.Funcionario;
import br.com.gsv.util.HibernateUtil;
import br.com.gsv.util.MensagemPainelUtil;

public class FabricanteRepository {
	Session sessao;
	Transaction transacao = null;
	
	//Metodo que salva um novo cliente Pessoa Fisica ou Pessoa Juridica
	public void Guardar(Fabricante fabricante){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(fabricante);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			
			System.out.println("Erro no metodo Guardar Fabricante repository");
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	public void Remover(Fabricante fabricante) {
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(fabricante);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	
	public Fabricante BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorId");
			consulta.setLong("id", id);
			fabricante = (Fabricante) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return fabricante;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> ListarFabricante(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Fabricante.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> BuscarPeloNome(String descricao){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPeloNome");
			consulta.setString("descricao", "%"+descricao+"%");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}

}

package br.com.projeto.gsv.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gsv.domain.Usuario;
import br.com.gsv.util.HibernateUtil;
import br.com.gsv.util.MensagemPainelUtil;

public class UsuarioRepository {
	Session sessao;
	Transaction transacao = null;
	
	
	public void Guardar(Usuario usuario){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(usuario);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			
			System.out.println("Erro no metodo Guardar Usuario repository");
		} finally {
			sessao.close();
		}
	}
	
	
	public void Remover(Usuario usuario) {
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(usuario);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	
	
	public Usuario BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscarPorId");
			consulta.setLong("id", id);
			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException e) {
			
			throw e;
		}finally{
			sessao.close();
		}		
		return usuario;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> ListarUsuario(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
		
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
	
	
	public Usuario BuscarPeloLogin(String login){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscarPeloLogin");
			consulta.setString("login", login);
			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException e) {
			
			throw e;
		}finally{
			sessao.close();
		}
		
		return usuario;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> BuscarPeloNome(String nome){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> lista = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Usuario.buscarPorNome");
			consulta.setString("nome","%"+nome+"%");
			lista = consulta.list();
		} catch (RuntimeException e) {
			
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	

	public Usuario Autenticar(String login, String senha){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.autenticar");
			consulta.setString("login", login);
			consulta.setString("senha", senha);
			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException e) {
		
			throw e;
		}finally{
			sessao.close();
		}
		
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public Long VerificaQTDRegistro(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Long> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.verificaQtd");
			lista = consulta.list();
		} catch (RuntimeException e) {
		
			throw e;
		}finally{
			sessao.close();
		}
	
		
		return lista.get(0);
	}
	

}

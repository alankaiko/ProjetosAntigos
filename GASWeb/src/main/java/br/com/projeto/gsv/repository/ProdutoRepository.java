package br.com.projeto.gsv.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gsv.domain.Funcionario;
import br.com.gsv.domain.Produto;
import br.com.gsv.util.HibernateUtil;
import br.com.gsv.util.MensagemPainelUtil;



public class ProdutoRepository {
	Session sessao;
	Transaction transacao = null;
	

	//Metodo que salva um novo produto
		public void Guardar(Produto produto){
			sessao = HibernateUtil.getSessionFactory().openSession();
			
			try {
				transacao = sessao.beginTransaction();
				sessao.merge(produto);
				transacao.commit();
			} catch (RuntimeException e) {
				if (transacao != null)
					transacao.rollback();
				
				System.out.println("Erro no metodo Guardar Produto repository");
				throw e;
			} finally {
				sessao.close();
			}
		}
		
		
		public void Remover(Produto produto) {
			sessao = HibernateUtil.getSessionFactory().openSession();
			
			try {
				transacao = sessao.beginTransaction();
				sessao.delete(produto);
				transacao.commit();
			} catch (RuntimeException e) {
				if (transacao != null)
					transacao.rollback();
				throw e;
			} finally {
				sessao.close();
			}
		}
		
		

		public Produto BuscarPorCodigo(String codigo){
			sessao = HibernateUtil.getSessionFactory().openSession();
			Produto produto = null;
			
			
			try {
				Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
				consulta.setString("codigo", codigo);
				produto = (Produto) consulta.uniqueResult();
			} catch (RuntimeException e) {
				throw e;
			}finally{
				sessao.close();
			}
			return produto;
		}
		
		@SuppressWarnings("unchecked")
		public List<Produto> ListarProdutos(){
			sessao = HibernateUtil.getSessionFactory().openSession();
			List<Produto> lista = null;
			
			try {
				Query consulta = sessao.getNamedQuery("Produto.listar");
				lista = consulta.list();
			} catch (RuntimeException e) {
				throw e;
			}finally{
				sessao.close();
			}
			
			return lista;
		}
		
		
		@SuppressWarnings("unchecked")
		public List<Produto> BuscarPeloNome(String descricao){
			sessao = HibernateUtil.getSessionFactory().openSession();
			List<Produto> lista = null;
			
			try {
				Query consulta = sessao.getNamedQuery("Produto.buscarPelaDescricao");
				consulta.setString("descricao", "%"+descricao+"%");
				lista = consulta.list();
			} catch (RuntimeException e) {
				throw e;
			}finally{
				sessao.close();
			}
			
			return lista;
		}
		
		
		
		
		public Produto BuscarPorId(Long id){
			sessao = HibernateUtil.getSessionFactory().openSession();
			Produto produto = null;
			
			try {
				Query consulta = sessao.getNamedQuery("Produto.buscarPorId");
				consulta.setLong("id", id);
				produto = (Produto) consulta.uniqueResult();
			} catch (RuntimeException e) {
				throw e;
			}finally{
				sessao.close();
			}		
			return produto;
		}
		
		
	
}



















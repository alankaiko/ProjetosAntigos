package br.com.projeto.gsv.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gsv.domain.Agenda;
import br.com.gsv.domain.Paciente;
import br.com.gsv.util.HibernateUtil;

public class AgendaRepository {
	Session sessao;
	Transaction transacao = null;
	
	//Metodo que salva um novo cliente Pessoa Fisica ou Pessoa Juridica
	public void Guardar(Agenda agenda){
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(agenda);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	public void Remover(Agenda agenda) {
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(agenda);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null)
				transacao.rollback();
			
			System.out.println("Erro no metodo Remover Agenda repository");
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	
	public Agenda BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Agenda agenda = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Agenda.buscarPorId");
			consulta.setLong("id", id);
			agenda = (Agenda) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return agenda;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<String> ListandoHorarios(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<String> lista = null;
		
		
		try {
			Query consulta = sessao.getNamedQuery("Agenda.listarHorarios");
			lista = consulta.list();
		} catch (RuntimeException e) {
			System.out.println("ERRO NO METODO LISTAR DO OBJETO AGENDA");
			throw e;
		}finally{
			sessao.close();
		}
		
		
		return lista;
	}
		
	public List<String> ListaDeHorariosPorDia(Date data){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<String> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Agenda.buscarPorData");
			consulta.setDate("data", data);
			lista = consulta.list();
		} catch (RuntimeException e) {
			System.out.println("ERRO NO METODO BUSCAR HORAS POR DETERMINADO DIA");
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
	public List<Agenda> ListaDeAgendados(Date data){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Agenda> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Agenda.listaAgenda");
			consulta.setDate("data", data);
			lista = consulta.list();
		} catch (RuntimeException e) {
			System.out.println("ERRO NO METODO LISTA DE AGENDADOS");
			throw e;
		}
		
		return lista;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Agenda> ListarAgendaTotal(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Agenda> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Agenda.listaTotal");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Agenda> BuscarAgendaPeloNome(String nome){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Agenda> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Agenda.buscarPorPaciente");
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
























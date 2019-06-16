package br.com.salao.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.salao.modelo.Reserva;
import br.com.salao.util.HibernateUtil;

public class ReservasRepository {
	private Session sessao;
	
	public void Salvar(Reserva reserva)throws SQLException{
		sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = sessao.beginTransaction();
		sessao.merge(reserva);
		transacao.commit();
		sessao.close();
	}
	
	public void Excluir(Reserva reserva)throws SQLException{
		sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = sessao.beginTransaction();
		sessao.delete(reserva);
		transacao.commit();
		sessao.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserva> ListarReservas(){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<Reserva> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Reserva.listar");
			lista = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
		return lista;
	}
	
	public Reserva BuscarPorId(Long id){
		sessao = HibernateUtil.getSessionFactory().openSession();
		Reserva reserva = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Reserva.buscarPorId");
			consulta.setLong("id", id);
			reserva = (Reserva) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}		
		return reserva;
	}
	
	public List<String> ListaDeHorariosPorDia(Date data){
		sessao = HibernateUtil.getSessionFactory().openSession();
		List<String> lista = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Reserva.buscarPorData");
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
}

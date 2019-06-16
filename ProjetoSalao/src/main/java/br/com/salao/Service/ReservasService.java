package br.com.salao.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.salao.modelo.Apartamento;
import br.com.salao.modelo.Reserva;
import br.com.salao.modelo.Salao;
import br.com.salao.repository.ReservasRepository;

public class ReservasService {
	private ReservasRepository repositorio;
	
	public ReservasService() {
		this.repositorio = new ReservasRepository();
	}
	
	public void SalvandoReserva(Reserva reserva) throws SQLException{
		this.repositorio.Salvar(reserva);
	}
	
	public void RemoverReserva(Reserva reserva)throws SQLException{
		this.repositorio.Excluir(reserva);
	}
	
	public List<Reserva> ListandoReservas(){
		return this.repositorio.ListarReservas();
	}
	
	public Reserva BuscarPorId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<String> ListarHorariosDisponiveis(Date data){
		return this.repositorio.ListaDeHorariosPorDia(data);
	}
	
	public List<Apartamento> ListarApartamentos(){
		ApartamentoService serviceAp = new ApartamentoService();
		return serviceAp.ListarApartamentos();
	}
	
	public List<Salao> ListaSalao(){
		SalaoService serviceSa = new SalaoService();
		return serviceSa.ListandoSalao();
	}
}

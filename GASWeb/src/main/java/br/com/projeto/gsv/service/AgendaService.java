package br.com.projeto.gsv.service;

import java.util.Date;
import java.util.List;

import br.com.gsv.domain.Agenda;
import br.com.gsv.domain.Funcionario;
import br.com.gsv.domain.Paciente;
import br.com.gsv.domain.Prontuario;
import br.com.projeto.gsv.repository.AgendaRepository;

public class AgendaService {
	private AgendaRepository repositorio = new AgendaRepository();

	
	public void Salvar(Agenda agenda){
		this.repositorio.Guardar(agenda);
	}
	
	public void Remover(Agenda agenda){
		this.repositorio.Remover(agenda);
	}	
	
	public Agenda BuscandoId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<String> ListarHorarios(Date data){
		return this.repositorio.ListaDeHorariosPorDia(data);
	}
	
	public List<Agenda> ListaDosAgendados(Date data){
		return this.repositorio.ListaDeAgendados(data);
	}
	
	public List<Agenda> ListarTotalAgenda(){
		return this.repositorio.ListarAgendaTotal();
	}
	
	public List<Paciente> ListandoPacientes(){
		PacienteService servicePac = new PacienteService();
		return servicePac.ListandoPacientes();
	}
	
	public List<Funcionario> ListandoFuncionarios(){
		FuncionarioService serviceFun = new FuncionarioService();
		return serviceFun.ListandoFuncionarios();
	}
	
	public List<Prontuario> ListarProntuariosPorCliente(Long id){
		ProntuarioService serviceProntuario = new ProntuarioService();
		return serviceProntuario.BuscaPelaIdPaciente(id);
	}
	
	public void SalvandoPaciente(Paciente paciente){
		PacienteService servicePac = new PacienteService();
		servicePac.Salvar(paciente);
	}
	
	public List<Agenda> AgendaPorPaciente(String nome){
		return this.repositorio.BuscarAgendaPeloNome(nome);
	}
	
	public Paciente BuscarPorNomePaciente(String nome){
		PacienteService servicePac = new PacienteService();
		return servicePac.BuscarNomeUnico(nome);
	}
}






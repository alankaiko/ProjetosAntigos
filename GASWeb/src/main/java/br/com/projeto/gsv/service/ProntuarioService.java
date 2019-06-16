package br.com.projeto.gsv.service;

import java.util.Date;
import java.util.List;

import br.com.gsv.domain.Funcionario;
import br.com.gsv.domain.Paciente;
import br.com.gsv.domain.Prontuario;
import br.com.projeto.gsv.repository.ProntuarioRepository;

public class ProntuarioService {
	ProntuarioRepository repositorio = new ProntuarioRepository();
	
	public void Salvar(Prontuario prontuario){
		this.repositorio.Guardar(prontuario);
	}
	
	
	public List<Prontuario> ListandoProntuarios(){
		return repositorio.ListarProntuarios();
	}
	
	public Prontuario BuscandoId(Long id){
		return this.repositorio.BuscarPorId(id);
	}
	
	public List<Prontuario> BuscaPelaIdPaciente(Long id){
		return this.repositorio.BuscarPorIdPaciente(id);
	}
	
	public void Remover(Prontuario prontuario){
		this.repositorio.Remover(prontuario);
	}
	
	public List<Prontuario> PegandoPelaData(Date data){
		return this.repositorio.PegarPelaData(data);
	}
	
	//Listando Pacientes para prontuario
	public List<Paciente> ListandoPacientes(){
		PacienteService pacienteServ = new PacienteService();
		return pacienteServ.ListandoPacientes();
	}
	
	//Listando Funcionarios para procurar em prontuarios
	public List<Funcionario> ListandoFuncionarios(){
		FuncionarioService serviceFun = new FuncionarioService();
		return serviceFun.ListandoFuncionarios();
	}
	
}

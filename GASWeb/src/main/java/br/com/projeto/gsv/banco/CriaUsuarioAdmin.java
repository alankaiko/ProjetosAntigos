package br.com.projeto.gsv.banco;

import br.com.gsv.domain.Funcionario;
import br.com.gsv.domain.Usuario;
import br.com.gsv.domain.sub.Grupo;
import br.com.projeto.gsv.service.FuncionarioService;
import br.com.projeto.gsv.service.GrupoService;
import br.com.projeto.gsv.service.UsuarioService;

public class CriaUsuarioAdmin {
	private Funcionario funcionario;
	private FuncionarioService serviceFun;
	private Usuario usuario;
	private UsuarioService serviceUser;
	private Grupo grupo;
	private GrupoService serviceGrupo;
	
	public static void main(String[] args){
		CriaUsuarioAdmin us = new CriaUsuarioAdmin();
	}
	
	public CriaUsuarioAdmin() {
		funcionario = new Funcionario();
		serviceFun = new FuncionarioService();
		usuario = new Usuario();
		serviceUser = new UsuarioService();
		grupo = new Grupo();
		serviceGrupo = new GrupoService();
		
		AdicionaGrupo();
		AdicionaFuncionario();
		AdicionaUsuario();
	}

	

	private void AdicionaFuncionario(){
		this.funcionario.setNome("Admin admin");
		this.funcionario.setRg("0000000");
		this.funcionario.setCpf("00000000000");
		
		this.serviceFun.Salvar(this.funcionario);
	}
	
	private void AdicionaGrupo(){
		this.grupo.setNome("ADMINISTRADOR");
		this.grupo.setDescricao("ADMINISTRADOR");
		
		//this.grupo.setNome("ENFERMEIRO");
		//this.grupo.setDescricao("ENFERMEIRO");
		//this.serviceGrupo.Salvar(grupo);
		
		//this.grupo.setNome("MEDICO");
		//this.grupo.setDescricao("MEDICO");
		//this.serviceGrupo.Salvar(grupo);
		
		//this.grupo.setNome("SECRETARIA");
		//this.grupo.setDescricao("SECRETARIA");
		//this.serviceGrupo.Salvar(grupo);
		
		//this.grupo.setNome("TESTOSO");
		//this.grupo.setDescricao("TESTOSO");
		//this.serviceGrupo.Salvar(grupo);
	}
	
	private void AdicionaUsuario(){
		this.usuario.setFuncionario(this.serviceFun.BuscandoId(1L));
		this.usuario.setLogin("admin");
		this.usuario.setSenha("123");
		this.usuario.setGrupo(grupo);
		
		
		this.serviceUser.Salvar(this.usuario);
	}
	
	
	
}

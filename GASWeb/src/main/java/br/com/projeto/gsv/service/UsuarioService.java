package br.com.projeto.gsv.service;

import java.util.List;

import br.com.gsv.domain.Funcionario;
import br.com.gsv.domain.Usuario;
import br.com.gsv.domain.sub.Grupo;
import br.com.projeto.gsv.repository.UsuarioRepository;

public class UsuarioService {
	private UsuarioRepository repositorio = new UsuarioRepository();

	
	public void Salvar(Usuario usuario){
		this.repositorio.Guardar(usuario);
	}
	
	public void Remover(Usuario usuario){
		this.repositorio.Remover(usuario);
	}
	
	public List<Usuario> ListandoUsuarios(){
		return this.repositorio.ListarUsuario();
	}
	
	public Long VerificaQtdReg(){
		return this.repositorio.VerificaQTDRegistro();
	}
	
	public Usuario Autenticando(String login, String senha){
		return this.repositorio.Autenticar(login, senha);
	}
	
	public Usuario BuscandoPeloLogin(String login){
		return this.repositorio.BuscarPeloLogin(login);
	}
	
	public List<Usuario> ListandoPorNome(String nome){
		return repositorio.BuscarPeloNome(nome);
	}
	
	//Lista Funcionarios para cadastrar no Usuario
	public List<Funcionario> ListarFuncionarios(){
		FuncionarioService serviceFun = new FuncionarioService();
		return serviceFun.ListandoFuncionarios();
	}
	
	public List<Grupo> ListandoGrupos(){
		GrupoService serviceGrupo = new GrupoService();
		return serviceGrupo.ListandoGrupos();
	}

}

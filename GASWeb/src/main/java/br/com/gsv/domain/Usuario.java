package br.com.gsv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.gsv.domain.sub.Grupo;

@Table
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.listar", query="SELECT usuario FROM Usuario usuario order by login"),
	@NamedQuery(name="Usuario.verificaQtd", query="SELECT COUNT(*) FROM Usuario usuario"),
	@NamedQuery(name="Usuario.buscarPorId", query="SELECT usuario FROM Usuario usuario WHERE usuario.id = :id"),
	@NamedQuery(name="Usuario.buscarPorNome", query="SELECT usuario FROM Usuario usuario WHERE usuario.funcionario.nome LIKE :nome"),
	@NamedQuery(name="Usuario.buscarPeloLogin", query="SELECT usuario FROM Usuario usuario WHERE usuario.login = :login"),
	@NamedQuery(name="Usuario.autenticar", query="SELECT usuario FROM Usuario usuario WHERE usuario.login = :login AND usuario.senha= :senha")
})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;

	
	@OneToOne
	@JoinColumn(name = "tbl_funcionario_id", referencedColumnName = "id", nullable=false)
	private Funcionario funcionario;
	
	@Column(nullable=false, unique=true)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@ManyToOne(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name="usu_id"), inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private Grupo grupo;
	
	
	
	public Usuario() {
		login = new String();
		senha = new String();
		funcionario = new Funcionario();
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}

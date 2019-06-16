package br.com.gsv.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.gsv.domain.sub.Contato_cli;
import br.com.gsv.domain.sub.Contato_fun;
import br.com.gsv.domain.sub.Endereco_cli;
import br.com.gsv.domain.sub.Endereco_fun;
import br.com.gsv.domain.sub.RegistroCoren;




@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Funcionario.listar", query="SELECT funcionario FROM Funcionario funcionario order by id"),
	@NamedQuery(name="Funcionario.buscarPorId", query="SELECT funcionario FROM Funcionario funcionario WHERE funcionario.id= :id"),
	@NamedQuery(name="Funcionario.buscarPeloNome", query="SELECT funcionario FROM Funcionario funcionario WHERE funcionario.nome LIKE :nome"),
	@NamedQuery(name="Funcionario.buscarCrm", query="SELECT funcionario FROM Funcionario funcionario WHERE funcionario.registroCoren.coren= :coren")
})
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;

	
	
	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private Contato_fun contato;
	private Endereco_fun endereco;
	private RegistroCoren registroCoren;

	public Funcionario() {
		nome = new String();
		cpf = new String();
		rg = new String();
		contato = new Contato_fun();
		endereco = new Endereco_fun();
		registroCoren = new RegistroCoren();
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable=false, unique=true, length=100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable=false, unique=true, length=15)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_contato_id", referencedColumnName = "id")
	public Contato_fun getContato() {
		return contato;
	}

	public void setContato(Contato_fun contato) {
		this.contato = contato;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_endereco_id", referencedColumnName = "id")
	public Endereco_fun getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco_fun endereco) {
		this.endereco = endereco;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_registrocoren_id", referencedColumnName = "reg_id")
	public RegistroCoren getRegistroCoren() {
		return registroCoren;
	}

	public void setRegistroCoren(RegistroCoren registroCoren) {
		this.registroCoren = registroCoren;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
			builder.append("Funcionario [id=")
			.append(id)
			.append(", nome=")
			.append(nome)
			.append(", cpf=")
			.append(cpf)
			.append(", rg=")
			.append(rg)
			.append(", contato=")
			.append(contato)
			.append(", endereco=")
			.append(endereco)
			.append("]");
		return builder.toString();
	}
	
	
	

}

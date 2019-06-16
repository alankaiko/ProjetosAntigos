package br.com.salao.modelo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table
@Entity
@NamedQueries({
	@NamedQuery(name="Cliente.listar", query="SELECT cliente FROM Cliente cliente"),
	@NamedQuery(name="Cliente.buscarPorId", query="SELECT cliente FROM Cliente cliente WHERE cliente.id= :id")
})
public class Cliente {
	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

}

package br.com.gsv.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Convenio.listar", query="SELECT convenio FROM Convenio convenio order by id"),
	@NamedQuery(name="Convenio.buscarPorId", query="SELECT convenio FROM Convenio convenio WHERE convenio.id = :id"),
	@NamedQuery(name="Convenio.buscarPeloNome", query="SELECT convenio FROM Convenio convenio WHERE convenio.nome LIKE :nome")
})
public class Convenio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="conv_id")
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String nome;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
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
		Convenio other = (Convenio) obj;
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
		builder.append(nome);
		return builder.toString();
	}
	
	
	
	

}

package br.com.gsv.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Fabricante.listar", query="SELECT fabricante FROM Fabricante fabricante order by id"),
	@NamedQuery(name="Fabricante.buscarPorId", query="SELECT fabricante FROM Fabricante fabricante WHERE fabricante.id = :id"),
	@NamedQuery(name="Fabricante.buscarPeloNome", query="SELECT fabricante FROM Fabricante fabricante WHERE fabricante.descricao LIKE :descricao")
})
public class Fabricante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="fab_codigo")
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String descricao;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Fabricante other = (Fabricante) obj;
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
		builder.append(descricao);
		return builder.toString();
	}

	
}

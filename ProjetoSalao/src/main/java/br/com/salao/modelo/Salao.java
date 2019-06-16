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
	@NamedQuery(name="Salao.listar", query="SELECT salao FROM Salao salao"),
	@NamedQuery(name="Salao.buscarPorId", query="SELECT salao FROM Salao salao WHERE salao.id= :id")
})
public class Salao {
	private Long id;
	private String nomeSalao;
	private String bloco;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeSalao() {
		return nomeSalao;
	}
	
	public void setNomeSalao(String nomeSalao) {
		this.nomeSalao = nomeSalao;
	}
	
	public String getBloco() {
		return bloco;
	}
	
	public void setBloco(String bloco) {
		this.bloco = bloco;
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
		Salao other = (Salao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

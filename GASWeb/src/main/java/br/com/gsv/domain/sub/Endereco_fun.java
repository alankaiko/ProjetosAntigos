package br.com.gsv.domain.sub;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Endereco_fun implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String logradouro;
	private String complemento;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 100)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(length = 80)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(length = 20)
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(length = 40)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(length = 50)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(length = 50)
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(length=10)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
		Endereco_fun other = (Endereco_fun) obj;
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
		builder.append("Endereco [id=").append(id).append(", logradouro=")
			.append(logradouro)
			.append(", complemento=")
			.append(complemento)
			.append(", numero=")
			.append(numero)
			.append(", bairro=")
			.append(bairro)
			.append(", cidade=")
			.append(cidade)
			.append(", estado=")
			.append(estado)
			.append(", cep=")
			.append(cep)
			.append(", funcionario=")
			.append("]");
		return builder.toString();
	}

	
	
}

package br.com.gsv.domain.sub;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RegistroCoren {
	
	private Long id;
	private String coren;
	private String inscricao;
	private String uf;
	
	public RegistroCoren() {
		coren = new String();
		inscricao = new String();
		uf = new String();
	}
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="reg_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoren() {
		return coren;
	}

	public void setCoren(String coren) {
		this.coren = coren;
	}

	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}

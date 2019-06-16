package br.com.gsv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table
@Entity
public class Conjugue {
	private Long id;
	private String conjugue;
	private String profissaoConjugue;
	private String telefoneConjugue;
	
	public Conjugue() {
		conjugue = new String();
		profissaoConjugue = new String();
		telefoneConjugue = new String();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConjugue() {
		return conjugue;
	}

	public void setConjugue(String conjugue) {
		this.conjugue = conjugue;
	}

	public String getProfissaoConjugue() {
		return profissaoConjugue;
	}

	public void setProfissaoConjugue(String profissaoConjugue) {
		this.profissaoConjugue = profissaoConjugue;
	}

	public String getTelefoneConjugue() {
		return telefoneConjugue;
	}

	public void setTelefoneConjugue(String telefoneConjugue) {
		this.telefoneConjugue = telefoneConjugue;
	}
	
	
	
}

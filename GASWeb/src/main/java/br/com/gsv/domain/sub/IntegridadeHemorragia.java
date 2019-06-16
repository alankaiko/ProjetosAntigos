package br.com.gsv.domain.sub;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class IntegridadeHemorragia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="integ_id")
	private Long id;
	

	private String checkHemorragia;
	private String checkDispneia;
	private String checkEdema;
	private String checkDescamacao;
	private String checkHematoma;
	private String checkCicatriz;
	private String checkOutroInt;
	

	public IntegridadeHemorragia() {
		this.checkHemorragia = new String();
		this.checkDispneia = new String();
		this.checkEdema = new String();
		this.checkDescamacao = new String();
		this.checkHematoma = new String();
		this.checkCicatriz = new String();
		this.checkOutroInt = new String();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCheckHemorragia() {
		return checkHemorragia;
	}

	public void setCheckHemorragia(String checkHemorragia) {
		this.checkHemorragia = checkHemorragia;
	}

	public String getCheckDispneia() {
		return checkDispneia;
	}

	public void setCheckDispneia(String checkDispneia) {
		this.checkDispneia = checkDispneia;
	}

	public String getCheckEdema() {
		return checkEdema;
	}

	public void setCheckEdema(String checkEdema) {
		this.checkEdema = checkEdema;
	}

	public String getCheckDescamacao() {
		return checkDescamacao;
	}

	public void setCheckDescamacao(String checkDescamacao) {
		this.checkDescamacao = checkDescamacao;
	}

	public String getCheckHematoma() {
		return checkHematoma;
	}

	public void setCheckHematoma(String checkHematoma) {
		this.checkHematoma = checkHematoma;
	}

	public String getCheckCicatriz() {
		return checkCicatriz;
	}

	public void setCheckCicatriz(String checkCicatriz) {
		this.checkCicatriz = checkCicatriz;
	}

	public String getCheckOutroInt() {
		return checkOutroInt;
	}

	public void setCheckOutroInt(String checkOutroInt) {
		this.checkOutroInt = checkOutroInt;
	}

}

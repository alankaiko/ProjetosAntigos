package br.com.gsv.domain.sub;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table
@Entity
public class DiagnosticoBaseCheckbox {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="diag_id")
	private Long id;

	private String sepseCheckbox;
	private String pulmonarCheckbox;
	private String distensaoCheckbox;
	private String coliteCheckbox;
	private String outrosCheckbox;

	public DiagnosticoBaseCheckbox() {
		sepseCheckbox = new String();
		pulmonarCheckbox = new String();
		distensaoCheckbox = new String();
		coliteCheckbox = new String();
		outrosCheckbox = new String();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSepseCheckbox() {
		return sepseCheckbox;
	}

	public void setSepseCheckbox(String sepseCheckbox) {
		this.sepseCheckbox = sepseCheckbox;
	}

	public String getPulmonarCheckbox() {
		return pulmonarCheckbox;
	}

	public void setPulmonarCheckbox(String pulmonarCheckbox) {
		this.pulmonarCheckbox = pulmonarCheckbox;
	}

	public String getDistensaoCheckbox() {
		return distensaoCheckbox;
	}

	public void setDistensaoCheckbox(String distensaoCheckbox) {
		this.distensaoCheckbox = distensaoCheckbox;
	}

	public String getColiteCheckbox() {
		return coliteCheckbox;
	}

	public void setColiteCheckbox(String coliteCheckbox) {
		this.coliteCheckbox = coliteCheckbox;
	}

	public String getOutrosCheckbox() {
		return outrosCheckbox;
	}

	public void setOutrosCheckbox(String outrosCheckbox) {
		this.outrosCheckbox = outrosCheckbox;
	}

}

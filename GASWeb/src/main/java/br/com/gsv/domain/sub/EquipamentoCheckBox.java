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
public class EquipamentoCheckBox implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="equip_id")
	private Long id;

	private String checkCateter;
	private String checkSonda;
	private String checkUripen;
	private String checkDreno;
	private String checkCurativos;
	private String checkVenoclise;
	private String checkOutros;

	public EquipamentoCheckBox() {
		this.checkCateter = new String();
		this.checkSonda = new String();
		this.checkUripen = new String();
		this.checkDreno = new String();
		this.checkCurativos = new String();
		this.checkVenoclise = new String();
		this.checkOutros = new String();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCheckCateter() {
		return checkCateter;
	}

	public void setCheckCateter(String checkCateter) {
		this.checkCateter = checkCateter;
	}

	public String getCheckSonda() {
		return checkSonda;
	}

	public void setCheckSonda(String checkSonda) {
		this.checkSonda = checkSonda;
	}

	public String getCheckUripen() {
		return checkUripen;
	}

	public void setCheckUripen(String checkUripen) {
		this.checkUripen = checkUripen;
	}

	public String getCheckDreno() {
		return checkDreno;
	}

	public void setCheckDreno(String checkDreno) {
		this.checkDreno = checkDreno;
	}

	public String getCheckCurativos() {
		return checkCurativos;
	}

	public void setCheckCurativos(String checkCurativos) {
		this.checkCurativos = checkCurativos;
	}

	public String getCheckVenoclise() {
		return checkVenoclise;
	}

	public void setCheckVenoclise(String checkVenoclise) {
		this.checkVenoclise = checkVenoclise;
	}

	public String getCheckOutros() {
		return checkOutros;
	}

	public void setCheckOutros(String checkOutros) {
		this.checkOutros = checkOutros;
	}	

}

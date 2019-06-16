package br.com.salao.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Reserva.listar", query="SELECT reserva FROM Reserva reserva"),
	@NamedQuery(name="Reserva.buscarPorId", query="SELECT reserva FROM Reserva reserva WHERE reserva.id= :id"),
	@NamedQuery(name = "Reserva.buscarPorData", query = "SELECT reserva.horaInicial FROM Reserva reserva WHERE reserva.data = :data")
})
public class Reserva {
	private long id;
	private Salao salao;
	private Date data;
	private String horaInicial;
	private String horaFinal;
	private Apartamento apartamento;
	
	public Reserva() {
		this.apartamento = new Apartamento();
		this.salao = new Salao();
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name = "tbl_salao_id", referencedColumnName = "id")
	public Salao getSalao() {
		return salao;
	}

	public void setSalao(Salao salao) {
		this.salao = salao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "tbl_apartamento_id", referencedColumnName = "id")
	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Reserva other = (Reserva) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}

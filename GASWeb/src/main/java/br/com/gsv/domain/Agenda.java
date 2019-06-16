package br.com.gsv.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import br.com.gsv.domain.sub.EnumStatusAgendamento;
import br.com.gsv.domain.sub.EnumTipoAgendamento;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Agenda.listarHorarios", query = "SELECT agenda.horaDesejada FROM Agenda agenda order by data"),
	@NamedQuery(name = "Agenda.buscarPorData", query = "SELECT agenda.horaDesejada FROM Agenda agenda WHERE agenda.data = :data"),
	@NamedQuery(name = "Agenda.listaAgenda", query = "SELECT agenda FROM Agenda agenda WHERE agenda.data = :data"),
	@NamedQuery(name = "Agenda.buscarPorId", query = "SELECT agenda FROM Agenda agenda WHERE agenda.id = :id"),
	@NamedQuery(name = "Agenda.listaTotal", query = "SELECT agenda FROM Agenda agenda"),
	@NamedQuery(name = "Agenda.buscarPorPaciente", query = "SELECT agenda FROM Agenda agenda WHERE agenda.paciente.nome LIKE :nome order by data")
})
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "conv_id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private EnumStatusAgendamento statusAgendamento;

	@Enumerated(EnumType.STRING)
	private EnumTipoAgendamento tipoAgendamento;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String horaDesejada;
	
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "tbl_paciente_id", referencedColumnName = "id")
	private Paciente paciente;

	private String indicacao;
	private String observacao;

	public Agenda() {
		data = new Date();
		horaDesejada = new String();
		paciente = new Paciente();
		observacao = new String();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public EnumTipoAgendamento getTipoAgendamento() {
		return tipoAgendamento;
	}

	public void setTipoAgendamento(EnumTipoAgendamento tipoAgendamento) {
		this.tipoAgendamento = tipoAgendamento;
	}

	public String getHoraDesejada() {
		return horaDesejada;
	}

	public void setHoraDesejada(String horaDesejada) {
		this.horaDesejada = horaDesejada;
	}
	
	public EnumStatusAgendamento getStatusAgendamento() {
		return statusAgendamento;
	}
	
	public void setStatusAgendamento(EnumStatusAgendamento statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public String getIndicacao() {
		return indicacao;
	}
	
	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
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
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

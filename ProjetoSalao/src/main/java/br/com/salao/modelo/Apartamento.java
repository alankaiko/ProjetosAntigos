package br.com.salao.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
@NamedQueries({
	@NamedQuery(name="Apartamento.listar", query="SELECT apartamento FROM Apartamento apartamento"),
	@NamedQuery(name="Apartamento.buscarPorId", query="SELECT apartamento FROM Apartamento apartamento WHERE apartamento.id= :id")
})
public class Apartamento {
	private Long id;
	private String numeroApartamento;
	private String numeroAndar;
	private Cliente cliente;
	
	public Apartamento() {
		cliente = new Cliente();
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}
	
	public String getNumeroAndar() {
		return numeroAndar;
	}
	
	public void setNumeroAndar(String numeroAndar) {
		this.numeroAndar = numeroAndar;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tbl_cliente_id", referencedColumnName = "id")
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

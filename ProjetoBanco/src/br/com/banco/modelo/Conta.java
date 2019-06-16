package br.com.banco.modelo;

import java.util.ArrayList;
import java.util.Date;

import br.com.banco.util.UtilData;

public class Conta extends EntidadeBanco{
	private int numero;
	
	private String titular;
	private Date dataAbertura;
	private double saldo;
	private ArrayList movimento;	
	private Long identificador;
	
	public Conta() {
		this.dataAbertura = UtilData.data();
		this.movimento = new ArrayList();
	}
	
	public Conta(String titular, int numero){
		this();
		this.titular = titular;
		this.numero = numero;
		this.saldo = 0.0;
	}

	@Override
	public Long getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public ArrayList getMovimento() {
		return movimento;
	}
	
	public void setMovimento(ArrayList movimento) {
		this.movimento = movimento;
	}
}

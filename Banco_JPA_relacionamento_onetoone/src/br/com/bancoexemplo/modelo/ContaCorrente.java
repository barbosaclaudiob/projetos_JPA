package br.com.bancoexemplo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ContaCorrente extends BaseEntity {

	@Column(nullable=false, unique=true)
	private Integer numero;
	
	@Column(nullable=false, precision=10, scale=10)
	private Double saldo;
	
	@OneToOne
	private Pessoa titular;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Pessoa getTitular() {
		return titular;
	}

	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}	
}

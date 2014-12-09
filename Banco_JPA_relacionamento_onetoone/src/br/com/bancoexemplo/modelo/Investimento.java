package br.com.bancoexemplo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Investimento extends BaseEntity {

	@Column(length=200, nullable=false)
	private String descricao;
	
	@Column(precision=10, scale=10, nullable=false)
	private Double valor;
	
	@Column(precision=10, scale=10, nullable=false)
	private Double rendimentoMensal;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(Double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}	
}

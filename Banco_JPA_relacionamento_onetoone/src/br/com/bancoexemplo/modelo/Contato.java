package br.com.bancoexemplo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Contato extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private TipoContato tipo;
	@Column(nullable=false)
	private String valor;
	private String descricao;
	
	public Contato() {}
	
	public Contato(TipoContato tipo, String valor, String descricao) {
		super();
		this.tipo = tipo;
		this.valor = valor;
		this.descricao = descricao;
	}

	public TipoContato getTipo() {
		return tipo;
	}
	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}

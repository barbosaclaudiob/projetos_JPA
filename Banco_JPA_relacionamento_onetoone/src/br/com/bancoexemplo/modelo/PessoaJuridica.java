package br.com.bancoexemplo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("pj")
public class PessoaJuridica extends Pessoa {
	
	@Column(nullable=true, unique=true)
	private String cnpj;
	private String razaoSocial;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
}

package br.com.bancoexemplo.modelo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("pf")
public class PessoaFisica extends Pessoa {

	@Column(name="cpfpessoa", length=15, nullable=true, unique=true)
	private String cpf;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="estado", column=@Column(name="ec_estado")),
		@AttributeOverride(name="cidade", column=@Column(name="ec_cidade")),
		@AttributeOverride(name="logradouro", column=@Column(name="ec_logradouro"))
		})
	private Endereco enderecoComercial;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}

	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}	
	
}

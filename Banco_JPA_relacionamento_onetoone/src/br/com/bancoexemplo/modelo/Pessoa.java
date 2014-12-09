package br.com.bancoexemplo.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="tipo_pessoa")
public abstract class Pessoa extends BaseEntity {

	@Column(name="nome_pessoa", length=100, nullable=false)
	private String nome;
		
	@Embedded
	private Endereco endereco;
	
	@OneToMany
	@JoinColumn(name="pessoa_id")
	private List<Contato> contatos;
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public Endereco getEndereco() {
		if (this.endereco == null) {
			this.endereco = new Endereco();
		}
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Contato> getContato() {
		if (this.contatos == null) {
			this.contatos = new ArrayList<Contato>();
		}
		return contatos;
	}
	public void setContato(List<Contato> contato) {
		this.contatos = contato;
	}	
	
}

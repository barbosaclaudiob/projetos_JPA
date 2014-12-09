package br.com.bancoexemplo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.bancoexemplo.modelo.Contato;
import br.com.bancoexemplo.modelo.Pessoa;
import br.com.bancoexemplo.modelo.TipoContato;
import br.com.bancoexemplo.modelo.UF;
import br.com.bancoexemplo.util.UtilEntityManager;

public class PessoaService extends GenericService<Pessoa> {

	public PessoaService() {
		super(Pessoa.class);
	}

	//metodo que sobrescreve metodo inserir para salvar os contatos antes de inserir pessoa
	@Override
	public Pessoa inserir(Pessoa p){
		UtilEntityManager.begin();
		
		if (p.getContato() != null) {
			
			for (Contato c  : p.getContato()) {
				UtilEntityManager.getEM().persist(c);
			}
			
		}	
		
		return super.inserir(p);
	}
	
	public List<Pessoa> buscarPor(UF uf){
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ");
		jpql.append(Pessoa.class.getSimpleName());
		jpql.append(" p WHERE p.endereco.estado = :uf");
		
		TypedQuery<Pessoa> qry = UtilEntityManager.getEM().createQuery(jpql.toString(), Pessoa.class);
		
		qry.setParameter("uf", uf);
		
		return qry.getResultList();
	}
	
	
	//?
	public List<Contato> listContatoPorEstado(UF uf){
		List<Contato> list = new ArrayList<Contato>();
		List<Pessoa> pessoas = buscarPor(uf);
		
		for (Pessoa p : pessoas) {
			list.addAll(p.getContato());
		}
		
		return list;
	}
	
	//buscar pessoas pelo DDD do telefone de contato
	public List<Pessoa> listPessoaPorDDD(String ddd){
		String jpql = "SELECT p FROM Pessoa p ";
		jpql += " INNER JOIN p.contatos c";
		jpql += " WHERE c.tipo = :pTipo";
		jpql += " AND c.valor LIKE :pValor";
		
		TypedQuery<Pessoa> query = UtilEntityManager.getEM().createQuery(jpql, Pessoa.class);
		
		query.setParameter("pTipo", TipoContato.TELEFONE);
		query.setParameter("pValor", ddd + "%");
		
		return query.getResultList();
	}
	
}

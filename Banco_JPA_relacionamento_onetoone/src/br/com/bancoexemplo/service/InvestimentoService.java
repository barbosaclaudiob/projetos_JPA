package br.com.bancoexemplo.service;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.bancoexemplo.modelo.Investimento;
import br.com.bancoexemplo.util.UtilEntityManager;

public class InvestimentoService extends GenericService<Investimento> {

	public InvestimentoService() {
		super(Investimento.class);
	}
	
	public List<Investimento> buscarPor(String descricao){
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT i FROM investimento i");
		jpql.append(" WHERE i.descricao LIKE :descricao");
		
		TypedQuery<Investimento> query = UtilEntityManager.getEM().createQuery(jpql.toString(), Investimento.class);
		query.setParameter("descricao", "%" + descricao + "%");
		
		return query.getResultList();
	}
}

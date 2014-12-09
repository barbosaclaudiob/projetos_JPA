package br.com.bancoexemplo.service;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.bancoexemplo.modelo.ContaCorrente;
import br.com.bancoexemplo.util.UtilEntityManager;

public class ContaCorrenteService extends GenericService<ContaCorrente> {

	public ContaCorrenteService() {
		super(ContaCorrente.class);
	}
	
	public List<ContaCorrente> buscarPor(String nomeTitular){
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ");
		jpql.append(ContaCorrente.class.getSimpleName());
		jpql.append(" cc WHERE cc.titular.nome LIKE :pNome");
		
		TypedQuery<ContaCorrente> qry = UtilEntityManager.getEM().createQuery(jpql.toString(), ContaCorrente.class);
		
		qry.setParameter("pNome", nomeTitular+"%");
		
		return qry.getResultList();
	}

}

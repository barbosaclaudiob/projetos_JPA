package br.com.bancoexemplo.service;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.bancoexemplo.modelo.BaseEntity;
import br.com.bancoexemplo.util.UtilEntityManager;

public class GenericService<T extends BaseEntity> {

	private Class<T> clazz;

	public GenericService(Class<T> clazz) {
		
		this.clazz = clazz;		
	}
	
	public T inserir(T c){
		UtilEntityManager.begin();
		UtilEntityManager.getEM().persist(c);
		UtilEntityManager.commit();
		return c;
	}
	
	public void excluir(T c){
		UtilEntityManager.begin();
		UtilEntityManager.getEM().remove(c);
		UtilEntityManager.commit();
	}
	
	public List<T> buscarTodos(){
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c FROM ");
		jpql.append(clazz.getSimpleName());
		jpql.append(" c");
		
		TypedQuery<T> query = UtilEntityManager.getEM().createQuery(jpql.toString(), clazz);
		
		return query.getResultList();
	}
	
	public T buscarPor(Long Id){
		UtilEntityManager.begin();
		return UtilEntityManager.getEM().find(clazz, Id);
	}
}

package br.com.bancoexemplo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UtilEntityManager {

	private static EntityManagerFactory emf;
	private static EntityManager em = null;
	static{
		emf = Persistence.createEntityManagerFactory("h2");
	}
	
	public static EntityManager getEM(){
		if (em == null) {
			em = emf.createEntityManager();
		}//fim de if
		
		return em;
	}//fim de getEM
	
	public static void begin(){
		
		if (!getEM().getTransaction().isActive()) {
			getEM().getTransaction().begin();
		}
		
	}//fim de begin
	
	public static void commit(){
		getEM().getTransaction().commit();
	}//fim de commit
	
	public static void close(){
		emf.close();
	}//fim de commit
}//fim de EntityManagerUtil

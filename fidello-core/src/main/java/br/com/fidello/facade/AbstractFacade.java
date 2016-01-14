package br.com.fidello.facade;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.fidello.qualifier.EntityManagerBancoXQualifier;

public class AbstractFacade implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject @EntityManagerBancoXQualifier
	private EntityManager em;

	public Session getSession() {
		return (Session) em.getDelegate();
	}

	public void beginTransaction() {
//		em = emf.createEntityManager();

		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
	}
	
	public void closeTransaction() {
		if (em != null) {
		    em.close();
		}
		em.close();
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void rollback() {
		em.getTransaction().rollback();	
	}

	public void flush() {
		em.flush();
	}
	
	public void joinTransaction() {
//		em = emf.createEntityManager();
		em.joinTransaction();
	}

//	public void commitAndCloseTransaction() {
//		commit();
//		closeTransaction();
//	}
	
}
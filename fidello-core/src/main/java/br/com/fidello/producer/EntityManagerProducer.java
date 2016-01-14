package br.com.fidello.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import br.com.fidello.qualifier.EntityManagerBancoXQualifier;

@RequestScoped
public class EntityManagerProducer {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FidelloPU");
	
	//Era para fazer com o @PersistenceContext(unitName = "FidelloPU") Mas ele não instanciou
   //@PersistenceContext(unitName = "FidelloPU2")
	private EntityManager entityManager;

	public EntityManagerProducer() {
	}

	@Produces
	@RequestScoped
	@EntityManagerBancoXQualifier
	public EntityManager createEntityManager() {
		if(entityManager == null)
			entityManager = emf.createEntityManager();
		
		return entityManager;
	}

	public void dispose(
			@Disposes @EntityManagerBancoXQualifier EntityManager entityManager) {
		System.out.println("EntityManager fechado");
		entityManager.close();
	}
}

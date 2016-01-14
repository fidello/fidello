package br.com.fidello.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import br.com.fidello.qualifier.EntityManagerBancoXQualifier;

abstract class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = 1L;

//	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FidelloPU2");
	
	@Inject @EntityManagerBancoXQualifier
	private EntityManager em;

	private Class<T> entityClass;
	
	protected Session getSession() {
		return (Session) em.getDelegate();
	}

	protected void beginTransaction() {
	//	em = emf.createEntityManager();

		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
	}
	
	protected void closeTransaction() {
		if (em != null) {
		    em.close();
		}
		em.close();
	}

	protected void commit() {
		em.getTransaction().commit();
	}

	protected void rollback() {
		em.getTransaction().rollback();
	}

	protected void flush() {
		em.flush();
	}
	
	protected void joinTransaction() {
//		em = emf.createEntityManager();
		em.joinTransaction();
	}

	protected GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected void save(T entity) {
		em.persist(entity);
	}

	protected void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = em.getReference(classe, id);
		 
        em.remove(entityToBeRemoved);
	}

	protected T update(T entity) {
		return em.merge(entity);
	}

	protected T find(int entityID) {
		return em.find(entityClass, entityID);
	}

	protected T findReferenceOnly(int entityID) {
		return em.getReference(entityClass, entityID);
	}

	// Using the unchecked because JPA does not have a
	// em.getCriteriaBuilder().createQuery()<T> method
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	// Using the unchecked because JPA does not have a
	// query.getSingleResult()<T> method
	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;

		try {
			Query query = em.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (T) query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	protected void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

//	public void commitAndCloseTransaction() {
//		commit();
//		closeTransaction();
//	}
	
}

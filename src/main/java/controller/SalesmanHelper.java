package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Salesman;

/**
 * Servlet implementation class SalsemanHelper
 */

public class SalesmanHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Module3Car");

	public void insertSalesman(Salesman s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Salesman> showAllSalesmen(){
		EntityManager em = emfactory.createEntityManager();
		List<Salesman> allSalesmen = em.createQuery("SELECT s from Salesman s").getResultList();
		return allSalesmen;
	}
	
	public Salesman findSalesman(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Salesman> typedQuery = em.createQuery("select sh from Salesman sh where sh.salesmanName = :selectedName",Salesman.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Salesman foundSalesman;
		try {
			foundSalesman = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundSalesman = new Salesman(nameToLookUp);
		}
		em.close();

		return foundSalesman;
	}
}

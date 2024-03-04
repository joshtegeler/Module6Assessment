package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.InventoryDetails;
/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Feb 26, 2024
 */

public class InventoryDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Module3Car");

	public void insertNewInventoryDetails(InventoryDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<InventoryDetails> getInventories(){
		EntityManager em = emfactory.createEntityManager();
		List<InventoryDetails> allDetails = em.createQuery("SELECT d FROM InventoryDetails d").getResultList();
		return allDetails;
	}

	public InventoryDetails searchForInventoryDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		InventoryDetails found = em.find(InventoryDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteInventory(InventoryDetails listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<InventoryDetails> typedQuery = em.createQuery("SELECT detail from InventoryDetails detail where detail.id= :selectedId", InventoryDetails.class);
		typedQuery.setParameter("selectedId", listToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		InventoryDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateInventory(InventoryDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}

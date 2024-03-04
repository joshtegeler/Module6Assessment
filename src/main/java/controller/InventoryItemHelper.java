package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.InventoryItem;
/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Feb 24, 2024
 */



public class InventoryItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Module3Car");
	
	public void insertCar(InventoryItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<InventoryItem> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<InventoryItem> allItems = em.createQuery("SELECT c from Car c").getResultList();
		return allItems;
		
	}

	public void deleteCar(InventoryItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<InventoryItem> typedQuery = em.createQuery("select li from Car li where li.make = :selectedMake and li.model = :selectedModel and li.year = :selectedYear and li.horsepower = :li.horsepower", InventoryItem.class);
		
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		
		typedQuery.setMaxResults(1);
		
		InventoryItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public InventoryItem searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		InventoryItem found = em.find(InventoryItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(InventoryItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<InventoryItem> searchForCarByMake(String make) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<InventoryItem> typedQuery = em.createQuery("select li from InventoryItem li where li.store = :selectedStore", InventoryItem.class);
		
		typedQuery.setParameter("selectedMake", make);
		
		List<InventoryItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	// Item = car
	// store = make
	
	public List<InventoryItem> searchForCarByModel(String model) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<InventoryItem> typedQuery = em.createQuery("select li from InventoryItem li where li.item = :selectedItem", InventoryItem.class);
		
		typedQuery.setParameter("selectedCar", model);
		
		List<InventoryItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
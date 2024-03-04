package controller;

/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Jan 30, 2024
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;


public class CarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Module3Car");
	
	public void insertCar(Car li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Car> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<Car> allItems = em.createQuery("SELECT a from Car a").getResultList();
		return allItems;
		
	}

	public void deleteCar(Car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.make = :selectedMake and c.model = :selectedModel", Car.class);
		
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		
		typedQuery.setMaxResults(1);
		
		Car result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Car searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCar(Car toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Car> searchForModelByMake(String carMake) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.make = :selectedMake", Car.class);
		
		typedQuery.setParameter("selectedMake", carMake);
		
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Car> searchForModelByModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select c from Car c where c.model = :selectedModel", Car.class);
		
		typedQuery.setParameter("selectedModel", modelName);
		
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}

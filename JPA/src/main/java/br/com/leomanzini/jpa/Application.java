package br.com.leomanzini.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.leomanzini.jpa.dto.States;
import br.com.leomanzini.jpa.dto.Students;

public class Application {

	public static void main(String[] args) {
		
		// Starts a entity with the persistence-unity configurations
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("leomanzini-jpa-tests");
		EntityManager entityManager = entityFactory.createEntityManager();
		
		States state = new States("Rio Grande do Sul");
		Students student = new Students("Renato", 20, state);
		
		// Start a transaction with database (To insert the new data, we need to start the transaction)
		entityManager.getTransaction().begin();
		
		// Add the objects to the database
		entityManager.persist(state);
		entityManager.persist(student);
		
		// Make a commit to the changes
		entityManager.getTransaction().commit();
		
		// Close the open entities
		entityFactory.close();
		entityManager.close();
	}
}

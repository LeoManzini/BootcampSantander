package br.com.leomanzini.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.leomanzini.jpa.dto.States;
import br.com.leomanzini.jpa.dto.Students;

public class ApplicationHibernate {

	public static void main(String[] args) {
		
		// Starts a entity with the persistence-unity configurations
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("leomanzini-hibernate");
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
		
		// Looking for a specific class and ID, like a SELECT with where at the first id
		States findState = entityManager.find(States.class, 1);
		Students findStudent = entityManager.find(Students.class, 1);
		
		// Works because we already are inside of a transaction
		System.out.println("State found: " + findState);
		System.out.println("Student found: " + findStudent);
		
		// Each time that we alter something at the database, we have to start a new transaction
		entityManager.getTransaction().begin();
		
		// Modify the objects
		findStudent.setName("Luis Renato Manzini");
		findStudent.setAge(45);
		
		// Commit the modifications at database
		entityManager.getTransaction().commit();
		
		// Close the open entities
		entityFactory.close();
		entityManager.close();
	}
}

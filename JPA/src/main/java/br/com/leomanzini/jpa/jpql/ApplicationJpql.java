package br.com.leomanzini.jpa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.leomanzini.jpa.dto.Students;

public class ApplicationJpql {

	public static void main(String[] args) {

		// Starts a entity with the persistence-unity configurations
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("leomanzini-hibernate");
		EntityManager entityManager = entityFactory.createEntityManager();

		// Name used at the next consults
		String name = "Giovanna";
		
		// Open a database connection
		entityManager.getTransaction().begin();
		
		// Find a specific student at database, but if we want to find more than one, it's impossible just with jpa and hibernate
		Students findStudent = entityManager.find(Students.class, 1);
		
		System.out.println(findStudent);
		
		// Creating a SQL query native, returns just one line too
		String sql = "SELECT * FROM Students WHERE name = :name ";
		Students sqlStudent = (Students) entityManager.createNativeQuery(sql, Students.class).setParameter("name", name).getSingleResult();
		
		// Returns a list as query result
		String sqlList = "SELECT * FROM Students";
		@SuppressWarnings("unchecked")
		List<Students> studentsSqlList = entityManager.createNativeQuery(sqlList, Students.class).getResultList();
		
		System.out.println("One line query return: " + sqlStudent);
		studentsSqlList.stream().forEach(Student -> System.out.println("Sql list consult: " + Student));
		
		// JPQL consult
		// Jpql needs to use a alias for the table, because doesn't accept *
		String jpql = "SELECT a FROM Students a WHERE a.name = :name";
		Students jpqlStudent = entityManager.createQuery(jpql, Students.class).setParameter("name", name).getSingleResult();
		
		String jpqlList = "SELECT a FROM Students a";
		List<Students> studentsJpqlList = entityManager.createQuery(jpqlList, Students.class).getResultList();
		
		System.out.println("One line query return: " + jpqlStudent);
		studentsJpqlList.stream().forEach(Student -> System.out.println("Sql list consult: " + Student));
	}
}

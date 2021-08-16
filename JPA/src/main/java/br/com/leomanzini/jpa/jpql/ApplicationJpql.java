package br.com.leomanzini.jpa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.leomanzini.jpa.dto.States;
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
		studentsJpqlList.stream().forEach(Student -> System.out.println("Jpql list consult: " + Student));
		
		// One another advantage, if we want to do the example bellow with just SQL we need to make joins and a lot of stuf
		// but with JPQL we just need to use the classes and objects, no matter how de database are, just the objects structures and mapping
		jpqlList = "SELECT a FROM Atudents WHERE a.state.name = :stateName";
		List<Students> jpqlConditionList = entityManager.createQuery(jpqlList, Students.class).setParameter("stateName", "Sao Paulo").getResultList();	
		jpqlConditionList.stream().forEach(Student -> System.out.println("Conditional JPQL list consult: " + Student));
		
		jpqlConditionList.clear();
		
		// You can use an object to looking for too, like this:
		jpqlList = "SELECT a FROM Atudents WHERE a.state = :state";
		// EntityManager will find with a SELECT the state with primary key being 1 and use it at the outside query
		jpqlConditionList = entityManager.createQuery(jpqlList, Students.class).setParameter("state", entityManager.find(States.class, 1)).getResultList();
		
		// JPA Criteria API
		// Returning just one result
		// CriteriaQuery<Students> criteria = entityManager.getCriteriaBuilder().createQuery(Students.class);
		// Root<Students> rootStudent = criteria.from(Students.class);
		// CriteriaBuilder.In<String> inClause = entityManager.getCriteriaBuilder().in(rootStudent.get(Students_.name)); // Students_ is the JPA metamodel
		// inClause.value(name);
		// criteria.select(rootStudent).where(inClause);
		// Students criteriaApiStudent = entityManager.createQuery(criteria).getSingleResult();
		// System.out.println("Student using criteria: " + criteriaApiStudent);
		
		// Returning a Criteria API list
		CriteriaQuery<Students> criteriaList = entityManager.getCriteriaBuilder().createQuery(Students.class);
		Root<Students> rootListStudents = criteriaList.from(Students.class);
		List<Students> studentsCriteriaList = entityManager.createQuery(criteriaList).getResultList();
		
		studentsCriteriaList.stream().forEach(Student -> System.out.println("JPA Criteria API list consult: " + Student));
	}
}

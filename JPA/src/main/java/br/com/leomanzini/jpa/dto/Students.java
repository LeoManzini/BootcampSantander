package br.com.leomanzini.jpa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Students {
	
	@Id
	@Column(name= "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "student_name")
	private String name;
	
	@Column(name= "student_age")
	private int age;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name= "student_state")
	private States state;
	
	public Students() {
	}

	public Students(String name, int age, States state) {
		this.name = name;
		this.age = age;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int number) {
		this.id = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public States getStates() {
		return state;
	}

	public void setStates(States state) {
		this.state = state;
	}
}

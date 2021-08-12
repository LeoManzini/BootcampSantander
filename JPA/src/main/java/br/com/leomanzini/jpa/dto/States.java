package br.com.leomanzini.jpa.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class States {
	
	@Id
	@Column(name= "state_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "state_name")
	private String name;
	
	@OneToMany(mappedBy = "student_state", 
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	private List<Students> students = new ArrayList<>();

	public States() {
	}

	public States(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(Students student) {
		this.students.add(student);
	}
}

package br.com.leomanzini.jdbc.dto;

public class StudentsDto {
	
	private int id;
	private String name;
	private String email;
	private boolean active;
	private String creationDate;
	
	public StudentsDto() {
	}

	public StudentsDto(int id, String name, String email, boolean active, String creationDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.active = active;
		this.creationDate = creationDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "AlunoDto [number=" + id + ", name=" + name + ", email=" + email + ", active=" + active
				+ ", creationDate=" + creationDate + "]";
	}
}

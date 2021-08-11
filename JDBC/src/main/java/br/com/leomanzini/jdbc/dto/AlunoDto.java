package br.com.leomanzini.jdbc.dto;

public class AlunoDto {
	
	private int number;
	private String name;
	private String email;
	private boolean active;
	private String creationDate;
	
	public AlunoDto() {
	}

	public AlunoDto(int number, String name, String email, boolean active, String creationDate) {
		this.number = number;
		this.name = name;
		this.email = email;
		this.active = active;
		this.creationDate = creationDate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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
}
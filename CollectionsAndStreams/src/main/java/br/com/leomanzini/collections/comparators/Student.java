package br.com.leomanzini.collections.comparators;

// Comparable allow us to compare our classes and objects
public class Student implements Comparable<Student> {
	
	private final String name;
	private final Integer age;
	
	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", age: " + age;
	}
	
	/* Returns 0, objects are equal
	 * Returns > 0, actual object is higher than
	 * Returns < 0, actual object is lower than
	 */
	@Override
	public int compareTo(Student o) {
		return this.getAge() - o.getAge();
	}
}

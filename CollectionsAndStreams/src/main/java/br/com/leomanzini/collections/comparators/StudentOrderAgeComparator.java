package br.com.leomanzini.collections.comparators;

import java.util.Comparator;

public class StudentOrderAgeComparator implements Comparator<Student> {
	
	/* Compare with two arguments comparing one with other
	 * with which rule the developer wants to, 
	 * receive class as parameter
	 */
	@Override
	public int compare(Student o1, Student o2) {
		return o2.getAge() - o1.getAge();
	}
}

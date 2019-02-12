package edu.neumont.csc150.neudata;

public class Student extends Person {
	private double gpa;

	public Student() {
		super();
	}
	
	public Student(String ssn, String fn, String ln, double gpa) {
		super(ssn, fn, ln);
		this.setGpa(gpa);
	}
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return super.toString() + " GPA: " + this.getGpa();
	}

	public int compareTo(Student o) {
		return Double.compare(this.getGpa(), o.getGpa());
	}


}

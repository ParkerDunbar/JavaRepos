package edu.neumont.csc150.neudata;

public class Instructor extends Person {
	private int officeNumber;
	
	public Instructor() {
		super();
	}
	
	public Instructor(String ssn, String fn, String ln, int on) {
		super(ssn, fn, ln);
		this.setOfficeNumber(on);
	}
	

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Office Number: " + this.getOfficeNumber();
	}
	
	
	public int compareTo(Instructor o) {
		return Integer.compare(this.getOfficeNumber(), o.getOfficeNumber());
	}
}

package edu.neumont.csc150.simplefile;

import java.io.Serializable;

public class Person implements Serializable {
	private String firstName;
	
	private String lastName;
	
	private long ssn;
	
	public Person() {}
	
	public Person(String fn, String ln, long ssn) {
		this.setFirstName(fn);
		this.setLastName(ln);
		this.setSsn(ssn);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Person)) {
			return false;
		}
		Person other = (Person)obj;
		return this.getSsn() == other.getSsn();
	}
	
	public String toString() {
		return String.valueOf(ssn) + " " + this.getFirstName() + " " + this.getLastName();
	}
}






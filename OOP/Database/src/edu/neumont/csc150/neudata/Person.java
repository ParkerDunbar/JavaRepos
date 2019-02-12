package edu.neumont.csc150.neudata;

public class Person implements Comparable<Person>{
	private String ssn;
	private String firstName;
	private String lastName;
	
	Person() {
		
	}
	
	Person(String ssn, String firstName, String lastName) {
		this.setSsn(ssn);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		if(ssn == null) {
			throw new IllegalArgumentException("ssn cannot be null");
		}
		this.ssn = ssn;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(firstName == null) {
			throw new IllegalArgumentException("firstName cannot be null");
		}
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if(lastName == null) {
			throw new IllegalArgumentException("lastName cannot be null");
		}
		this.lastName = lastName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			throw new IllegalArgumentException("obj has to be an instance of Person");
		}
		Person other = (Person)obj;
		return this.getSsn().equals(other.getSsn());
	}
	
	@Override
	public String toString() {
		return "SSN: " + this.getSsn() + " First Name: " + this.getFirstName() + " Last Name: " + this.getLastName();
	}
	
	@Override
	public int compareTo(Person o) {
		return this.getSsn().compareTo(o.getSsn());
	}
	
}

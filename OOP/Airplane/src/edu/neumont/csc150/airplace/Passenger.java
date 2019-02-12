package edu.neumont.csc150.airplace;
/**
 * A class to represent a single passenger
 * @author Parker Dunbar
 *
 */
public class Passenger {
	private String name;
	
	/**
	 * Build an instance of passenger with no name
	 */
	public Passenger() {
	}
	/**
	 * Build an instance of passenger with the provider name
	 * @param name the name to give the new passenger
	 */
	public Passenger(String name) {
		this.setName(name);
	}

	/**
	 * Get the passengers name
	 * @return the passengers name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the passengers name
	 * @param name the new name for the passenger (cannot be null)
	 * 
	 */
	public void setName(String name) {
		if(name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		this.name = name;
	}
	
	/**
	 * Compares 2 passengers to see if they are equal
	 * @param obj the other passenger to compare to this one
	 * @return true if they are equal, else false
	 */
	public boolean equals(Object obj) {
		Passenger other = (Passenger)obj;
		return this.getName().equals(other.getName());
	}
}

package edu.neumont.csc150.airplace;

/**
 * Represents a single pilot 
 * @author Parker Dunbar
 *
 */
public class Pilot {
	private String name;
	private Rank rank;
	
	/**
	 * Build a new Pilot object
	 */
	public Pilot() {
	}
	/**
	 * Build a new pilot object
	 * @param name of the pilot (cannot be null)
	 * @param rank of the pilot (cannot be null)
	 */
	public Pilot(String name, Rank rank) {
		this.setName(name);
		this.setRank(rank);
	}
	
	/**
	 * @return the pilot's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name new name for this pilot
	 */
	public void setName(String name) {
		if(name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		this.name = name;
	}
	/**
	 * 
	 * @return the pilot's rank
	 */
	public Rank getRank() {
		return rank;
	}
	/**
	 * Sets this pilot's rank
	 * @param rank the new rank for this pilot
	 */
	public void setRank(Rank rank) {
		if(rank == null) {
			throw new IllegalArgumentException("rank cannot be null");
		}
		this.rank = rank;
	}
	/**
	 * Compares two pilots for equality
	 * @param the other pilot to compare to this one
	 * @return true if equal; else false
	 */
	public boolean equals(Object obj) {
		Pilot other = (Pilot)obj;
		return this.getName().equals(other.getName()) &&
				this.getRank() == other.getRank();
	}
	
}

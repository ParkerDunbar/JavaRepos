package edu.neumont.csc150.d;

import java.util.ArrayList;
/**
 * A class to model a real world Pizza
 * @author Parker Dunbar
 *
 */
public class Pizza {
	private ArrayList<String> toppings;
	private CrustType crust;
	private boolean cooked;
	
	/*public Pizza() {
		
	}*/
	
	public Pizza(boolean c, CrustType ct, ArrayList<String> toppings) {
		this.setCooked(c);
		this.setCrust(ct);
		this.setToppings(toppings);
		
	}
	
	/**
	 * @param obj - the other pizza we are comparing to
	 * @return true if the pizzas are equal; otherwise false
	 */
	public boolean equals(Object obj) {
		Pizza other = (Pizza)obj;
		return (this.isCooked() == other.isCooked() &&
				this.getCrust() == other.getCrust() &&
				this.getToppings().equals(other.getToppings()));
		
		
		/*if(this.isCooked() == other.isCooked() && this.getCrust() == other.getCrust() && this.getToppings().equals(other.getToppings())) {
			return true;
		}
		else {
			return false;
		}*/
		
		
		/*if(this.isCooked() == other.isCooked()) {
			if(this.getCrust() == other.getCrust()) {
				if(this.getToppings().equals(other.getToppings())) {
					return true;
				}
			}
		}*/
	}
	
	/**
	 * @return the list of the toppings that have been placed on this pizza
	 */
	public ArrayList<String> getToppings() {
		return toppings;
	}
	/**
	 * @param the toppings to be put on the pizza
	 */
	public void setToppings(ArrayList<String> toppings) {
		if(toppings == null) {
			throw new IllegalArgumentException("toppings cannot be null");
		}
		this.toppings = toppings;
	}
	/**
	 * @return the crust
	 */
	public CrustType getCrust() {
		return crust;
	}
	/**
	 * @param crust the crust to set
	 */
	public void setCrust(CrustType crust) {
		if(crust == null) {
			throw new IllegalArgumentException("crust cannot be null");
		}
		this.crust = crust;
	}
	/**
	 * @return the cooked
	 */
	public boolean isCooked() {
		return cooked;
	}
	/**
	 * @param cooked the cooked to set
	 */
	public void setCooked(boolean cooked) {
		
		this.cooked = cooked;
	}
}

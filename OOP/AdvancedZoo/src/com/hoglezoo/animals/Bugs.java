package com.hoglezoo.animals;

public class Bugs extends Animal{
	private int numberOfLegs;
	
	public Bugs() {
		super();
	}
	
	public Bugs(String name, String color, int numberOfLegs) {
		super(name, color);
		this.setNumberOfLegs(numberOfLegs);
	}
	
	public int getNumberOfLegs() {
		return numberOfLegs;
	}


	public void setNumberOfLegs(int numberOfLegs) {
		if(numberOfLegs < 0) {
			throw new IllegalArgumentException("numberOfLegs cannot be negative");
		}
		this.numberOfLegs = numberOfLegs;
	}

	public void squish() {
		System.out.println("OUCH!");
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Number of Legs: " + this.getNumberOfLegs();
	}
	
	@Override
	public int compareTo(Animal o) {
		return super.compareTo(o);
	}
	
	@Override
	public void speak() {
		System.out.println("Bzzzzz");
		
	}

}

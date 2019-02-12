package com.hoglezoo.animals;

public class Reptiles extends Animal{
	private int numberOfScales;
	
	public Reptiles() {
		super();
	}
	
	public Reptiles(String name, String color, int numberOfScales) {
		super(name, color);
		this.setNumberOfScales(numberOfScales);
	}
	
	
	public int getNumberOfScales() {
		return numberOfScales;
	}


	public void setNumberOfScales(int numberOfScales) {
		if(numberOfScales < 0) {
			throw new IllegalArgumentException("numberOfScales cannot be negative");
		}
		this.numberOfScales = numberOfScales;
	}

	public void shedSkin() {
		System.out.println("The skin has been shed.");
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Number of Scales: " + this.getNumberOfScales();
	}
	
	@Override
	public int compareTo(Animal o) {
		return super.compareTo(o);
	}
	
	@Override
	public void speak() {
		System.out.println("Croak");
		
	}

}

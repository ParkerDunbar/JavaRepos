package com.hoglezoo.animals;

public class JungleCats extends Animal{
	private double maxSpeed;
	
	public JungleCats() {
		super();
	}
	
	public JungleCats(String name, String color, double maxSpeed) {
		super(name, color);
		this.setMaxSpeed(maxSpeed);
	}
	
	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		if(maxSpeed < 0) {
			throw new IllegalArgumentException("maxSpeed cannot be negative");
		}
		this.maxSpeed = maxSpeed;
	}
	
	public void purr() {
		System.out.println("*Purrs*");
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Max Speed: " + this.getMaxSpeed();
	}
	
	@Override
	public int compareTo(Animal o) {
		return super.compareTo(o);
	}
	
	@Override
	public void speak() {
		System.out.println("ROAR");
		
	}

}

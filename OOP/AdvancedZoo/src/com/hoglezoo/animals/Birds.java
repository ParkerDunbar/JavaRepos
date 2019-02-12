package com.hoglezoo.animals;

public class Birds extends Animal{
	private double wingSpan;
	
	public Birds() {
		super();
	}
	
	public Birds(String name, String color, double wingSpan) {
		super(name, color);
		this.setWingSpan(wingSpan);
	}
	
	public double getWingSpan() {
		return wingSpan;
	}

	public void setWingSpan(double wingSpan) {
		if(wingSpan < 0) {
			throw new IllegalArgumentException("wingSpan cannot be negative");
		}
		this.wingSpan = wingSpan;
	}
	
	public void flap() {
		System.out.println("*Flaps wings*");
	}
	
	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Wing Span: " + this.getWingSpan();
	}
	
	@Override
	public int compareTo(Animal o) {
		return super.compareTo(o);
	}
	
	@Override
	public void speak() {
		System.out.println("Chirp chirp");
		
	}


}

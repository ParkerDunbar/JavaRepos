package com.hoglezoo.animals;

abstract public class Animal implements Comparable<Animal>{
	protected String name;
	protected String color;
	
	public Animal() {	
	}
	
	public Animal(String name, String color) {
		this.setName(name);
		this.setColor(color);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if(name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		this.name = name;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		if(color == null) {
			throw new IllegalArgumentException("color cannot be null");
		}
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			throw new IllegalArgumentException("obj cannot be null");
		}
		if(!(obj instanceof Animal)) {
			throw new IllegalArgumentException("obj has to be an instance of Animal");
		}
		
		Animal other = (Animal)obj;
		
		if(!this.getName().equals(other.getName()) ||
				!this.getColor().equals(other.getColor())) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.getName() + " Color: " + this.getColor();
	}
	
	@Override
	public int compareTo(Animal o) {
		return this.getName().compareTo(o.getName());
	}
	

	
	public Animal fight(Animal other) {
		
		
		return other;
		
	}
	
	abstract public void speak();
}

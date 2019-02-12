package dunbar.parker.objects;

import java.io.Serializable;

import dunbar.parker.persistence.Storable;

public class Animal implements Storable{
	private String name, gender, color, age;
	
	public Animal(){}
	public Animal(String name, String gender, String color, String age){
		this.setName(name);
		this.setGender(gender);
		this.setColor(color);
		this.setAge(age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Animal: " + this.getName() + " " + this.getGender() + " " + this.getColor() + " " + this.getAge();
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Animal)) {
			return false;
		}
		Animal other = (Animal) obj;
		return this.getName().equals(other.getName()) && this.getAge() == (other.getAge());
	}
	public String serialize() {
		return String.format("%255s%255s%255s%3s", this.getName(), this.getGender(), this.getColor(), this.getAge());
	}
	public Object deserialize(String animal) {
		this.setName(animal.substring(0, 255).trim());
		this.setGender(animal.substring(256, 510).trim());
		this.setColor(animal.substring(511, 765).trim());
		this.setAge(animal.substring(766, 768).trim());
		return this;
	}
	public int serializedSize() {
		return this.serialize().length();
	}

}

package dunbar.parker.objects;

import java.io.Serializable;

import dunbar.parker.persistence.Storable;

public class Person implements Storable{
	private String firstName, lastName, email, phone;
	
	public Person(){}
	public Person(String firstName, String lastName, String email, String phone) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhone(phone);
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "Person: " + this.getFirstName() + " " + this.getLastName() + " " + this.getEmail() + " " + this.getPhone();
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return this.getFirstName().equals(other.getFirstName()) && this.getPhone().equals(other.getPhone());
	}
	public String serialize() {
		return String.format("%255s%255s%255s%12s", this.getFirstName(), this.getLastName(), this.getEmail(), this.getPhone());
	}
	public Object deserialize(String person) {
		this.setFirstName(person.substring(0, 255).trim());
		this.setLastName(person.substring(256, 510).trim());
		this.setEmail(person.substring(511, 765).trim());
		this.setPhone(person.substring(766, 777).trim());
		return this;
	}
	public int serializedSize() {
		return this.serialize().length();
	}

}

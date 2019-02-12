package com.neufree.contacts;

import java.io.Serializable;

import edu.neumont.csc180.cox.regexutil.MyRegexUtility;
import edu.neumont.csc180.cox.regexutil.RegexUtility;

public class Contact implements Serializable {
	private String firstName, lastName, primaryEmail, secondEmail, primaryPhone, secondPhone;
	
	RegexUtility r = new MyRegexUtility();
	
	public Contact() {}
	public Contact(String firstName, String lastName, String primaryEmail, String secondEmail, 
			String primaryPhone, String secondPhone) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPrimaryEmail(primaryEmail);
		this.setSecondEmail(secondEmail);
		this.setPrimaryPhone(primaryPhone);
		this.setSecondPhone(secondPhone);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(r.isValidHumanName(firstName)) {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException("Invalid first name");
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(r.isValidHumanName(lastName)) {
			this.lastName = lastName;
		}
		else {
			throw new IllegalArgumentException("Invalid last name");
		}
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		if(r.isValidEmailAddress(primaryEmail)) {
			this.primaryEmail = primaryEmail;
		}
		else {
			throw new IllegalArgumentException("Invalid primary email");
		}
	}
	public String getSecondEmail() {
		return secondEmail;
	}
	public void setSecondEmail(String secondEmail) {
		if(r.isValidEmailAddress(secondEmail)) {
			this.secondEmail = secondEmail;
		}
		else {
			throw new IllegalArgumentException("Invalid secondary email");
		}
	}
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
		if(r.isValidPhoneNumber(primaryPhone)) {
			this.primaryPhone = primaryPhone;
		}
		else {
			throw new IllegalArgumentException("Invalid primary phone");
		}
	}
	public String getSecondPhone() {
		return secondPhone;
	}
	public void setSecondPhone(String secondPhone) {
		if(r.isValidPhoneNumber(secondPhone)) {
			this.secondPhone = secondPhone;
		}
		else {
			throw new IllegalArgumentException("Invalid secondary phone");
		}
	}
	
	@Override
	public String toString() {
		return "Contact: " + this.getFirstName() + " " + this.getLastName() + " " + this.getPrimaryEmail() + " "
	+ this.getSecondEmail() + " " + this.getPrimaryPhone() + " " + this.getSecondPhone() + " " ;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Contact)) {
			return false;
		}
		Contact other = (Contact) obj;
		return this.getFirstName().equals(other.getFirstName()) && this.getPrimaryPhone().equals(other.getPrimaryPhone());
	}
	public String serialize() {
		return String.format("%255s%255s%255s%255s%12s%12s", this.getFirstName(), this.getLastName(), this.getPrimaryEmail(),
				this.getSecondEmail(), this.getPrimaryPhone(), this.getSecondPhone());
	}
	public Contact deserialize(byte[] b) {
		String contact = new String(b);
		this.setFirstName(contact.substring(0, 255).trim());
		this.setLastName(contact.substring(256, 510).trim());
		this.setPrimaryEmail(contact.substring(511, 765).trim());
		this.setSecondEmail(contact.substring(766, 1020).trim());
		this.setPrimaryPhone(contact.substring(1021, 1032).trim());
		this.setSecondPhone(contact.substring(1033, 1044).trim());
		return this;
	}
	
	//String firstName = formatted.substring(0, 255).trim();
	//
	
}

package edu.neumont.csc180.functionalstreams.payments;

import java.util.regex.Pattern;

public class PaymentCard {

	private String number;
	
	public PaymentCard() {}
	
	public PaymentCard(String number) {
		this.setNumber(number);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		validateNumber(number);
		this.number = number;
	}
	
	private void validateNumber(String number) {
		if(number == null || !Pattern.matches("4[0-9]{15}", number)) {
			throw new IllegalArgumentException("Invalid number: " + number);
		}
	}
	
	@Override
	public String toString() {
		return this.getNumber();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PaymentCard)) {
			return false;
		}
		PaymentCard other = (PaymentCard)obj;
		return this.getNumber().equals(other.getNumber());
	}
}

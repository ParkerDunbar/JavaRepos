package edu.neumont.csc180.functionalstreams.payments;

import java.text.NumberFormat;
import java.time.LocalDateTime;

public class Transaction {
	
	private static NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	private LocalDateTime timestamp;
	
	private String merchant;
	
	private double amount;
	
	private PaymentCard card;
	
	public Transaction() {}
	
	public Transaction(
			String merchant,
			double amount,
			PaymentCard card) {
		
		this(null, merchant, amount, card);
	}
	
	public Transaction(
			LocalDateTime timestamp,
			String merchant,
			double amount,
			PaymentCard card) {
		
		this.setTimestamp(timestamp != null ? timestamp : LocalDateTime.now());
		this.setMerchant(merchant);
		this.setAmount(amount);
		this.setCard(card);
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		if(timestamp == null) {
			throw new IllegalArgumentException("timestamp cannot be null");
		}
		this.timestamp = timestamp;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		if(merchant == null) {
			throw new IllegalArgumentException("merchant cannot be null");
		}
		this.merchant = merchant;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentCard getCard() {
		return card;
	}

	public void setCard(PaymentCard card) {
		if(card == null) {
			throw new IllegalArgumentException("card cannot be null");
		}
		this.card = card;
	}
	
	@Override
	public String toString() {
		return this.getTimestamp().toString() + " " +
				this.getCard() + " " +
				fmt.format(this.getAmount()) + " " +
				this.getMerchant();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Transaction)) {
			return false;
		}
		Transaction other = (Transaction)obj;
		return this.getCard().equals(other.getCard()) &&
				this.getTimestamp().equals(other.getTimestamp()) &&
				this.getAmount() == other.getAmount();
	}
}

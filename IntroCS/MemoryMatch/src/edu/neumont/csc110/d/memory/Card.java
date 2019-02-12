package edu.neumont.csc110.d.memory;

public class Card {
	public String message;
	public boolean shown;
	public boolean matched;
	
	public void flip() {
		shown = !shown;
	}
	
	public boolean equals(Object obj) {
		Card c = (Card)obj;
		return message.equals(c.message);
	}
}

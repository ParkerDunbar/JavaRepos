package edu.neumont.csc150.d.grocery;

public class Orange implements Items , Comparable<Items> {
	private double weight;
	private double price;
	
	public Orange() {
	}
	
	public Orange(double w, double p) {
		this.setWeight(w);
		this.setPrice(p);
	}

	@Override
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Items o) {
		return Double.compare(this.getWeight(), o.getWeight());
	}
	
}

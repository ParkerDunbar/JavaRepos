package cox.ryan.csc360;

import java.text.NumberFormat;

public class Item implements PrintableMenuEntry {

	private String name;
	
	private String description;
	
	private double cost;
	
	private boolean glutinFree;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isGlutinFree() {
		return glutinFree;
	}

	public void setGlutinFree(boolean glutinFree) {
		this.glutinFree = glutinFree;
	}
	
	public void print() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		System.out.println(this.getName() + "\t" + fmt.format(this.getCost()) + " " + (this.isGlutinFree() ? "GF" : ""));
		System.out.println("\t" + this.getDescription());
	}
}

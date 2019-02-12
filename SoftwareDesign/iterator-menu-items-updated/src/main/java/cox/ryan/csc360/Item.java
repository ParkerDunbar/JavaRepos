package cox.ryan.csc360;

import java.text.NumberFormat;
import java.util.Iterator;

public class Item extends PrintableMenuEntry {
	
	private String description;
	
	private double cost;
	
	private boolean glutinFree;

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

	@Override
	protected Iterator<PrintableMenuEntry> childIterator() {
		return new Iterator<PrintableMenuEntry>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public PrintableMenuEntry next() {
				return null;
			}
		};
	}
}

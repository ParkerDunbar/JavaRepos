package cox.ryan.csc150.weighable;

public class Apple extends WeighableItem implements Comparable<WeighableItem> {
	
	private int numberSeeds;
	
	public Apple() {
		super();
	}
	
	public Apple(double weight, double price, int numSeeds) {
		super(weight, price);
		this.setNumberSeeds(numSeeds);
	}
	
	public int getNumberSeeds() {
		return numberSeeds;
	}

	public void setNumberSeeds(int numberSeeds) {
		if(numberSeeds < 0) {
			throw new IllegalArgumentException("numberSeeds cannot be negative");
		}
		this.numberSeeds = numberSeeds;
	}

	// "Apple Weight: 3 Unit Price: 4.5
	@Override
	public String toString() {
		return "Apple " + super.toString();
	}

	@Override
	public void printItemName() {
		System.out.println("Apple");
		
	}
}










package cox.ryan.csc150.weighable;

public class Orange extends WeighableItem implements Comparable<WeighableItem> {

	private double weight;
	
	private double price;
	
	public Orange(double weight, double price) {
		this.setWeight(weight);
		this.setPrice(price);
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
	public void printItemName() {
		System.out.println("Orange");
		
	}
}

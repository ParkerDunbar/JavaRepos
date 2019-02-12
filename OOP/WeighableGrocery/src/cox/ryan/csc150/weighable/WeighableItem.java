package cox.ryan.csc150.weighable;

abstract public class WeighableItem {
	
	protected double weight;
	
	protected double price;
	
	public WeighableItem() {
	}
	
	public WeighableItem(double weight, double price) {
		this.setWeight(weight);
		this.setPrice(price);
	}
	
	abstract public void printItemName();

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int compareTo(WeighableItem o) {
		return Double.compare(this.getWeight(), o.getWeight());
	}

	@Override
	public String toString() {
		return "Weight: " + this.getWeight() + " Unit Price:" + this.getPrice();
	}
}

















package dunbar.parker.csc280.sl.model;

public class Item {
	private String name;
	private String desc;
	private double qty;
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return desc + " " + qty + " " + price;
	}
	
	@Override
	public boolean equals(Object obj) {
		Item other = (Item)obj;
		if(other == null) {
			return false;
		}
		return this.toString().equalsIgnoreCase(other.toString());
	}
}

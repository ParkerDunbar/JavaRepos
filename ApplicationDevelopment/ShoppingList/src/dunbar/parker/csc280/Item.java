package dunbar.parker.csc280;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String desc;
	private int qty;
	private double price;
	
	public Item(String name, String desc, int qty, double price) {
		this.setName(name);
		this.setDesc(desc);
		this.setQty(qty);
		this.setPrice(price);
	}
	
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
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
		return name + ", " + desc + ", " + qty + ", " + price;
	}
}

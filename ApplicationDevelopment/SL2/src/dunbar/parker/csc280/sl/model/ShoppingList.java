package dunbar.parker.csc280.sl.model;

import java.util.ArrayList;

public class ShoppingList extends ArrayList<Item>{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public ShoppingList() {}
	
	public ShoppingList(String listName) {
		this.name = listName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		ShoppingList other = (ShoppingList)o;
		if(other == null) {
			return false;
		}
		if(!this.getName().equalsIgnoreCase(other.getName()) || this.size() != other.size()) {
			return false;
		}
//		for(Item item : this) {
//			if(!other.contains(item)) {
//				return false;
//			}
//		}
		return true;
	}

	@Override
	public String toString() {
		return name = " [" + super.toString()  + "]";
	}
	

}

package dunbar.parker.csc280.sl.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private List<ShoppingList> shoppingLists = new ArrayList<>();
	
	public User() {}
	
	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<ShoppingList> getShoppingLists() {
		return shoppingLists;
	}
	public void setShoppingLists(List<ShoppingList> shoppingLists) {
		this.shoppingLists = shoppingLists;
	}
	
	
	@Override
	public String toString() {
		return username + " " + password;
	}
	
	@Override
	public boolean equals(Object obj) {
		User other = (User)obj;
		if(other == null) {
			return false;
		}
		return this.username.equals(other.username);
	}
}

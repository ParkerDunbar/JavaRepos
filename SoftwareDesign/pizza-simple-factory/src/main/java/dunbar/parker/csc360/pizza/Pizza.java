package dunbar.parker.csc360.pizza;

abstract public class Pizza {
	// NY-stype - thin
	// Chicago - thick
	// California - cheese stuffed
	
	private String crustType;

	public String getCrustType() {
		return crustType;
	}

	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}
}

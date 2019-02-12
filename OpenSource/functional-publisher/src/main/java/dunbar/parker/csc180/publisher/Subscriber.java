package dunbar.parker.csc180.publisher;

public class Subscriber {

	private int id;
	
	public Subscriber(int id) {
		this.setId(id);
	}
	
	public void OnPublished(int value) {
		System.out.println("Subscriber received " + value);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

package dunbar.parker.csc360.utilities;

public class CeilingFan {
	
	private String speed;

	public void high() {
		speed = "high";
		System.out.println("Ceiling fan high");
	}
	
	public void medium() {
		speed = "medium";
		System.out.println("Ceiling fan medium");
	}
	
	public void low() {
		speed = "low";
		System.out.println("Ceiling fan low");
	}
	
	public void off() {
		speed = "off";
		System.out.println("Ceiling fan off");
	}
	
	public String getSpeed() {
		return speed;
	}
	
	public CeilingFan() {
		this.speed = "off";
	}
}


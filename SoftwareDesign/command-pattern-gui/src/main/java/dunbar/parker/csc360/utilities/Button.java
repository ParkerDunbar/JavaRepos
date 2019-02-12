package dunbar.parker.csc360.utilities;

import javafx.scene.shape.Circle;

public class Button {
	
	private String position;
	private Circle circle;
	
	public Button() {
		this.position = "neutral";
	}
	
	public void left() {
		this.position = "left";
		this.circle.setCenterX(circle.getCenterX() - 50);
	}
	
	public void right() {
		this.position = "right";
		this.circle.setCenterX(circle.getCenterX() + 50);
	}
	
	public void up() {
		this.position = "up";
		this.circle.setCenterY(circle.getCenterY() - 50);
	}
	
	public void down() {
		this.position = "down";
		this.circle.setCenterY(circle.getCenterY() + 50);
	}
	
	public void neutral() {
		this.position = "neutral";
		this.getCircle().setCenterX(100);
		this.getCircle().setCenterY(100);
	}
	
	public String getPosition() {
		return this.position;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	
}

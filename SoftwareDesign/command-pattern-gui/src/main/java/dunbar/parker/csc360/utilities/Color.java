package dunbar.parker.csc360.utilities;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Color implements Command {
	
	private Circle circle;
	private Paint previousColor;
	private Paint desiredColor;
	
	public Color(Circle circle, Paint desiredColor) {
		this.setCircle(circle);
		this.setPreviousColor(circle.getFill());
		this.desiredColor = desiredColor;
	}
	

	@Override
	public void execute() {
		this.setPreviousColor(getCircle().getFill());
		this.getCircle().setFill(desiredColor);
		System.out.println("prev: " + getPreviousColor());
		System.out.println("des: " + desiredColor);
	}
	@Override
	public void undo() {
		if(desiredColor == null) {
			return;
		}
		System.out.println("prev: " + desiredColor);
		this.getCircle().setFill(desiredColor);
	}
	@Override
	public Command clone() {
		Color c = new Color(this.getCircle(), this.getPreviousColor());
		return c;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Paint getPreviousColor() {
		return previousColor;
	}

	public void setPreviousColor(Paint previousColor) {
		this.previousColor = previousColor;
	}
}

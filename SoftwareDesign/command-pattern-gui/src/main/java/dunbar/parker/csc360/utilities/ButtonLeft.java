package dunbar.parker.csc360.utilities;

public class ButtonLeft implements Command {
	
	private Button button;
	private String previousPosition;
	
	public ButtonLeft(Button b, String currentPosition) {
		this.setButton(b);
		this.setPreviousPosition(currentPosition);
	}
	
	@Override
	public void execute() {
		this.setPreviousPosition(getButton().getPosition());
		this.getButton().left();
		System.out.println("prev: " + getPreviousPosition());
		System.out.println("cur: " + this.getButton().getPosition());
	}
	@Override
	public void undo() {
		System.out.println("prevU: " + getPreviousPosition());
		System.out.println("curU: " + this.getButton().getPosition());
		if(previousPosition == null) {
			return;
		}
		switch(previousPosition) {
		case "up":
			this.getButton().down();
			break;
		case "down":
			this.getButton().up();
			break;
		case "left":
			this.getButton().right();
			break;
		case "right":
			this.getButton().left();
			break;
		case "neutral":
			this.getButton().neutral();
			break;
		default:
			throw new IllegalArgumentException(
					"unexpected previous state " + previousPosition);
		}
	}
	@Override
	public Command clone() {
		ButtonLeft b = new ButtonLeft(this.getButton(), this.getButton().getPosition());
		return b;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public String getPreviousPosition() {
		return previousPosition;
	}

	public void setPreviousPosition(String previousPosition) {
		this.previousPosition = previousPosition;
	}
}

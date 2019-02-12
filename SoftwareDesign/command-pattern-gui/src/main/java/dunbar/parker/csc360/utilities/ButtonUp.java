package dunbar.parker.csc360.utilities;

public class ButtonUp implements Command {

	private Button button;
	
	private String previousPosition;
	
	public ButtonUp(Button b, String currentPosition) {
		this.setButton(b);
		this.setPreviousPosition(currentPosition);
	}
	
	@Override
	public void execute() {
		this.setPreviousPosition(getButton().getPosition());
		this.getButton().up();
		System.out.println("prev: " + getPreviousPosition());
		System.out.println("cur: " + this.getButton().getPosition());
	}
	@Override
	public void undo() {
		if(previousPosition == null) {
			return;
		}
		System.out.println("prevU: " + getPreviousPosition());
		System.out.println("curU: " + this.getButton().getPosition());
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
		ButtonUp b = new ButtonUp(this.getButton(), this.getButton().getPosition());
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

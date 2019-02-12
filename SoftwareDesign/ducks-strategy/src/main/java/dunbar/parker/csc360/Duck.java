package dunbar.parker.csc360;

public class Duck {
	private FlyingBehavior flyingBehavior;
	
	private SpeakingBehavior speakingBehavior;

	
	public Duck() {}
	
	public Duck(FlyingBehavior f, SpeakingBehavior s) {
		this.flyingBehavior = f;
		this.speakingBehavior = s;
	}
	
	
	public FlyingBehavior getFlyingBehavior() {
		return flyingBehavior;
	}

	public void setFlyingBehavior(FlyingBehavior flyingBehavior) {
		this.flyingBehavior = flyingBehavior;
	}

	public SpeakingBehavior getSpeakingBehavior() {
		return speakingBehavior;
	}

	public void setSpeakingBehavior(SpeakingBehavior speakingBehavior) {
		this.speakingBehavior = speakingBehavior;
	}
}

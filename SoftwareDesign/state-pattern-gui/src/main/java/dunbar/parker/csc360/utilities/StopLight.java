package dunbar.parker.csc360.utilities;

import javafx.scene.canvas.GraphicsContext;

public class StopLight {
	
	private State state;
	private GreenLightState greenLightState;
	private YellowLightState yellowLightState;
	private RedLightState redLightState;
	private Driver driver;
	
	public StopLight(Driver driver) {
		this.greenLightState = new GreenLightState(this);
		this.yellowLightState = new YellowLightState(this);
		this.redLightState = new RedLightState(this);
		this.driver = driver;
		this.setState(greenLightState);
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public GreenLightState getGreenLightState() {
		return greenLightState;
	}
	public YellowLightState getYellowLightState() {
		return yellowLightState;
	}
	public RedLightState getRedLightState() {
		return redLightState;
	}
	public Driver getDriver() {
		return driver;
	}
}
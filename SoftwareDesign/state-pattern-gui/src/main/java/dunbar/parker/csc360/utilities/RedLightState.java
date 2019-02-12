package dunbar.parker.csc360.utilities;

public class RedLightState implements State {

	private StopLight stopLight;
	
	public RedLightState(StopLight stopLight) {
		this.setStopLight(stopLight);
	}
	
	public void fireTimer() {
		this.getStopLight().setState(stopLight.getGreenLightState());
	}

	public StopLight getStopLight() {
		return stopLight;
	}

	public void setStopLight(StopLight stopLight) {
		this.stopLight = stopLight;
	}
}

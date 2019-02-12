package dunbar.parker.csc360.utilities;

public class YellowLightState implements State {
	
	private StopLight stopLight;
	
	public YellowLightState(StopLight stopLight) {
		this.setStopLight(stopLight);
	}

	public void fireTimer() {
		this.getStopLight().setState(stopLight.getRedLightState());
	}

	public StopLight getStopLight() {
		return stopLight;
	}

	public void setStopLight(StopLight stopLight) {
		this.stopLight = stopLight;
	}

}

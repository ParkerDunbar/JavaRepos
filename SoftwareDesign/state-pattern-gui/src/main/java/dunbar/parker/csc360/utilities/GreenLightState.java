package dunbar.parker.csc360.utilities;

public class GreenLightState implements State {

	
	private StopLight stopLight;
	
	public GreenLightState(StopLight stopLight) {
		this.setStopLight(stopLight);
	}
	
	public void fireTimer() {
		this.getStopLight().setState(stopLight.getYellowLightState());
		this.getStopLight().getDriver().drawGreenLight();
	}

	public StopLight getStopLight() {
		return stopLight;
	}

	public void setStopLight(StopLight stopLight) {
		this.stopLight = stopLight;
	}


}

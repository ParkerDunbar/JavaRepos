package dunbar.parker.csc360.utilities;

import java.util.TimerTask;


public class Switch extends TimerTask {
	
	private StopLight stopLight;
	
	public Switch(StopLight stopLight) {
		this.setStopLight(stopLight);
	}
	
	public StopLight getStopLight() {
		return stopLight;
	}

	public void setStopLight(StopLight stopLight) {
		this.stopLight = stopLight;
	}

	@Override
	public void run() {
		stopLight.getState().fireTimer();
		System.out.println("Timer fired");
	}



}

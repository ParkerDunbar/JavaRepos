package dunbar.parker.csc360.utilities;

public class CeilingLightOnCommand implements Command {
	
	private CeilingLight ceilingLightDriver;
	
	private String previousState;
	
	public CeilingLightOnCommand(CeilingLight cl, String previousState) {
		this.setCeilingLightDriver(cl);
	}

	public void execute() {
		this.ceilingLightDriver.on();
	}
	
	@Override
	public void undo() {
		this.ceilingLightDriver.off();
	}
	
	@Override
	public Command clone() {
		CeilingLightOnCommand c = new CeilingLightOnCommand(getCeilingLightDriver(), this.getPreviousState());
		return c;
	}
	
	public CeilingLight getCeilingLightDriver() {
		return ceilingLightDriver;
	}
	
	public void setCeilingLightDriver(CeilingLight cl) {
		this.ceilingLightDriver = cl;
	}

	public String getPreviousState() {
		return previousState;
	}

	public void setPreviousState(String previousState) {
		this.previousState = previousState;
	}


	
	
}

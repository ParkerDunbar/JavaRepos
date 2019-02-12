package dunbar.parker.csc360.utilities;

public class CeilingFanHighCommand implements Command {
	
	private CeilingFan fan;
	
	private String previousSetting;
	
	public CeilingFanHighCommand(CeilingFan f, String curState) {
		this.setFan(f);
		this.setPreviousSetting(curState);
	}

	@Override
	public void execute() {
		this.setPreviousSetting(getFan().getSpeed());
		this.getFan().high();
	}

	@Override
	public void undo() {
		if(previousSetting == null) {
			return;
		}
		switch(previousSetting) {
		case "high":
			this.getFan().high();
			break;
		case "medium":
			this.getFan().medium();
			break;
		case "low":
			this.getFan().low();
			break;
		case "off":
			this.getFan().off();
			break;
		default:
			throw new IllegalArgumentException(
					"unexpected previous state " + previousSetting);
		}
	}
	
	@Override
	public Command clone() {
		CeilingFanHighCommand c = new CeilingFanHighCommand(this.getFan(), this.getPreviousSetting());
		return c;
	}

	public CeilingFan getFan() {
		return fan;
	}

	public void setFan(CeilingFan fan) {
		this.fan = fan;
	}

	public String getPreviousSetting() {
		return previousSetting;
	}

	public void setPreviousSetting(String previousSetting) {
		this.previousSetting = previousSetting;
	}

}

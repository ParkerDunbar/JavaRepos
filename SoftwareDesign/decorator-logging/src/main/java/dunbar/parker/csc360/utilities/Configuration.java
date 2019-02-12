package dunbar.parker.csc360.utilities;

public class Configuration {
	
	private boolean timestampLogging;
	
	private boolean theadIdLogging;

	public boolean isTimestampLogging() {
		return timestampLogging;
	}

	public void setTimestampLogging(boolean timestampLogging) {
		this.timestampLogging = timestampLogging;
	}

	public boolean isTheadIdLogging() {
		return theadIdLogging;
	}

	public void setTheadIdLogging(boolean theadIdLogging) {
		this.theadIdLogging = theadIdLogging;
	}
	
}

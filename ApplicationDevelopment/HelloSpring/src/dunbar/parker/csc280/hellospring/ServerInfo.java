package dunbar.parker.csc280.hellospring;

import java.util.ArrayList;
import java.util.List;

public class ServerInfo {

	private String serverTime;
	
	private List<Long> lastCalledTimes = new ArrayList<>();

	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}

	public List<Long> getLastCalledTimes() {
		return lastCalledTimes;
	}

	public void setLastCalledTimes(List<Long> lastCalledTimes) {
		this.lastCalledTimes = lastCalledTimes;
	}
	
}

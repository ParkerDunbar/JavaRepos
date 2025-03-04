package dunbar.parker.csc370.surgery;

public class Patient {
	private int id;
	private int arrivalTime;
	private int serviceTime;
	private int waitTime;

	public Patient(int id, int arrival, int service) {
		this.id = id;
		this.arrivalTime = arrival;
		this.serviceTime = service;
	}
	
	
	public void run() {
		System.out.println("Customer " + this.getId() + " is now recieving surgery");
		for(int i = 0; i<this.serviceTime; i++) {
			ServiceProvider.currentClockTick++;
		}
		System.out.println("Customer " + this.getId() + " has finished their surgery, taking " + this.serviceTime 
				+ " ticks and ending at tick " + ServiceProvider.currentClockTick);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

}

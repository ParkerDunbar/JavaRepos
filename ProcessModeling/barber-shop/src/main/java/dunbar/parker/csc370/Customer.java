package dunbar.parker.csc370;

public class Customer {
	private int id;
	private int arrivalTime;
	private int serviceTime;
	private int waitTime;
	private static boolean barberAquired = false;
	
	
	public Customer(int id, int arrival, int service) {
		this.id = id;
		this.arrivalTime = arrival;
		this.serviceTime = service;
	}


	public void run() {
		System.out.println("Customer " + this.getId() + " is now recieving their haircut");
		for(int i = 0; i<this.serviceTime; i++) {
			Shop.currentClockTick++;
		}
		System.out.println("Customer " + this.getId() + " has finished their haircut, taking " + this.serviceTime 
				+ " ticks and ending at tick " + Shop.currentClockTick);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

package dunbar.parker.csc370.therapy;

import java.util.Timer;

public class Patient extends Thread {
	private static int MIN_TIME = 5000, MAX_TIME = 15000;
	private static Object therapist = new Object();
	
	
	public void run() {
		long sessionTime = generateRandomSessionTime();
		//Start wait time
		long startWait = System.currentTimeMillis();
		long endWait;
		//Wait for therapist to free up
		synchronized(therapist) {
			endWait = System.currentTimeMillis();
			long duration = endWait - startWait;
			if(Simulator.inOffice) {
				//When free, end wait time and start session time
				System.out.println("Patient " + this.getId() + " has started their session.");
				patientSession(sessionTime);
				//End session time
				System.out.println("Patient " + this.getId() + " has ended their session. Wait Time: " + duration + "ms Session Time: " + sessionTime + "ms");
			}
			else {
				System.out.println("Patient " + this.getId() + " has been thrown out of the office after waiting " + duration + "ms");
			}
		}
	}


	private long generateRandomSessionTime() {
		return Simulator.gen.nextInt(MAX_TIME - MIN_TIME + 1) + MIN_TIME;
	}


	private void patientSession(long sessionTime) {
		try {
			Thread.sleep(sessionTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

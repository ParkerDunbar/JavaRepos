package dunbar.parker.csc370.surgery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceProvider extends Thread {
	public final int SIM_CLOCK_TICKS = 5000;
	public static int currentClockTick = 0;
	public Random random = new Random();
	

	public void run() {
		List<Patient> future = createFutureEvents();
		List<Patient> current = new ArrayList<Patient>();
		List<Patient> past = new ArrayList<Patient>();
		
		
		while (currentClockTick <= SIM_CLOCK_TICKS) {
			if (future.size() != 0) {
				current.add(future.remove(0));
			}
			for (Patient c : current) {
				checkForUpdate(c);
			}
			if (current.size() != 0) {
				past.add(current.remove(0));
			}
		}
		
		System.out.println("Patients served: " + past.size());
		System.out.println("Patients kicked out at end of the day: " + future.size());
		
		double averageWait = 0;
		for(Patient c : past) {
			averageWait += c.getWaitTime();
		}
		double average = averageWait / past.size();
		System.out.println("Average wait time: " + average);
	}


	private List<Patient> createFutureEvents() {
		List<Patient> patients = new ArrayList<Patient>();
		int arrival = 0;
		int patientId = 0;
		while (arrival < SIM_CLOCK_TICKS) {
			// Interval
			int interval = (int) (-Math.log(1 - random.nextDouble()) * 60);
			arrival += interval;
//			System.out.println("PATIENT: " + customerId);
//			System.out.println("INTERVAL: " + interval);
//			System.out.println("ARRIVAL: " + arrival);

			// Service
			int service = (int) (-Math.log(1 - random.nextDouble()) * 45);
//			System.out.println("SURGERY_TIME: " + service);

			patients.add(new Patient(patientId, arrival, service));
			patientId++;
		}
		return patients;
	}
	
	private void checkForUpdate(Patient c) {
		while (currentClockTick < c.getArrivalTime()) {
			currentClockTick++;
		}
		if (currentClockTick == c.getArrivalTime()) {
			System.out.println("Patient " + c.getId() + " has arrived at clock tick " + currentClockTick);
		} else if (currentClockTick > c.getArrivalTime()) {
			int wait = currentClockTick - c.getArrivalTime();
			System.out.println("Patient " + c.getId() + " arrived at clock tick " + c.getArrivalTime() + ", "
					+ wait + " ticks before the last patient's surgery finished");
		}
		int waitTime = currentClockTick - c.getArrivalTime();
		c.setWaitTime(waitTime);
		c.run();
	}
}

package dunbar.parker.csc370.therapy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Simulator {
	public static Random gen = new Random();
	public static boolean inOffice = true;
	private static final int MIN_ARRIVAL_MIL = 5000, MAX_ARRIVAL_MIL = 20000;
	private static final int MIN_PATIENT = 1, MAX_PATIENT = 3;

	public static void main(String[] args) {
		LocalDateTime endTime = LocalDateTime.now().plusMinutes(2);
		ExecutorService svc = null;
		System.out.println("The Therapist has entered the office");
		
		while(LocalDateTime.now().isBefore(endTime)) {
			int patients = 	generateRandomPatients();
			long arrivalTime = generateRandomArrivalTime();
			
			List<Patient> pats = new ArrayList<Patient>();
			for(int i=0; i<patients; i++) {
				pats.add(new Patient());
			}
			
			waitForArrival(arrivalTime);

			System.out.println(patients + " patient(s) have arrived");			
			svc = Executors.newFixedThreadPool(patients);
			
			for(Patient p : pats) {
				svc.submit(() -> p.run());
			}
		}
		System.out.println("The Therapist has left the office");
		svc.shutdown();
		inOffice = false;

	}

	private static long generateRandomArrivalTime() {
		return gen.nextInt(MAX_ARRIVAL_MIL - MIN_ARRIVAL_MIL + 1) + MIN_ARRIVAL_MIL;
	}

	private static int generateRandomPatients() {
		return gen.nextInt(MAX_PATIENT) + MIN_PATIENT;
	}

	private static void waitForArrival(long arrivalTime) {
		try {
			Thread.sleep(arrivalTime);
		} catch (InterruptedException e) {e.printStackTrace();}
		
	}
}



//ScheduledExecutorService svc = Executors.newScheduledThreadPool(patients);
//Patient p = new Patient();
//svc.scheduleWithFixedDelay(() -> p.run(), 0, arrivalTime, TimeUnit.MILLISECONDS);

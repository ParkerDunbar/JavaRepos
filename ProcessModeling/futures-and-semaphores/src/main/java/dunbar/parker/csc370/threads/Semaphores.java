package dunbar.parker.csc370.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semaphores {
	final static int STUDENTS = 100;
	final static int MAX_OCCUPANCY = 5;
	
	public static void main(String[] args) {
		ExecutorService svc = Executors.newFixedThreadPool(STUDENTS);
		Semaphore semaphore = new Semaphore(MAX_OCCUPANCY, true);
		
		for(int i=0; i<STUDENTS; i++) {
			final int j = i;
			svc.submit(() -> {
				try { semaphore.acquire(); } catch (InterruptedException e) {}
				try {
					System.out.println("Thread " + j + " has entered the classroom");
					sleep(500);
					System.out.println("Thread " + j + " has left the classroom");
				}  finally {
					semaphore.release();
				}
			});
		}
		
	}

	private static void sleep(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

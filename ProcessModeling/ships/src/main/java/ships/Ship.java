package ships;

import java.util.Random;

public class Ship extends Thread {
	public static final int MIN_MILLISECOND = 5;
	public static final int MAX_MILLISECOND = 800;
	
	@Override
	public void run() {
		Random r = new Random();
		long randomInt = r.nextInt(MAX_MILLISECOND - MIN_MILLISECOND + 1) + MIN_MILLISECOND;
		
		try {
			Thread.sleep(randomInt);
			System.out.println("Thread ID: " + this.getId() + " Thread Name: " + this.getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

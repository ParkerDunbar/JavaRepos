package dunbar.parker.csc370;

import java.util.Random;

public class MyThread extends Thread {
	public static int sharedResource = 0;
	private static Random gen = new Random();
	
	public void run() {
		System.out.println("Starting Thread " + this.getId());
		
		int x = sharedResource;
		try {
			Thread.sleep(gen.nextInt(2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x++;
		sharedResource = x;
		
		System.out.println("Ending Thread " + this.getId());
	}

}

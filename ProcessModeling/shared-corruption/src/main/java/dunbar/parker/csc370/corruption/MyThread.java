package dunbar.parker.csc370.corruption;

import java.util.Random;

public class MyThread {
	public static int sharedResource = 0;
	public static boolean locked = false;
	private static Random gen = new Random();
	private static Object lock = new Object();

//	public MyThread() {
//		this.setName("Corrupting Thread");
//		this.setDaemon(true);
//	}

	public void run() {
		System.out.println("Starting thread " );

//		while (locked) {
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException ex) {
//			}
//		}
//		locked = true;
		
		
		synchronized(lock) {
			int x = sharedResource;
			try {
				Thread.sleep(gen.nextInt(10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x++;
			sharedResource = x;
		}
		
		
//		try {
//			int x = sharedResource;
//			try {
//				Thread.sleep(gen.nextInt(10));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			x++;
//			sharedResource = x;
//		} finally {
//			locked = false;
//		}

		System.out.println("Ending thread " );
	}
	
	private synchronized void criticalSection() {
		
	}

}

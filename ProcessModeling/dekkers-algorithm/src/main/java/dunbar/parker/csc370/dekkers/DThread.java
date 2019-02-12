package dunbar.parker.csc370.dekkers;

import java.util.Random;

public class DThread extends Thread {
	private int currentThread;
	private int otherThread;
	public static int sharedResource;
	public static int threadID = 0;
	private static Random gen = new Random();
	public static Boolean[] requestSection = new Boolean[2];
	
	public DThread(int position) {
		this.currentThread = position;
		if(this.currentThread == 0)
			otherThread = 1;
		else
			otherThread = 0;
	}
	
	public void run() {
		requestSection[currentThread] = true;
		while(requestSection[otherThread]) {
			if(threadID != currentThread) {
				requestSection[currentThread] = false;
				while (threadID != currentThread) {try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				requestSection[currentThread] = true;
			}
		}
		
		criticalSection();
		
		threadID = otherThread;
		requestSection[currentThread] = false;

	}

	private void criticalSection() {
		int x = sharedResource;
		try {
			Thread.sleep(gen.nextInt(2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x++;
		sharedResource = x;
	}


}

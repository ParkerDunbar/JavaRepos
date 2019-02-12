package dunbar.parker.csc370.dekkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
	public static final int NUMBER_OF_THREADS = 2;

	public static void main(String[] args) {
		List<DThread> threads = new ArrayList<>();
		for(int i=0; i<NUMBER_OF_THREADS; i++) {
			threads.add(new DThread(i));
		}
		Arrays.fill(DThread.requestSection, false);
		
		for(DThread t : threads) {
			t.start();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		System.out.println(DThread.sharedResource);
	}
}

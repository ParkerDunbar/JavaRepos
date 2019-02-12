package dunbar.parker.csc370.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {
	private static final int COUNT_TASKS = 5;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService svc = Executors.newFixedThreadPool(COUNT_TASKS);
		List<Future<?>> result = new ArrayList<>();
		
		for(int i=0; i<COUNT_TASKS; i++) {
			final int j = i;
			result.add(svc.submit(() -> {
				try {Thread.sleep(10);} catch(Exception ex) {}
				System.out.println("Thread " + j + " executing");
				return j + j + 1;
			}));
		}
		System.out.println("All threads started");
		
		for(Future<?> future : result) {
			Object o = future.get(); //Goes through each thread, doesn't execute until each thread is done executing
			System.out.println(o);
		}
	}

}

package dunbar.parker.csc370.corruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static void main(String[] args) {
//		ExecutorService svc = Executors.newFixedThreadPool(2, new ThreadFactory() {
//			@Override
//			public Thread newThread(Runnable r) {
//				Thread t = new Thread(r);
//				t.setName("Super cool thread:" + t.getId());
//				t.setDaemon(true);
//				return t;
//			}
//		});
		
		
		ScheduledExecutorService svc = Executors.newScheduledThreadPool(2);
		
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		System.out.println(MyThread.sharedResource);
		svc.scheduleWithFixedDelay(() -> {
			t1.run();
			System.out.println(MyThread.sharedResource);
		}, 1000, 5000, TimeUnit.MILLISECONDS);
		svc.submit(() -> t1.run()); //OR set MyThread to implement Runnable
		svc.submit(() -> t2.run());
//		t1.start();
//		t2.start();
		try {
			Thread.sleep(2100);
		} catch(InterruptedException ex) {}
		System.out.println(MyThread.sharedResource);
	}

}

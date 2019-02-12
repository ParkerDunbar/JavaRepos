package dunbar.parker.csc370;

public class Driver {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		System.out.println(MyThread.sharedResource);
		t1.start();
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(MyThread.sharedResource);

	}

}

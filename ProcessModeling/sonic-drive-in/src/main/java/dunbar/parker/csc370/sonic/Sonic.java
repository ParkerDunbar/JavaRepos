package dunbar.parker.csc370.sonic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Sonic {
	public final static int PARKING_SPOTS = 3;
	public final static int EMPLOYEES = 5;
	public final static int CUSTOMERS = 10;
	
	public static void main(String[] args) {
		ExecutorService svc = Executors.newFixedThreadPool(CUSTOMERS);
		Semaphore parkingSpots = new Semaphore(PARKING_SPOTS, true);
		
		for(int i=0; i<CUSTOMERS; i++) {
			int j = i;
			svc.submit(() -> {
				try {parkingSpots.acquire();} catch(Exception e) {}
				try {
					new Customer(j).run();
				} finally {
					parkingSpots.release();
				}

			});
		}
		
	}

//  critical section payment
//  semaphore parking spots
	
//	Customers wait for an available parking spot, attempting to take one when it comes available.
//	Customer enters an available parking spot and waits for an employee to being taking their order.
//	When an employee is available they begin taking a customer’s order by receiving a list of items that the customer is requesting.
//	The employee then processes the customer’s payment.
//	Some amount of time passes while the customer’s order is prepared (no employee is needed for this step).
//	Once the food is available an employee must also be available to deliver the food to the customer’s car window.
//	Some amount of time passes as the customer consumes their meal
//	The customer vacates the parking space.
}

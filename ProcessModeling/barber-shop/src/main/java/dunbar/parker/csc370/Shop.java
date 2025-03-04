package dunbar.parker.csc370;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
	public final static int SIM_CLOCK_TICKS = 5000;
	public static int currentClockTick = 0;
	public static Random random = new Random();

	public static void main(String[] args) {
		// 1 Barber
		// AR = 20 mins (3 cust / hour)
		// SR = 15 mins (4 cust / hour)

		// RV = random value from 0 (inclusive) to 1 (non-inclusive)
		// Inter-arrival time = -Ln(1-RV)*20
		// Service time = -Ln(1-RV)*15

		// Create future events
		List<Customer> future = createFutureEvents();
		List<Customer> current = new ArrayList<Customer>();
		List<Customer> past = new ArrayList<Customer>();

		while (currentClockTick <= SIM_CLOCK_TICKS) {
			if (future.size() != 0) {
				current.add(future.remove(0));
			}
			for (Customer c : current) {
				checkForUpdate(c);
			}
			if (current.size() != 0) {
				past.add(current.remove(0));
			}
		}
		
		System.out.println("Customers served: " + past.size());
		System.out.println("Customers kicked out at end of the day: " + future.size());
		
		double averageWait = 0;
		for(Customer c : past) {
			averageWait += c.getWaitTime();
		}
		double average = averageWait / past.size();
		System.out.println("Average wait time: " + average);

		// Check arrival
		// Check end service

		// Average Wait Time
		// double addedWait = 0;
		// double utilRate = 0;
		// for(Customer c : future) {
		// addedWait += c.getWaitTime();
		// utilRate += c.getServiceTime();
		// }
		//
		// double averageWait = addedWait / future.size();
		// double utilRateAverage = utilRate / SIM_CLOCK_TICKS;
		//
		// System.out.println(addedWait);
		// System.out.println(future.size());
		// System.out.println("AVERAGE WAIT TIME: " + averageWait);
		// System.out.println("UTIL " + utilRateAverage);

	}

	private static void checkForUpdate(Customer c) {
		while (currentClockTick < c.getArrivalTime()) {
			currentClockTick++;
		}
		if (currentClockTick == c.getArrivalTime()) {
			System.out.println("Customer " + c.getId() + " has arrived at clock tick " + currentClockTick);
		} else if (currentClockTick > c.getArrivalTime()) {
			int wait = currentClockTick - c.getArrivalTime();
			System.out.println("Customer " + c.getId() + " arrived at clock tick " + c.getArrivalTime() + ", "
					+ wait + " ticks before the last customer finished");
		}
		int waitTime = currentClockTick - c.getArrivalTime();
		c.setWaitTime(waitTime);
		c.run();
	}

	private static List<Customer> createFutureEvents() {
		List<Customer> customers = new ArrayList<Customer>();
		int arrival = 0;
		int customerId = 0;
		while (arrival < SIM_CLOCK_TICKS) {
			// Interval
			int interval = (int) (-Math.log(1 - random.nextDouble()) * 20);
			arrival += interval;
//			System.out.println("CUSTOMER: " + customerId);
//			System.out.println("INTERVAL: " + interval);
//			System.out.println("ARRIVAL: " + arrival);

			// Service
			int service = (int) (-Math.log(1 - random.nextDouble()) * 15);
//			System.out.println("SERVICE: " + service);

			customers.add(new Customer(customerId, arrival, service));
			customerId++;
		}
		return customers;
	}
}

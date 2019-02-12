package dunbar.parker.csc370.sonic;

import java.util.concurrent.Semaphore;

public class Customer {
	public int custID;
	public static Semaphore employees = new Semaphore(Sonic.EMPLOYEES);
	public static Object payment = new Object();
	
	public Customer(int customerID) {
		this.custID = customerID;
	}

	public void run() {
		//Parking spot
		System.out.println("Customer " + this.custID + " has entered a parking spot");
		sleep(3000);
		
		//Taking order
		takeOrder();
		
		//Payment
		synchronized(payment) {
			System.out.println("Customer " + this.custID + " is paying the employee for the order");
			sleep(3000);
		}
		
		//Food prep
		makeOrder();
		
		//Food delivery
		orderDelivery();
		
		//Food consumption / leaving
		System.out.println("Customer " + this.custID + " is eating their food");
		sleep(3000);
		System.out.println("Customer " + this.custID + " has left their parking spot");
	}
	
	private void orderDelivery() {
		try {employees.acquire();}
		catch(Exception ex) {}
		System.out.println("Customer " + this.custID + "'s order is being delivered");
		sleep(3000);
		employees.release();
	}

	private void makeOrder() {
		employees.release();
		System.out.println("Customer " + this.custID + "'s order has been taken and is being made");
		sleep(3000);
		
	}

	private void takeOrder() {
		try {employees.acquire();}
		catch(Exception ex) {}
		System.out.println("Customer " + this.custID + " is giving their order to an employee");
		sleep(3000);
		
	}

	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

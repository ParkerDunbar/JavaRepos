package edu.neumont.csc150.d.grocery;

import java.util.Arrays;

public class Checkout {
	
	public static void main(String args[]) {
		Items[] items = new Items[3];
		items[0] = new Apple(1, 0.50);
		items[1] = new Orange(0.50, 0.50);
		items[2] = new Celery(1.50, 1);
		Arrays.sort(items);
	}
}

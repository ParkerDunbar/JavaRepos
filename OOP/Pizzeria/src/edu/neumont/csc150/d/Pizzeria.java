package edu.neumont.csc150.d;

import java.util.ArrayList;

public class Pizzeria {

	public static void main(String[] args) {
		ArrayList<String> toppings = new ArrayList<>();
		toppings.add("Pepperoni");
		toppings.add("Anchovies");
		Pizza p1 = new Pizza(false, CrustType.DeepDish, toppings);
		Pizza p2 = new Pizza(false, CrustType.Thin, toppings);
		
		if(p1.equals(p2)) {
			System.out.println("Pizzas are equal");
		}
		else {
			System.out.println("Pizzas are not equal");
		}
	}

}

package edu.neumont.csc110.d.people;

import dunbar.parker.people.Person;

public class PersonTester {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.firstName = "Parker";
		p.lastName = "Dunbar";
		Person p2 = new Person();
		
		
		int[] intArr = new int[3];
		
		
		Person[] pArr = new Person[2];
		pArr[0] = new Person();
		pArr[0].firstName = "JimBob";
		
		int myInt = 5;
		printInt(5);
		doSomething(p2);
		
		
		//Person.speak();
		p.speak();
		Person.x = 4;
	}

	public static void doSomething(Person p) {
		System.out.println(p.firstName);
	}
	
	public static void printInt(int x) {
		System.out.println(x);
	}
}

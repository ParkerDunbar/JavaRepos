package edu.neumont.csc150.recurse;

public class Recurse {
	public static void main(String[] args) {
		printHello(5);
		System.out.println();
		printHelloR(5);
	}
	
	private static void printHelloR(int n) {
		if(n > 0) {
			System.out.println("Hello " + (n - 1));
			printHelloR(n-1);
		}
	}
	
	private static void printHello(int n) {
		for(int i=0;i<n;i++) {
			System.out.println("Hello " + i);
		}
	}
}

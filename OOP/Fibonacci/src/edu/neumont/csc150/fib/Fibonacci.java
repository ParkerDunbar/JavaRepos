package edu.neumont.csc150.fib;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibr(100));

	}
	
	public static int fibr(int n) {
		if(n <= 1) {
			return n;
		}
		return fibr(n-1) + fibr(n-2);
	}
	
}

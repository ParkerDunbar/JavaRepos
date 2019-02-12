package edu.neumont.csc110.d.calculator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Calculator {
	
	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));

		System.out.println("What operation would you like to perform?");
		System.out.println("Add");
		System.out.println("Subtract");
		System.out.println("Multiply");
		System.out.println("Divide");
		String operation = in.readLine();
		
		if(operation.equalsIgnoreCase("Add")) {
			System.out.println("Please enter the first number");
			String firstnum = in.readLine();
			System.out.println("Please enter the second number");
			String secondnum = in.readLine();
			double inputNum1 = Integer.parseInt(firstnum);
			double inputNum2 = Integer.parseInt(secondnum);
			System.out.println("Your answer is " + add(inputNum1, inputNum2));
		}
		if(operation.equalsIgnoreCase("Subtract")) {
			System.out.println("Please enter the first number");
			String firstnum = in.readLine();
			System.out.println("Please enter the second number");
			String secondnum = in.readLine();
			double inputNum1 = Integer.parseInt(firstnum);
			double inputNum2 = Integer.parseInt(secondnum);
			System.out.println("Your answer is " + sub(inputNum1, inputNum2));
		}
		if(operation.equalsIgnoreCase("Multiply")) {
			System.out.println("Please enter the first number");
			String firstnum = in.readLine();
			System.out.println("Please enter the second number");
			String secondnum = in.readLine();
			double inputNum1 = Integer.parseInt(firstnum);
			double inputNum2 = Integer.parseInt(secondnum);
			System.out.println("Your answer is " + mult(inputNum1, inputNum2));
		}
		if(operation.equalsIgnoreCase("Divide")) {
			System.out.println("Please enter the first number");
			String firstnum = in.readLine();
			System.out.println("Please enter the second number");
			String secondnum = in.readLine();
			double inputNum1 = Integer.parseInt(firstnum);
			double inputNum2 = Integer.parseInt(secondnum);
			System.out.println("Your answer is " + div(inputNum1, inputNum2));
		}
	}
	
	public static double add(double inputNum1, double inputNum2) {
		double sum = inputNum1 + inputNum2;
		return sum;
	}
	public static double sub(double inputNum1, double inputNum2) {
		double sum = inputNum1 - inputNum2;
		return sum;
	}
	public static double mult(double inputNum1, double inputNum2) {
		double sum = inputNum1 * inputNum2;
		return sum;
	}
	public static double div(double inputNum1, double inputNum2) {
		double sum = inputNum1 / inputNum2;
		return sum;
	}
}
package edu.neumont.csc110.d.extendedcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.text.NumberFormat;
import java.text.DecimalFormat;


public class ExtendedCalculator {
	
	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		NumberFormat cfmt = NumberFormat.getCurrencyInstance();
		DecimalFormat dfmt = new DecimalFormat("0.##");
		
		System.out.println("What operation would you like to perform?");
		System.out.println("Add / Subtract / Multiply / Divide");
		System.out.println("TempF2C / TempC2F");
		System.out.println("Exponent / Square Root");
		System.out.println("Sine / Cosine");
		System.out.println("Random");
		String operation = in.readLine();
		
		if(operation.equalsIgnoreCase("Add")) {
			System.out.println("Please enter the first number");
			String firstnum = in.readLine();
			System.out.println("Please enter the second number");
			String secondnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			double inputNum2 = Double.parseDouble(secondnum);
			System.out.println("Your answer is " + dfmt.format(add(inputNum1, inputNum2)));
			System.out.println("You owe " + cfmt.format(0.01));
		}
		if(operation.equalsIgnoreCase("Subtract")) {
			System.out.println("Please enter the first number");
			String firstnum = in.readLine();
			System.out.println("Please enter the second number");
			String secondnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			double inputNum2 = Double.parseDouble(secondnum);
			System.out.println("Your answer is " + dfmt.format(sub(inputNum1, inputNum2)));
			System.out.println("You owe " + cfmt.format(0.01));
		}
		if(operation.equalsIgnoreCase("Multiply")) {
			System.out.println("Please enter the first number");
			String firstnum = in.readLine();
			System.out.println("Please enter the second number");
			String secondnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			double inputNum2 = Double.parseDouble(secondnum);
			System.out.println("Your answer is " + dfmt.format(mult(inputNum1, inputNum2)));
			System.out.println("You owe " + cfmt.format(0.01));
		}
		if(operation.equalsIgnoreCase("Divide")) {
			System.out.println("Please enter the first number");
			String firstnum = in.readLine();
			System.out.println("Please enter the second number");
			String secondnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			double inputNum2 = Double.parseDouble(secondnum);
			System.out.println("Your answer is " + dfmt.format(div(inputNum1, inputNum2)));
			System.out.println("You owe " + cfmt.format(0.01));
		}
		if(operation.equalsIgnoreCase("TempF2C")) {
			System.out.println("Please enter the temperature in Farenheit");
			String firstnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			System.out.println("The temperature in Celsius is " + dfmt.format(f2c(inputNum1)));
			System.out.println("You owe " + cfmt.format(0.25));
		}
		if(operation.equalsIgnoreCase("TempC2F")) {
			System.out.println("Please enter the temperature in Celsius");
			String firstnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			System.out.println("The temperature in Farenheit is " + dfmt.format(c2f(inputNum1)));
			System.out.println("You owe " + cfmt.format(0.25));
		}
		if(operation.equalsIgnoreCase("Exponent")) {
			System.out.println("Please enter the base number");
			String firstnum = in.readLine();
			System.out.println("Please enter the exponent");
			String secondnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			double inputNum2 = Double.parseDouble(secondnum);
			System.out.println("The base raised to the exponent is " + dfmt.format(exp(inputNum1, inputNum2)));
			System.out.println("You owe " + cfmt.format(0.04));
		}
		if(operation.equalsIgnoreCase("Square Root")) {
			System.out.println("Please enter a number");
			String firstnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			System.out.println("The square root of the number is " + dfmt.format(sqrt(inputNum1)));
			System.out.println("You owe " + cfmt.format(0.04));
		}
		if(operation.equalsIgnoreCase("Sine")) {
			System.out.println("Please enter an angle");
			String firstnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			System.out.println("The sine of the angle is " + dfmt.format(sin(inputNum1)));
			System.out.println("You owe " + cfmt.format(0.25));
		}
		if(operation.equalsIgnoreCase("Cosine")) {
			System.out.println("Please enter an angle");
			String firstnum = in.readLine();
			double inputNum1 = Double.parseDouble(firstnum);
			System.out.println("The cosine of the angle is " + dfmt.format(cos(inputNum1)));
			System.out.println("You owe " + cfmt.format(0.25));
		}
		if(operation.equalsIgnoreCase("Random")) {
			System.out.println("Your random number between 0 - 1000 is " + random());
			System.out.println("You owe " + cfmt.format(0.04));
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
	public static double f2c(double inputNum1) {
		double sum = (inputNum1 - 32) * .5556;
		return sum;
	}
	public static double c2f(double inputNum1) {
		double sum = (inputNum1 * 1.8) + 32;
		return sum;
	}
	public static double exp(double inputNum1, double inputNum2) {
		double sum = Math.pow(inputNum1, inputNum2);
		return sum;
	}
	public static double sqrt(double inputNum1) {
		double sum = Math.sqrt(inputNum1);
		return sum;
	}
	public static double sin(double inputNum1) {
		double sum = Math.sin(inputNum1);
		return sum;
	}
	public static double cos(double inputNum1) {
		double sum = Math.cos(inputNum1);
		return sum;
	}
	public static double random() {
		Random generator = new Random();
		int ranNumber = generator.nextInt(1001);
		return ranNumber;
	}

}

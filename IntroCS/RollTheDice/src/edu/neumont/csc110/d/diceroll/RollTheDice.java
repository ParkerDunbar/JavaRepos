package edu.neumont.csc110.d.diceroll;

import java.util.Random;
//import java.text.DecimalFormat;
public class RollTheDice {

	public static void main(String[] args) {
		//DecimalFormat dfmt = new DecimalFormat ("0.##");
		
		int[] diceRoll = new int[10];
		Random generator = new Random();
		
		System.out.println("Your random numbers:");
		for(int i=0; i<10; i++) {
			diceRoll[i] = generator.nextInt(6) + 1;
			System.out.print(diceRoll[i] + " ");
		}
		
		System.out.println();
		System.out.println("Mode: " + mode(diceRoll));
		System.out.println("Mean: " + mean(diceRoll));
		System.out.println("Minimum: " + min(diceRoll));
		System.out.println("Maximum: " + max(diceRoll));
		System.out.println("Sum: " + sum(diceRoll));



	}
	
	public static int mode(int[] data) {
		int[] usage = new int[7];
		for(int i=0; i<data.length; i++) {
			int curNum = data[i];
			usage[curNum]++;
		}
		
		int biggestNumberIndex = 1;
		int biggestNumber = 0;
		
		for(int i=1; i<=6; i++) {
			if(usage[i] > biggestNumber) {
				biggestNumber = usage[i];
				biggestNumberIndex = i;
			}
		}
		return biggestNumberIndex;
	}
	
	public static double mean(int[] data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return (sum * 1.0 / data.length);
	}
	
	public static int min(int[] data) {
		return 0;
	}
	
	public static int max(int[] data) {
		return 0;
	}
	
	public static int sum(int[] data) {
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

}

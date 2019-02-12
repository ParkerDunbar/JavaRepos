package edu.neumont.csc110.d.arrayintro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.IOException;


public class Array {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("How many random integers would you like to print out?");
		String rL = input.readLine();
		int randomLength = Integer.parseInt(rL);
		
		int[] randomArray = new int[randomLength];
		Random generator = new Random();
		
		for(int i=randomLength-1; i>=0; i--) {
			randomArray[i] = generator.nextInt(51);
			System.out.println(i + " " + randomArray[i]);
		}
		
	}

}
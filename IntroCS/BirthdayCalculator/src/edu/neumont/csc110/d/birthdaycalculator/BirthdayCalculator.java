package edu.neumont.csc110.d.birthdaycalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BirthdayCalculator {

	public static void main(String[] args) throws IOException {

		
		int currentYear = getUserInputAsInt("What is the current year?");
		int currentMonth = getUserInputAsInt("What is the current month?");
		int currentDay = getUserInputAsInt("What is the current day?");
		int birthYear = getUserInputAsInt("What is the year you were born?");
		int birthMonth = getUserInputAsInt("What is the month you were born?");
		int birthDay = getUserInputAsInt("What is the day you were born?");
		
		int age = calculateAgeFromBirthdate(currentYear, currentMonth, currentDay, birthYear, birthMonth, birthDay);
		System.out.println("You are " + age + " years old");
		
		
		/*System.out.println("Please enter the current date.");
		System.out.println("What is the current year?");
		String currentYear = in.readLine();
		System.out.println("What is the current month?");
		String currentMonth = in.readLine();
		System.out.println("What is the current day?");
		String currentDay = in.readLine();
		
		System.out.println("Please enter your birth date.");
		System.out.println("What is the year you were born?");
		String birthYear = in.readLine();
		System.out.println("What is the month you were born?");
		String birthMonth = in.readLine();
		System.out.println("What is the day you were born?");
		String birthDay = in.readLine();
		
		parseInt(currentYear);
		parseInt(currentMonth);
		parseInt(currentDay);
		parseInt(birthYear);
		parseInt(birthMonth);
		parseInt(birthDay);*/
	}
	
	public static int getUserInputAsInt (String promptForUser) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		System.out.println(promptForUser);
		int rawInput = Integer.parseInt(in.readLine());
		return rawInput;
	}
	
	public static int calculateAgeFromBirthdate(int cYear, int cMonth, int cDay, int bYear, int bMonth, int bDay) {
		int age = cYear - bYear;
		if(cMonth < bMonth) {
			age = age - 1;
		}
		if(cMonth == bMonth) {
			if(cDay < bDay) {
				age = age - 1;
			}
		}
		return age;
	}
	
	/*public static int parseInt(String number) {
		int calcNumber = Integer.parseInt(number);
		return calcNumber;
	}*/
	
}


















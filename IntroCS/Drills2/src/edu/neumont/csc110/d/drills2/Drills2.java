package edu.neumont.csc110.d.drills2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Drills2 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		//drill1BranchIfElseBlock();
		//drill2BranchIfBlockElse();
		//drill3BranchIfElseOnlyBlock();
		//drill4FlowChart();
		//drill5NestedBranching();
		//drill6CascadingBranching();
		//drill7EnumTypeSwitch();
		//drill8DoWhileIt();
		//drill9DoWhileItBranch();
		//drill10DoWhileItBranchBreak();
		//drill11WhileIt();
		//drill12ForLoopIt();
		//drill13ForLoopIt();
		drill14ForLoopRevIt();
		//drill15ForLoopCont();
		//drill16ForEachIt();
		//drill17NestForLoopIt();
		//drill18SimpleArray();
		//drill19IntArray();
		//drill20ArrayValues();
		//drill21ArrayCalc();
		//drill22ArrayAdvCalc();
		//drill23ArrayRandom();
		//drill24ScaledHistogram();
		//drill25ArrayInit();
		
	}
	
	private static void drill1BranchIfElseBlock() throws IOException {
		System.out.println("Please enter your first name:");
		String userFirstName = in.readLine();
		
		if(userFirstName.equalsIgnoreCase("Fred")) {
			System.out.println("Please enter your last name:");
			String userLastName = in.readLine();
			
			System.out.println("Hello " + userFirstName + " " + userLastName);
		}
		else {
			System.out.println("What is your favorite color?");
			String userColor = in.readLine();
			System.out.println("Hello!");
			
		}
		
	}
	
	private static void drill2BranchIfBlockElse() throws IOException {
		System.out.println("Please enter your first name:");
		String userFirstName = in.readLine();
		
		if(userFirstName.equalsIgnoreCase("Fred")) {
			System.out.println("Please enter your last name:");
			String userLastName = in.readLine();
			
			System.out.println("Hello Fred " +  userLastName);
		}
		else {
			System.out.println("Hey there!");
		}
	}
	
	private static void drill3BranchIfElseOnlyBlock() throws IOException {
		System.out.println("Please enter your first name:");
		String userFirstName = in.readLine();
		
		if(userFirstName.equalsIgnoreCase("Fred")) {
			System.out.println("Hello Fred!");
		}
		else {
			System.out.println("What is your favorite color?");
			String userColor = in.readLine();
			System.out.println("Hello!");
		}
	}
	
	private static void drill4FlowChart() {
		//
		
	}
	
	private static void drill5NestedBranching() throws IOException {
		System.out.println("Please enter your first name:");
		String userFirstName = in.readLine();
		
		if(userFirstName.equalsIgnoreCase("Fred")) {
			System.out.println("Please enter your last name:");
			String userLastName = in.readLine();
			if(userLastName.equalsIgnoreCase("Flintstone")) {
				System.out.println("Hello Fred Flintstone!");
			}
			else {
				System.out.println("Hello Fred!");
			}
		}
		else {
			System.out.println("Please enter your favorite color:");
			String userColor = in.readLine();
			if(userColor.equalsIgnoreCase("Red")) {
				System.out.println("I'd rather be red than Fred");
			}
			else {
				System.out.println("Hello!");
			}
		}
	}
	
	private static void drill6CascadingBranching() throws IOException {
		System.out.println("Please enter your name:");
		String userName = in.readLine();
		if(userName.equalsIgnoreCase("Fred")) {
			System.out.println("Yapadapadoo");
		}
		else if(userName.equalsIgnoreCase("Barney")) {
			System.out.println("Rubble");
		}
		else if(userName.equalsIgnoreCase("Dino")) {
			System.out.println("Go chase a car");
		}
		else {
			System.out.println("You're not a Flintstone.");
		}
	}
	
	private static void drill7EnumTypeSwitch() {
		
	}
	
	private static void drill8DoWhileIt() throws IOException {
		int randomInt;
		boolean correctGuess = false;
		Random random = new Random();
		randomInt = random.nextInt(9) + 1;

		do {
			System.out.println("Guess the number between 1 - 10");
			String userInput = in.readLine();
			int userInt = Integer.parseInt(userInput);
			
			if(userInt == randomInt) {
				correctGuess = true;
				System.out.println("You guessed correctly!");
			}
			else {
				System.out.println("Try again!");
			}
			
		}while(correctGuess == false);
	}
	
	private static void drill9DoWhileItBranch() throws IOException {
		int randomInt;
		boolean correctGuess = false;
		Random random = new Random();
		randomInt = random.nextInt(9) + 1;

		do {
			System.out.println("Guess the number between 1 - 10");
			String userInput = in.readLine();
			int userInt = Integer.parseInt(userInput);
			
			if(userInt == randomInt) {
				correctGuess = true;
				System.out.println("You guessed correctly!");
			}
			else if(userInt > randomInt) {
				System.out.println("Too high, guess again!");
			}
			else if(userInt < randomInt) {
				System.out.println("Too low, guess again!");
			}

			
		}while(correctGuess == false);
	}
	
	private static void drill10DoWhileItBranchBreak() throws IOException {
		int randomInt;
		boolean correctGuess = false;
		Random random = new Random();
		randomInt = random.nextInt(9) + 1;

		do {
			System.out.println("Guess the number between 1 - 10");
			String userInput = in.readLine();
			int userInt = Integer.parseInt(userInput);
			
			if(userInt == randomInt) {
				correctGuess = true;
				System.out.println("You guessed correctly!");
				break;
			}
			else if(userInt > randomInt) {
				System.out.println("Too high, guess again!");
			}
			else if(userInt < randomInt) {
				System.out.println("Too low, guess again!");
			}

			
		}while(correctGuess == false);
	}
	
	private static void drill11WhileIt() {
		System.out.println("Please enter a string:");
	}
	
	private static void drill12ForLoopIt() throws IOException {
		System.out.println("Please enter a string:");
		String userInput = in.readLine();
		
		for(int i=0; i<userInput.length(); i++) {
			System.out.print(userInput.charAt(i) + " ");
		}
	}
	
	private static void drill13ForLoopIt() {
		System.out.println("Please enter an integer:");
		
		
	}
	
	private static void drill14ForLoopRevIt() throws IOException {
		System.out.println("Please enter a string:");
		String userInput = in.readLine();
		
		for(int i=userInput.length(); i>=0; i--) {
			System.out.println(userInput.charAt(i));
			
		}
		
	}
	
	private static void drill15ForLoopCont() {
		
	}
	
	private static void drill16ForEachIt() {
		
	}
	
	private static void drill17NestForLoopIt() {
		
	}
	
	private static void drill18SimpleArray() {
		String[] names = new String[] {"Doc", "Dopey", "Bashful", "Grumpy", "Sneezy", "Sleepy", "Happy"};
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
	}
	
	private static void drill19IntArray() {
		int[] numbers = new int[100];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = 42;
		}
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	
	private static void drill20ArrayValues() {
		int[] numbers = new int[100];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = i + 1;
		}
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	
	private static void drill21ArrayCalc() {
		int[] numbers = new int[100];
		int evenNumbers = 0;
		for(int i=0; i<numbers.length; i++) {
			evenNumbers += 2;
			numbers[i] = evenNumbers;
		}
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	
	private static void drill22ArrayAdvCalc() {
		long[] numbers = new long[90];
		numbers[0] = 1;
		numbers[1] = 1;
		for(int i=2; i<numbers.length; i++) {
			numbers[i] = numbers[i-1] + numbers[i-2];
		}
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	
	private static void drill23ArrayRandom() {
		
	}
	
	private static void drill24ScaledHistogram() {
		
	}
	
	private static void drill25ArrayInit() {
		String[] names = new String[] {"Doc", "Dopey", "Bashful", "Grumpy", "Sneezy", "Sleepy", "Happy"};
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
	}
}

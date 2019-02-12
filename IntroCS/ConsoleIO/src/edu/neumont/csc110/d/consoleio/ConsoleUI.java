package edu.neumont.csc110.d.consoleio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleUI {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Generates a console-based menu using the Strings in options as the menu items.
	 * Reserves the number 0 for the "quit" option when withQuit is true.
	 * @param options - Strings representing the menu options
	 * @param withQuit - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 * @throws IOException 
	 */
	static int promptForMenuSelection(String[] options, boolean withQuit) throws IOException {
		if(options == null || options.length == 0) {
			throw new IllegalArgumentException("Options cannot be null or empty");
		}
		boolean inputCheck = false;
		String userInput;
		int parseInput;
		
		if(withQuit) {
			System.out.println("0 - Quit");
		}
		for(int i=1; i<options.length; i++) {
			System.out.println(i + " - " + options[i]);
		}
		

		do{
			userInput = in.readLine();
			
			try {
			parseInput = Integer.parseInt(userInput);
			}
			catch(Exception ex) {
				parseInput = options.length + 1;
			}
			if(parseInput == 0){ 
				inputCheck = true;
			}
			else if(parseInput > 0 && parseInput <= options.length) {
				inputCheck = true;
				
			}
			else {
				System.out.println("Please enter a valid input.");
				inputCheck = false;
			}
		}while(inputCheck != true);
		return parseInput;
	}
	
	/**
	 * Generates a prompt that expects the user to enter one of two responses that will equate
	 * to a boolean value. The trueString represents the case insensitive response that will equate to true. 
	 * The falseString acts similarly, but for a false boolean value.
	 * 		Example: Assume this method is called with a trueString argument of "yes" and a falseString argument of
	 * 		"no". If the enters "YES", the method returns true. If the user enters "no", the method returns false.
	 * 		All other inputs are considered invalid, the user will be informed, and the prompt will repeat.
	 * @param prompt - the prompt to be displayed to the user
	 * @param trueString - the case insensitive value that will evaluate to true
	 * @param falseString - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 * @throws IOException 
	 */
	
	public static boolean promptForBool(String prompt, String trueString, String falseString) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		boolean isInputValid;
		boolean answer = true;
	
		do {
			String userAnswer = in.readLine();
			isInputValid = true;
			
			if(userAnswer.equalsIgnoreCase(trueString)) {
				answer = true;
			}
			else if(userAnswer.equalsIgnoreCase(falseString)) {
				answer = false;
			}
			else {
				isInputValid = false;
				System.out.println("Please enter a valid input.");
			}
			
		}while(!isInputValid);
		return answer;
		
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a byte value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the byte value
	 * @throws IOException 
	 */
	
	static byte promptForByte(String prompt, byte min, byte max) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		byte userByte = 0;
		int byteChecker = 1;
		
		do {
			String userAnswer = in.readLine();
			
			try {
				userByte = Byte.parseByte((userAnswer));
			}
			catch(NumberFormatException ex) {
				userByte = (byte) (min - 1);
			}
			
			if(userByte <= max && userByte >= min) {
				byteChecker = 1;
			}
			else {
				byteChecker = 0;
				System.out.println("Please enter a valid input.");
			}
			
		}while(byteChecker != 1);
		return userByte;
		

	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a short value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the short value
	 * @throws IOException 
	 */
	static short promptForShort(String prompt, short min, short max) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		short userShort = 0;
		int shortChecker = 1;
		
		do {
			String userAnswer = in.readLine();
			
			try {
			userShort = Short.parseShort((userAnswer));
			}
			catch(NumberFormatException ex) {
				userShort = (short) (min - 1);
			}

			
			if(userShort <= max && userShort >= min) {
				shortChecker = 1;
			}
			else {
				shortChecker = 0;
				System.out.println("Please enter a valid input.");
			}
			
		}while(shortChecker != 1);
		return userShort;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing an int value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the int value
	 * @throws IOException 
	 */
	public static int promptForInt(String prompt, int min, int max) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		int userInt = 0;
		int intChecker = 1;
		
		do {
			String userAnswer = in.readLine();
			
			try {
			userInt = Integer.parseInt((userAnswer));
			}
			catch(NumberFormatException ex) {
				userInt = min - 1;
			}

			
			if(userInt <= max && userInt >= min) {
				intChecker = 1;
			}
			else {
				intChecker = 0;
				System.out.println("Please enter a valid input.");
			}
			
		}while(intChecker != 1);
		return userInt;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a long value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the long value
	 * @throws IOException 
	 */
	static long promptForLong(String prompt, long min, long max) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		long userLong = 0;
		int longChecker = 1;
		
		do {
			String userAnswer = in.readLine();
			
			try {
			userLong = Long.parseLong((userAnswer));
			}
			catch(NumberFormatException ex) {
				userLong = min - 1;
			}

			
			if(userLong <= max && userLong >= min) {
				longChecker = 1;
			}
			else {
				longChecker = 0;
				System.out.println("Please enter a valid input.");
			}
			
		}while(longChecker != 1);
		return userLong;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a float value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the float value
	 * @throws IOException 
	 */
	static float promptForFloat(String prompt, float min, float max) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		float userFloat = 0;
		int floatChecker = 1;
		
		do {
			String userAnswer = in.readLine();

			try {
			userFloat = Float.parseFloat((userAnswer));
			}
			catch(NumberFormatException ex) {
				userFloat = min - 1;
			}
			
			
			if(userFloat <= max && userFloat >= min) {
				floatChecker = 1;
			}
			else {
				floatChecker = 0;
				System.out.println("Please enter a valid input.");
			}
			
		}while(floatChecker != 1);
		return userFloat;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a double value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the double value
	 * @throws IOException 
	 */
	static double promptForDouble(String prompt, double min, double max) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		double userDouble = 0;
		int doubleChecker = 1;
		
		do {
			String userAnswer = in.readLine();
			
			try {
			userDouble = Double.parseDouble((userAnswer));
			}
			catch(NumberFormatException ex) {
				userDouble = min - 1;
			}
			
			if(userDouble <= max && userDouble >= min) {
				doubleChecker = 1;
			}
			else {
				doubleChecker = 0;
				System.out.println("Please enter a valid input.");
			}
			
		}while(doubleChecker != 1);
		return userDouble;
	}
	
	/**
	 * Generates a prompt that allows the user to enter any response and returns the String.
	 * When allowEmpty is true, empty responses are valid. When false, responses must contain
	 * at least one character (including whitespace).
	 * @param prompt - the prompt to be displayed to the user.
	 * @param allowEmpty - when true, makes empty responses valid
	 * @return the input from the user as a String
	 * @throws IOException 
	 */
	public static String promptForInput(String prompt, boolean allowEmpty) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		String input = in.readLine();
		
		while(input.length() == 0 && allowEmpty == false) {
			System.out.println("Please enter a valid input.");
			input = in.readLine();
		}
		
		return input;
		
	}
	
	/**
	 * Generates a prompt that expects a single character input representing a char value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the char value
	 * @throws IOException 
	 */
	static char promptForChar(String prompt, char min, char max) throws IOException{
		if(prompt == null) {
			throw new IllegalArgumentException("prompt cannot be null");
		}
		System.out.println(prompt);
		char userChar;
		int charChecker = 1;
		
		do {
			String userAnswer = in.readLine();
			
			try {
			userChar = userAnswer.charAt(0);
			}
			catch(Exception ex) {
				userChar = (char) (min - 1);
			}

			
			if(userChar < max && userChar > min) {
				charChecker = 1;
			}
			else {
				charChecker = 0;
				System.out.println("Please enter a valid input.");
			}
			
		}while(charChecker != 1);
		return userChar;
	}
}
package edu.neumont.csc110.d.drills;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Drills1 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		//drill1CalcBirthYear();
		//drill2Operations();
		//drill3VariableOperations();
		//drill4FloatConversion();
		//drill5Char2Int();
		//drill6Int2Char();
		//drill7Radius2Circumference();
		//drill8FindArea();
		//drill9ThreeVariableSum();
		//drill10MathOpStringCon();
		//drill11EncodeChar();
		//drill12FloatMean();
		//drill13String2Num();
		//drill14IndexOf();
		drill15IndexOfSub();
		//drill16SubAlgorithm();
		//drill17SubProblemSolving();
		//drill18SubCon();
		//drill19SubConProblemSolving();
		//drill20Branching();
		//drill21BranchingBoolean();
		//drill22BranchingBoolean();
		//drill23BranchingNot();
		//drill24BranchingElse();
		//drill25BranchingBlock();
	}
	
	
	private static void drill1CalcBirthYear() throws IOException {
		Calendar now = Calendar.getInstance();
		int age = ConsoleUI.promptForInt("Enter your age:", 0, 999);
		now.add(Calendar.YEAR, -age);
		int birthYear = now.get(Calendar.YEAR);
		System.out.println("Birthyear = " + birthYear);
	}
	
	private static void drill2Operations() throws IOException {
		System.out.println("Please enter an integer:");
		String userInput = in.readLine();
		int userInt = Integer.parseInt(userInput);
		
		int x = userInt + 5;
		int y = x * 3;
		int z = y % 7;
		System.out.println(z);
	}
	
	private static void drill3VariableOperations() throws IOException {
		System.out.println("Please enter an integer:");
		String userInput = in.readLine();
		int userInt = Integer.parseInt(userInput);
		
		int x = userInt + 7;
		int y = userInt - 9;
		int z = x * y;
		System.out.println(z);
	}
	
	private static void drill4FloatConversion() throws IOException {
		System.out.println("Please enter the first integer:");
		String firstUserInput = in.readLine();
		int userFirstInt = Integer.parseInt(firstUserInput);
		System.out.println("Please enter the second integer:");
		String secondUserInput = in.readLine();
		int userSecondInt = Integer.parseInt(secondUserInput);
		
		float x = userFirstInt / userSecondInt;
		float y = (x*x*x);
		float z = (float) (y + Math.PI);
		System.out.println(z);
	}
	
	private static void drill5Char2Int() throws IOException {
		System.out.println("Please enter a character:");
		String userInput = in.readLine();
		char userChar = userInput.charAt(0);
		int userAsciiValue = (int) userChar;
		System.out.println(userAsciiValue);
	}
	
	private static void drill6Int2Char() throws IOException {
		System.out.println("Please enter an integer:");
		String userInput = in.readLine();
		int userInt = Integer.parseInt(userInput);
		char userChar = (char) userInt;
		System.out.println(userChar);
	}
	
	private static void drill7Radius2Circumference() throws IOException {
		System.out.println("Please enter a radius:");
		String userInput = in.readLine();
		double userRadius = Double.parseDouble(userInput);
		double userCircumference = (2*Math.PI*userRadius);
		System.out.println(userCircumference);
	}
	
	private static void drill8FindArea() throws IOException {
		System.out.println("Please enter a height:");
		String userInputH = in.readLine();
		Double userHeight = Double.parseDouble(userInputH);
		System.out.println("Please enter a width:");
		String userInputL = in.readLine();
		Double userLength = Double.parseDouble(userInputL);
		
		Double userArea = (userHeight * userLength);
		System.out.println(userArea);
	}
	
	private static void drill9ThreeVariableSum() throws IOException {
		System.out.println("Please enter the first integer:");
		String userFirstInt = in.readLine();
		int firstInt = Integer.parseInt(userFirstInt);
		System.out.println("Please enter the second integer:");
		String userSecondInt = in.readLine();
		int secondInt = Integer.parseInt(userSecondInt);
		System.out.println("Please enter the third integer:");
		String userThirdInt = in.readLine();
		int thirdInt = Integer.parseInt(userThirdInt);
		
		int userSum = (firstInt + secondInt + thirdInt);
		System.out.println(userSum);
	}
	
	private static void drill10MathOpStringCon() throws IOException {
		System.out.println("Please enter the first integer:");
		String userFirstInt = in.readLine();
		int firstInt = Integer.parseInt(userFirstInt);
		System.out.println("Please enter the second integer:");
		String userSecondInt = in.readLine();
		int secondInt = Integer.parseInt(userSecondInt);
		
		int userSum = firstInt + secondInt;
		int userDifference = firstInt - secondInt;
		int userProduct = firstInt * secondInt;
		int userQuotient = firstInt / secondInt;
		int userMod = firstInt % secondInt;
		
		System.out.println(firstInt + " + " + secondInt + " = " + userSum);
		System.out.println(firstInt + " - " + secondInt + " = " + userDifference);
		System.out.println(firstInt + " * " + secondInt + " = " + userProduct);
		System.out.println(firstInt + " / " + secondInt + " = " + userQuotient);
		System.out.println(firstInt + " % " + secondInt + " = " + userMod);
	}
	
	private static void drill11EncodeChar() throws IOException {
		System.out.println("Please enter a lowercase letter:");
		String userInput = in.readLine();
		String userLowerCaseChar = userInput.toLowerCase();
		char userChar = userLowerCaseChar.charAt(0);
		
		char userEncodedChar;
		if(userChar <= 109) {
			userEncodedChar = (char) (userChar + 13);
		}
		else {
			userEncodedChar = (char) (userChar - 13);
		}
		System.out.println(userEncodedChar);
	}
	
	private static void drill12FloatMean() throws IOException {
		System.out.println("Please enter the first integer:");
		String userFirstInt = in.readLine();
		int firstInt = Integer.parseInt(userFirstInt);
		System.out.println("Please enter the second integer:");
		String userSecondInt = in.readLine();
		int secondInt = Integer.parseInt(userSecondInt);
		System.out.println("Please enter the third integer:");
		String userThirdInt = in.readLine();
		int thirdInt = Integer.parseInt(userThirdInt);
		
		float userMean = (firstInt + secondInt + thirdInt) / 3;
		System.out.println(userMean);
	}
	
	private static void drill13String2Num() throws IOException {
		System.out.println("Please enter a string of numbers:");
		String userInput = in.readLine();
		int userNumbers = Integer.parseInt(userInput);
		int userNumbersPI = (int) (userNumbers / Math.PI);
		String userConversion = Integer.toString(userNumbersPI);
		System.out.println(userConversion.charAt(0));
	}
	
	private static void drill14IndexOf() throws IOException {
		System.out.println("Please enter a string containing a $:");
		String userInput = in.readLine();
		
		char[] inputArray = new char[userInput.length()];
		for(int i=0; i<userInput.length(); i++) {
			inputArray[i] = userInput.charAt(i);
			
			if(inputArray[i] == '$') {
				System.out.println("The $ is located at position: " + i );
			}
		}
		
	}
	
	private static void drill15IndexOfSub() throws IOException {
		System.out.println("Please enter a string containing a $:");
		String userInput = in.readLine();
		
		char[] inputArray = new char[userInput.length()];
		for(int i=0; i<userInput.length(); i++) {
			inputArray[i] = userInput.charAt(i);
			
			if(inputArray[i] == '$') {
				System.out.println(userInput.substring(0,i) + " " + userInput.substring((i+1), userInput.length()));
			}
		}
	}
	
	private static void drill16SubAlgorithm() throws IOException {
		
	}
	
	private static void drill17SubProblemSolving() throws IOException {
		
	}
	
	private static void drill18SubCon() throws IOException {
		System.out.println("Please enter a string containing a $:");
		String userInput = in.readLine();
		
		char[] inputArray = new char[userInput.length()];
		for(int i=0; i<userInput.length(); i++) {
			inputArray[i] = userInput.charAt(i);
			
			if(inputArray[i] == '$') {
				inputArray[i] = userInput.charAt(i+1);
				//System.out.println(inputArray[i] + "$" + userInput.substring(i+1,userInput.length()));
				//System.out.println(userInput.substring(0,(i-1)) + "$" + userInput.substring(i+1, userInput.length()));
				//inputArray[i] = inputArray[i+1];
				//System.out.println(inputArray);
			}	
		}
	}
	
	private static void drill19SubConProblemSolving() throws IOException {
		System.out.println("Please enter your first string:");
		String userFirstString = in.readLine();
		System.out.println("Please enter your second string:");
		String userSecondString = in.readLine();
		
		int middleOfString = userSecondString.length() / 2;
	
		char[] userString = new char[userSecondString.length()];
		for(int i=0; i<userSecondString.length(); i++) {
			userString[i] = userSecondString.charAt(i);
			if(i == middleOfString) {
				System.out.println(userSecondString.substring(0, i) + userFirstString + userSecondString.substring((i), userSecondString.length()));
			}
		}
	}
	
	private static void drill20Branching() throws IOException {
		System.out.println("Please enter your name:");
		String userInput = in.readLine();
		
		if(userInput.equalsIgnoreCase("Fred")) {
			System.out.println("Hello!");
		}
	}
	
	private static void drill21BranchingBoolean() throws IOException {
		System.out.println("Please enter your name:");
		String userInput = in.readLine();
		
		if(userInput.equalsIgnoreCase("Fred") || userInput.equalsIgnoreCase("Barney")) {
			System.out.println("Hello!");
		}
	}
	
	private static void drill22BranchingBoolean() throws IOException {
		System.out.println("Please enter your first name:");
		String userFirstName = in.readLine();
		System.out.println("Please enter your last name:");
		String userLastName = in.readLine();
		
		if(userFirstName.equalsIgnoreCase("Fred") && userLastName.equalsIgnoreCase("Flintstone")) {
			System.out.println("Hello!");
		}
		
	}
	
	private static void drill23BranchingNot() throws IOException {
		System.out.println("Please enter your name:");
		String userInput = in.readLine();
		
		if(!userInput.equalsIgnoreCase("Fred")) {
			System.out.println("Hello!");
		}
	}
	
	private static void drill24BranchingElse() throws IOException {
		System.out.println("Please enter your name:");
		String userInput = in.readLine();
		
		if(userInput.equalsIgnoreCase("Fred")) {
			System.out.println("Hello Fred!");
		}
		else {
			System.out.println("Hello!");
		}
	}
	
	private static void drill25BranchingBlock() throws IOException {
		System.out.println("Please enter your first name:");
		String userFirstName = in.readLine();
		
		if(userFirstName.equalsIgnoreCase("Fred")) {
			System.out.println("Please enter your last name:");
			String userLastName = in.readLine();
			
			System.out.println("Hello " + userFirstName + " " + userLastName + "!"); 
		}
	}
	
}

package edu.neumont.csc110.d.drills3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

public class Drills3 {
	
	//Use in for user input
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	//Use out instead of System.out for output
	public static PrintStream out = System.out;
	
	public static void main(String[] args) throws IOException {
		//Use this method to test your code.
		
//		deepArrayCopy1();
//		stringsAsCharArrays2();
//		stringsAsCharArraysBackwards3();
//		arraySum4();
//		reverseArray5();
//		findAValue6();
//		findAValue7();
//		simpleMethod8();
//		twoMethods9();
//		nestedMethods10();
//		returnValues11();
//		returnValueTypes12();
//		functions13();
//		writeMaxAndMin14();
//		arrayPrintingMethod15();
//		arraySummingMethod16();
//		arrayCopyMethod17();
//		writeArrayReversalMethod18();
//		writeStringReversalMethod19();
//		countLetterOccurrences20();
//		beerOnTheWall21();
//		classifyTriangle22();
//		areaOfARectangle23();
//		volumeOfASphere24();
		binaryNumberString25();
	}
	
	public static void deepArrayCopy1() {
//		a.	Create an array of int
//		b.	Initialize the array with index values (E.g., [0, 1, 2, 3, 4, 5, ...])
//		c.	Copy the array into an Integer array (not int)
//		d.	Modify the first array
//		e.	Print out values
//		f.	Do the same with an Integer array
//		g.	Note that the behavior is different. Explain the difference in a comment
		
		int[] intArray = new int[10];
		
		
	}
	
	public static void stringsAsCharArrays2() throws IOException {
//		a.	Query a string from a user
//		b.	Query a number N from a user
//		c.	Print the Nth char of the string
		
		out.println("Please enter a string:");
		String userString = in.readLine();
		out.println("Please enter a number:");
		String userInput = in.readLine();
		int userNumber = Integer.parseInt(userInput);
		
		out.println(userString.charAt(userNumber));
		
	}
	
	public static void stringsAsCharArraysBackwards3() throws IOException {
//		a.	Query a string from the user
//		b.	Use a char array to print the chars backwards
		System.out.println("Please enter a string:");
		String userInput = in.readLine();
		
		char[] userString = new char[userInput.length()];
		for(int i=0; i<userInput.length(); i++) {
			userString[i] = userInput.charAt(i);
		}
		
		for(int i=userInput.length() -1; i>=0; i--) {
			out.print(userString[i]);
		}
		out.println();

	}
	
	public static void arraySum4() {
//		a.	Create an array of 100 random ints between 0-100
//		b.	Calculate the average value of the array (using floating point arithmetic)
		int[] randomInt = new int[100];
		Random random = new Random();
		int sum = 0;
		
		
		for(int i=0; i<randomInt.length; i++) {
			randomInt[i] = random.nextInt(101);
		}
		
		for(int i=0; i<randomInt.length; i++) {
			sum += randomInt[i];
		}
		int average = sum / 100;
		
		out.println("Average value: " + average);
	}
	
	public static void reverseArray5() {
//		a.	Create an array of 100 random ints between 0-100
//		b.	Print the array
//		c.	Reverse the values so that the value at 0 becomes the value at 99, etc.
//		d.	Print the array
		int[] randomInt = new int[101];
		Random random = new Random();
		
		for(int i=1; i<randomInt.length; i++) {
			randomInt[i] = random.nextInt(101);
			out.println(randomInt[i]);
		}
		System.out.println();
		System.out.println("Reverse:");
		for(int i=randomInt.length - 1; i>=1; i--) {
			randomInt[i] = randomInt[i];
			out.println(randomInt[i]);
		}
		
	}
	
	public static void findAValue6() {
//		a.	Create an array of 100 random ints between 0-100
//		b.	Find the first value greater that 90
//		c.	Print the value and its index index
		int[] randomInt = new int[100];
		Random random = new Random();
		
		for(int i=0; i<randomInt.length; i++) {
			randomInt[i] = random.nextInt(101);
		}
		
		

		for(int i=0; i<randomInt.length; i++) {
			if(randomInt[i] > 90) {
				out.println(randomInt[i] + " at index " + i);
				break;
			}
		}
		
		
		
	}
	
	public static void findAValue7() {
//		a.	Create an array of 100 random ints between 0-100
//		b.	Find the last value greater than 90
//		c.	Print the value and its index
		int[] randomInt = new int[100];
		Random random = new Random();
		
		for(int i=0; i<randomInt.length; i++) {
			randomInt[i] = random.nextInt(101);
		}
		
		

		for(int i=0; i<randomInt.length; i++) {
			if(randomInt[i] > 90) {

			}
		}
	}
	
	public static void simpleMethod8() {
//		a.	Create a method named simpleMethod8_m1 that prints m1
//		b.	Write the code here to call m1
		simpleMethod8_m1();
	}
	
	private static void simpleMethod8_m1() {
		out.println("m1");
	}

	public static void twoMethods9() {
//		a.	Create methods twoMethods9_m1 and twoMethods9_m2 that print out m1 and m2
//		b.	Write the code here to call m1 followed by m2
		twoMethods9_m1();
		twoMethods9_m2();
	}

	private static void twoMethods9_m1() {
		out.println("m1");
	}
	
	private static void twoMethods9_m2() {
		out.println("m2");
	}

	public static void nestedMethods10() {
//		a.	Create methods nestedMethods10_m1, nestedMethods10_ma and nestedMethods10_mb
//		b.	Have method nestedMethods10_m1 call nestedMethods10_ma and nestedMethods10_mb
//		c.	Write the code here to call nestedMethods10_m1
		nestedMethods10_m1();
	}
	
	private static void nestedMethods10_m1() {
		nestedMethods10_ma();
		nestedMethods10_mb();
	}

	private static void nestedMethods10_ma() {	
		
	}

	private static void nestedMethods10_mb() {
		
	}

	public static void returnValues11() {
//		a.	Create a method that returns a constant (final) int
//		b.	Call the method
		returnValues11_final();
	}
	
	private static final int returnValues11_final() {
		final int FINAL_INT = 10;
		return FINAL_INT;
	}

	public static void returnValueTypes12() {
//		a.	Create a method to return an int and another to return a String
//		b.	Call the methods
		returnValueTypes12_int();
		returnValueTypes12_string();
		
	}
	
	private static int returnValueTypes12_int() {
		int int1 = 5;
		return int1;
	}

	private static String returnValueTypes12_string() {
		String string1 = "String";
		return string1;
	}

	public static void functions13() {
//		a.	Create methods to add, subtract, mult and divide
//		b.	Call methods with different parameters
		functions13_add(10, 20);
		functions13_sub(16, 7);
		functions13_mult(5, 5);
		functions13_div(30, 3);
		
		
	}
	
	private static int functions13_add(int int1, int int2) {
		int sum = int1 + int2;
		return sum;
	}

	private static int functions13_sub(int int1, int int2) {
		int diff = int1 + int2;
		return diff;
	}

	private static int functions13_mult(int int1, int int2) {
		int prod = int1 * int2;
		return prod;
	}

	private static int functions13_div(int int1, int int2) {
		int quot = int1 / int2;
		return quot;
	}

	public static void writeMaxAndMin14() {
//		a.	Fill an array with random numbers
//		b.	Find the largest and smallest value in the array and print them out
		int[] array = new int[10];
		Random random = new Random();
		int largestValue = 0;
		int smallestValue = 0;
		for(int i=1; i<array.length; i++) {
			array[i] = random.nextInt(11);
			if(array[i] > array[i - 1]) {
				largestValue = array[i];
			}
			if(array[i] < array[i - 1]) {
				smallestValue = array[i];
			}
		}
		out.println("Largest: " + largestValue);
		out.println("Smallest: " + smallestValue);
		
	}
	
	public static void arrayPrintingMethod15() {
//		a.	Create a program with a method to print an array
//		b.	Call the method on two arrays with different sizes filled with random numbers
		Random random = new Random();
		
		int[] arrayOne = new int[10];
		for(int i=0; i<arrayOne.length; i++) {
			arrayOne[i] = random.nextInt(50);
		}
		
		int[] arrayTwo = new int[30];
		for(int i=0; i<arrayTwo.length; i++) {
			arrayTwo[i] = random.nextInt(50);
		}
		
		arrayPrintingMethod15_printArray(arrayOne);
		arrayPrintingMethod15_printArray(arrayTwo);
		
		
	}
	
	private static void arrayPrintingMethod15_printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			out.print(array[i] + " ");
		}
		out.println();
		
	}

	public static void arraySummingMethod16() {
//		a.	Create a method with an array parameter to sum the array
//		b.	Call the method on two arrays with different sizes filled with random numbers
		Random random = new Random();
		
		int[] arrayOne = new int[10];
		for(int i=0; i<arrayOne.length; i++) {
			arrayOne[i] = random.nextInt(50);
		}
		
		int[] arrayTwo = new int[30];
		for(int i=0; i<arrayTwo.length; i++) {
			arrayTwo[i] = random.nextInt(50);
		}
		
		arraySummingMethod16_sum(arrayOne);
		arraySummingMethod16_sum(arrayTwo);
	}
	
	private static void arraySummingMethod16_sum(int[] array) {
		int sum = 0;
		for(int i=0; i<array.length; i++) {
			sum += array[i];
		}
		out.println(sum);
	}

	public static void arrayCopyMethod17() {
//		a.	Create a program with a method to copy one array into another
//		b.	Call the method and print both arrays
		Random random = new Random();
		
		int[] arrayOne = new int[10];
		for(int i=0; i<arrayOne.length; i++) {
			arrayOne[i] = random.nextInt(50);
		}
		
		
		arrayCopyMethod17_copy(arrayOne);
		
	}
	
	private static void arrayCopyMethod17_copy(int[] array) {
		int[] copyArray = new int[array.length];
		for(int i=0; i<array.length; i++) {
			copyArray[i] = array[i];
		}
		
		for(int i=0; i<array.length; i++) {
			out.print(array[i] + " ");
		}
		out.println();
		for(int i=0; i<copyArray.length; i++) {
			out.print(copyArray[i] + " ");
		}
	}

	public static void writeArrayReversalMethod18() {
//		a.	Create a method with an array parameter to reverse the elements in the array
//		b.	Call the method on two arrays with different sizes filled with random numbers
		Random random = new Random();
		
		int[] arrayOne = new int[10];
		for(int i=0; i<arrayOne.length; i++) {
			arrayOne[i] = random.nextInt(50);
		}
		

		
		int[] arrayTwo = new int[30];
		for(int i=0; i<arrayTwo.length; i++) {
			arrayTwo[i] = random.nextInt(50);
		}
		
		writeArrayReversalMethod18_reverse(arrayOne);
		writeArrayReversalMethod18_reverse(arrayTwo);
	}
	
	private static void writeArrayReversalMethod18_reverse(int[] array) {
		for(int i=array.length - 1; i>=1; i--) {
			array[i] = array[i];
		}

	}

	public static void writeStringReversalMethod19() throws IOException {
//		a.	Create a method with a string parameter that will reverse the string
//		b.	Read two strings, call the method for each
//		c.	Print all four strings
		out.println("Please enter a string:");
		String userString1 = in.readLine();
		
		out.println("Please enter another string:");
		String userString2 = in.readLine();
		
		out.println(userString1);
		out.println(userString2);
		writeStringReversalMethod19_reverse(userString1);
		writeStringReversalMethod19_reverse(userString2);
		
		
	}
	
	private static void writeStringReversalMethod19_reverse(String userString) {
		for(int i=userString.length() - 1; i>=0; i--) {
			out.print(userString.charAt(i));
		}
		out.println();
		
	}

	public static void countLetterOccurrences20() throws IOException {
//		a.	Create a method with a string parameter and a char parameter that counts the number of occurrences of the char in the string and returns the result as an int
//		b.	Read a string and a char, call the method with those parameters
//		c.	Print the results
//		d.	Repeat b & c with a different string and char
		out.println("Please enter a string:");
		String userString = in.readLine();
		
		out.println("Please enter a char:");
		String userC = in.readLine();
		char userChar = userC.charAt(0);
		
		out.println(countLetterOccurences20_count(userString, userChar));
		
		
	}
	
	private static int countLetterOccurences20_count(String userString, char userChar) {
		int userCount = 0;
		for(int i=0; i<userString.length(); i++) {
			if(userString.charAt(i) == userChar) {
				userCount++;
			}
		}
		return userCount;
	}

	public static void beerOnTheWall21() {
//		a.  Write the code to to print ALL the lyrics to “99 bottles of beer (or pop)”
		final int BOTTLES_OF_BEER = 99;
		for(int i=BOTTLES_OF_BEER; i>0;) {
			out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
			i--;
			out.println("Take one down, pass it around, " + i + " bottles of beer on the wall.");
		}
		
	}
	
	public static void classifyTriangle22() {
//		a.	Write a method to classify a triangle.
//		b.  The method receives three parameters representing the three sides of a triangle.  The method returns an enum: Equilateral, Isosceles, Scalene
		out.println(whichTriangle(10, 10, 10));
	}
	
	enum TriangleType {
		isosceles,
		equilateral,
		scalene
	}
	
	private static TriangleType whichTriangle(int s1, int s2, int s3) {
		if(s1 == s2 && s2 == s3) {
			return TriangleType.equilateral;
		}
		else if(s1 == s2 || s2 == s3 || s1 == s3) {
			return TriangleType.isosceles;
		}
		else {
			return TriangleType.scalene;
		}
	}
	public static void areaOfARectangle23() throws IOException {
//		a.	Create a method that calculates the area of a rectangle and returns it (floating point arithmetic)
//		b.	Read a length and a width from the user, call the method with those as parameters, print out the result
		out.println("Please enter a length:");
		String userL = in.readLine();
		double userLength = Double.parseDouble(userL);
		
		out.println("Please enter a width:");
		String userW = in.readLine();
		double userWidth = Double.parseDouble(userW);
		
		out.println(areaOfARectangle23_area(userLength, userWidth));
		
	}
	
	private static double areaOfARectangle23_area(double userLength, double userWidth) {
		double userArea = userLength * userWidth;
		return userArea;
		
	}

	public static void volumeOfASphere24() throws IOException {
//		a.	Create a method that calculates the volume of a sphere given the radius
//		b.	Read a radius from the user, call the method with the radius
//		c.	Print the returned value
		out.println("Please enter a radius:");
		String userInput = in.readLine();
		double userRadius = Double.parseDouble(userInput);
		out.println(volumeOfASphere24_volume(userRadius));
	}
	
	private static double volumeOfASphere24_volume(double userRadius) {
		double userVolume;
		userVolume = (userRadius * userRadius * userRadius) * (3.14);
		userVolume = userVolume * 4/3;
		return userVolume;
	}

	public static void binaryNumberString25() throws IOException {
//		a.	Read a int greater than 100 from the user
//		b.	Convert the int to the equivalent string of binary digits and print it out
//		i.	For example given the number 128, print the string “10000000”
		out.println("Please enter an integer greater than 100:");
		String userInput = in.readLine();
		int userInt = Integer.parseInt(userInput);
		boolean validInput = false;
		
		do {
			if(userInt <= 100){
				out.println("Please enter a valid input.");
				userInput = in.readLine();
				userInt = Integer.parseInt(userInput);
			}
			else {
				out.println(Integer.toBinaryString(userInt));
				validInput = true;
			}
		}while(validInput == false);
		
	}

}
package edu.neumont.csc110.d.consoleio;

import java.io.IOException;

public class ConsoleUITester {

	public static void main(String[] args) throws IOException {
		//String[] menu = {"test", "check", "try"};
		//System.out.println(ConsoleUI.promptForMenuSelection(menu, false));
		//System.out.println(ConsoleUI.promptForBool("Yes or No?", "Yes", "No"));
		//System.out.println(ConsoleUI.promptForByte("Please enter a byte amount from -127 to 126 ", (byte) -128, (byte) 127));
		//System.out.println(ConsoleUI.promptForShort("Please enter a short amount from 1 to 1000", (short) 0, (short) 1001));
		//System.out.println(ConsoleUI.promptForInt("Please enter an integer amount from -3000 to 3000", -3001, 3001));
		//System.out.println(ConsoleUI.promptForLong("Please enter a long amount from -10000 to 10000 ", (long) -10001, (long) 10001));
		//System.out.println(ConsoleUI.promptForFloat("Please enter a number from 1 to 10", (float) 0, (float) 11));
		//System.out.println(ConsoleUI.promptForDouble("Please enter a number from 1 to 100", (double) 0, (double) 101));
		System.out.println(ConsoleUI.promptForInput("Please enter anything", false));
		//System.out.println(ConsoleUI.promptForChar("Please enter a char between A and z", 'A', 'z'));
		
	}

}

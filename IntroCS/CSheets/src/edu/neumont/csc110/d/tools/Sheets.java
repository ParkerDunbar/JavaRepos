package edu.neumont.csc110.d.tools;

import java.io.IOException;

import edu.neumont.csc110.d.consoleio.ConsoleUI;

public class Sheets {

	public static void main(String[] args) throws IOException {
		final int ROW_SIZE = 4;
		final int COL_SIZE = 4;
		int[][] array = new int[ROW_SIZE][COL_SIZE];
		
		printArray(array);
		boolean isAdding = true;
		while(isAdding) {
			int row = ConsoleUI.promptForInt("Enter the row", 0, ROW_SIZE - 1);
			int col = ConsoleUI.promptForInt("Enter the col", 0, COL_SIZE - 1);
			int value = ConsoleUI.promptForInt("What value?", 0, 9);
			array[row][col] = value;
			printArray(array);
			isAdding = !ConsoleUI.promptForBool("Done? Yes/No", "Yes", "No");
		}
		
	}
	
	private static void printArray(int[][] array) {
		int[] sums = new int[array[0].length];
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		for(int i=0; i<array.length; i++) {
			System.out.print("--");
		}
		System.out.println();
		
		
		for(int i=0; i<array[0].length; i++) {
			for(int j=0; j<array.length; j++) {
				sums[i] += array[j][i];
			}
			System.out.print(sums[i] + " ");
		}
		
		System.out.println();
		
		for(int i=0; i<array.length; i++) {
			System.out.print("--");
		}
		System.out.println();
		
		for(int i=0; i<sums.length; i++) {
			System.out.print((float) sums[i] / array[0].length + " "); 
		}
		System.out.println();
	}

}

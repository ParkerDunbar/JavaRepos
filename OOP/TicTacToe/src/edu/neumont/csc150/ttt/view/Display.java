package edu.neumont.csc150.ttt.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import edu.neumont.csc150.ttt.controller.Gameplay;


public class Display {
		
	private BufferedReader in = null;
	
	public Display() {
		Reader read = new InputStreamReader(System.in);
		in = new BufferedReader(read);
	}
	
	/**
	 * prints out the current board
	 */
	public void printBoard() {
		for(int i=0;i<Gameplay.getBoard().square.length;i++) {
			for(int j=0;j<Gameplay.getBoard().square.length;j++) {
				
				if(Gameplay.getBoard().square[i][j].isAvailable()) {
					System.out.print("* ");
				}
				else if(Gameplay.getBoard().square[i][j].getPlayer() == Gameplay.oplayer){
					System.out.print("O ");
				}
				else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}
	
	
	/**
	 * displays welcome message
	 */
	public void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe");
		
	}

	/**
	 * 
	 * @return returns the selected row by the user
	 * @throws IOException
	 */
	public int selectRow() throws IOException {
		String userRowInput = "";
		int userRow = 0;
		boolean isGoodRow = false;
		System.out.println("Please enter a row between 0-2");
		while(!isGoodRow) {
			userRowInput = in.readLine();
			try {
				userRow = Integer.parseInt(userRowInput);
			}
			catch(NumberFormatException ex) {
				userRow = -1;
			}
			if(userRow < 0 || userRow > 2) {
				System.out.println("Only select a row between 0-2");
			}
			else {
				isGoodRow = true;
			}
		}
		return userRow;
	}

	/**
	 * 
	 * @return returns the selected column by the user
	 * @throws IOException
	 */
	public int selectCol() throws IOException {
		String userColInput = "";
		int userCol = 0;
		boolean isGoodCol = false;
		System.out.println("Please enter a column between 0-2");
		while(!isGoodCol) {
			userColInput = in.readLine();
			try {
				userCol = Integer.parseInt(userColInput);
			}
			catch(NumberFormatException ex) {
				userCol = -1;
			}
			if(userCol < 0 || userCol > 2) {
				System.out.println("Only select a column between 0-2");
			}
			else {
				isGoodCol = true;
			}
		}
		return userCol;
		
	}
	
	/**
	 * displays the current players turn
	 */
	public void displayPlayerTurn() {
		System.out.println("It is Player " + Gameplay.whoseTurnIsIt.getWhoAmI() + "'s turn.");
		
	}
	/**
	 * displays if the space is already taken
	 */
	public void displaySpaceTaken() {
		System.out.println("That space is already taken!");
		
	}

	/**
	 * displays the winner of the game
	 */
	public void displayWinner() {
		System.out.println("Player " + Gameplay.whoseTurnIsIt.getWhoAmI() + " is the winner!");
		
	}
	
	/**
	 * displays goodbye message
	 */
	public void displayGoodbyeMessage() {
		System.out.println("Bye! Thanks for playing!");
		
	}
	
	/**
	 * 
	 * @return whether the player wants to reset
	 * @throws IOException 
	 */
	public boolean promptForReset() throws IOException {
		boolean isGoodInput = false;
		boolean reset = false;
		String userInput = "";
		System.out.println("Would you like to play again? Yes/No");
		while(!isGoodInput) {
			userInput = in.readLine();
			if(userInput.matches("Yes")) {
				reset = false;
				isGoodInput = true;
			}
			else if(userInput.matches("No")) {
				reset = true;
				isGoodInput = true;
			}
			else {
				System.out.println("Please select an answer.");
			}
		}
		
		
		return reset;
		
		
	}
}

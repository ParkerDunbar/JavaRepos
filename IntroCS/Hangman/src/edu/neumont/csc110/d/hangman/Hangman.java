package edu.neumont.csc110.d.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hangman {
	
	static char[] guessedLetters = new char[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean restartGame = true;

		do {
			int bodyParts = 0;
			String userPuzzle = ConsoleUI.promptForInput("Please enter your Puzzle!", false);
			String userValidPuzzle = checkIfPuzzleIsValid(userPuzzle);
			for (int i = 0; i < 15; i++) {
				System.out.println();
			}
			String userMaskedPuzzle = maskUserPuzzle(userValidPuzzle);
			String userPuzzleGuessed;

			
			do {
				String userCharGuessed = userMaskedPuzzle;
				restartGame = hangmanBodyParts(bodyParts);
				String[] menu = { "0 = Guess", "1 = Solve", "2 = Quit" };
				for (int i = 0; i < menu.length; i++) {
					System.out.println(menu[i]);
				}
				
				
				
				int userOption = ConsoleUI.promptForInt("Please select an option:", -1, 3);

				if (userOption == 0) {
					
					userPuzzleGuessed = userPuzzleGuess(userValidPuzzle, userCharGuessed);
					if(userPuzzleGuessed.equals("Invalid")) {
						System.out.println(userMaskedPuzzle);
						bodyParts++;
						if(bodyParts == 6) {
							restartGame = false;
						}
						
					}
					else {
						System.out.println(userPuzzleGuessed);
					}
					
					
				} else if (userOption == 1) {
					int userPuzzleSolution = userPuzzleSolve(userValidPuzzle);
					if (userPuzzleSolution == 1) {
						System.out.println("You guessed correctly.");
						restartGame = false;
						bodyParts = 6;
					} else {
						System.out.println("You guessed incorrectly.");
						restartGame = false;
						bodyParts = 6;
						restartGame = hangmanBodyParts(bodyParts);
					}

					
					
				} else if (userOption == 2) {
					System.out.println("You have surrendered.");
					restartGame = false;
					bodyParts = 6;
					restartGame = hangmanBodyParts(bodyParts);
				}

			} while (bodyParts != 6 || restartGame == true);

			
			System.out.println("Would you like to play again?");
			System.out.println("0 = Yes");
			System.out.println("1 = No");
			int userRestartChoice = ConsoleUI.promptForInt("Please select an option:", -1, 2);
			
			if(userRestartChoice == 0) {
				restartGame = true;
			}
			else {
				restartGame = false;
			}
			
		} while (restartGame == true);

		System.out.println("Thank you for playing!");

	}

	public static String checkIfPuzzleIsValid(String userPuzzle) throws IOException {
		String[] validPuzzle;
		String userPuzzleUpperCase = null;
		boolean ifPuzzleIsValid;
		validPuzzle = userPuzzle.split(" ");

		do {

			if (validPuzzle.length > 8) {
				userPuzzle = ConsoleUI.promptForInput("Please only enter a puzzle between 1 and 8 words.", false);
				validPuzzle = userPuzzle.split(" ");
				ifPuzzleIsValid = false;
			} else {
				userPuzzleUpperCase = userPuzzle.toUpperCase();
				ifPuzzleIsValid = true;
			}

		} while (ifPuzzleIsValid == false);

		return userPuzzleUpperCase;

	}

	public static String maskUserPuzzle(String userValidPuzzle) {
		String userMaskedPuzzle = "";
		char[] userCharArray = new char[userValidPuzzle.length()];
		for (int i = 0; i < userValidPuzzle.length(); i++) {
			userCharArray[i] = userValidPuzzle.charAt(i);
			if (userCharArray[i] != ' ') {
				userCharArray[i] = '_';
			}
		}
		for (int i = 0; i < userValidPuzzle.length(); i++) {
			System.out.print(userCharArray[i] + " ");
			userMaskedPuzzle += new String(userCharArray[i] + " ");
		}

		System.out.println();
		// userMaskedPuzzle = new String(userCharArray);

		return userMaskedPuzzle;
	}

	public static String userPuzzleGuess(String userValidPuzzle, String userMaskedPuzzle) throws IOException {
		char userGuess = ConsoleUI.promptForChar("Please enter your guess:", 'A', 'z');
		char userGuessUpperCase = charToUpperCase(userGuess);
		String charPuzzleGuess = "";
		String incorrectGuessString = "Invalid";
		int checkIfIncorrectGuess = 0;
		
		char[] userCharArray = new char[userValidPuzzle.length()];
		char[] userMaskedArray = new char[userMaskedPuzzle.length()];
		for (int i = 0; i < userValidPuzzle.length(); i++) {
			userCharArray[i] = userValidPuzzle.charAt(i);
			userMaskedArray[i] = userMaskedPuzzle.charAt(i);
				
				if (userGuessUpperCase == userCharArray[i]) {
					userMaskedArray[i] = userGuessUpperCase;
				} 
				else if (userGuessUpperCase != userCharArray[i]) {
					userMaskedArray[i] = '_';
					checkIfIncorrectGuess++;
				}
				
				if(checkIfIncorrectGuess == userValidPuzzle.length()) {
					return incorrectGuessString; 
				}
			
			charPuzzleGuess += new String(userMaskedArray[i] + " ");
		}
		
		
		return charPuzzleGuess;

	}

	public static int userPuzzleSolve(String userValidPuzzle) throws IOException {
		int userValidSolution;
		String userSolve = ConsoleUI.promptForInput("Please solve the puzzle:", false);
		String userSolveUpperCase = userSolve.toUpperCase();
		if (userValidPuzzle.equals(userSolveUpperCase)) {
			userValidSolution = 1;
		} else {
			userValidSolution = 0;
		}

		return userValidSolution;
	}

	public static char charToUpperCase(char userChar) {
		char userUpperCaseChar = 0;
		if (userChar <= 122 && userChar >= 97) {
			userUpperCaseChar = (char) (userChar - 32);
		} else {
			userUpperCaseChar = userChar;
		}
		userLettersAlreadyGuessed(userUpperCaseChar);
		
		return userUpperCaseChar;
	}
	public static boolean hangmanBodyParts(int bodyParts) {
		Boolean restartGame = true;
		if(bodyParts == 0) {
			System.out.println("Your hangman has a:");
			restartGame = true;
		}
		else if(bodyParts == 1){
			System.out.println("Your hangman has a: Head");
			restartGame = true;
		}
		else if(bodyParts == 2) {
			System.out.println("Your hangman has a: Head, Torso");
			restartGame = true;
		}
		else if(bodyParts == 3) {
			System.out.println("Your hangman has a: Head, Torso, Left Arm");
			restartGame = true;
		}
		else if(bodyParts == 4){
			System.out.println("Your hangman has a: Head, Torso, Left Arm, Right Arm");
			restartGame = true;
		}
		else if(bodyParts == 5) {
			System.out.println("Your hangman has a: Head, Torso, Left Arm, Right Arm, Left Leg");
			restartGame = true;
		}
		else if(bodyParts == 6) {
			System.out.println("Your hangman has a: Head, Torso, Left Arm, Right Arm, Left Leg, Right Leg");
			restartGame = false;
		}
		return restartGame;	
		
	}
	
	public static void userLettersAlreadyGuessed(char userGuess) {
		
		for(int i=0; i<26; i++) {
			
		}
		
		System.out.println("Letters you have already guessed: " );
	}
}

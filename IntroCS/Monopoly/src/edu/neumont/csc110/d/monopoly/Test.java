package edu.neumont.csc110.d.monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	static Dice dice = new Dice();
	static BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
	public static void main(String args[]) throws IOException {
		
		//System.out.println(Dice.diceRollSum());
		
		/*int menuCheck;
		do {
			menuCheck = 0;
			System.out.println("What would you like to do?");
			System.out.println("1 Buy property ($60)");
			System.out.println("2 Auction off property");
		
			String input = in.readLine();
			
			try {
				int choice = Integer.parseInt(input);
		
		
				if(choice == 1){
					System.out.println("Option 1");
					//Player.Player[playerNumber][20]=1;
					//bank.buyAProperty(playerNumber, 60, 60);
				}
				
				else if(choice == 2) {
					System.out.println("Option 2");
					//Player.auction();
				}
				
				else{
					menuCheck = 1;
					System.out.println("Please enter a valid input.");
				}
		
				
			}
			catch(NumberFormatException ex) {
				menuCheck = 1;
				System.out.println("Please enter a valid input.");
			}
			
		}while(menuCheck == 1);*/
	}
}

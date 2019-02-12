package edu.neumont.csc110.d.memory;

import java.io.IOException;

import edu.neumont.csc110.d.consoleio.ConsoleUI;

public class Memory {

	public static void main(String[] args) throws IOException {
		Dealer d = new Dealer();
		d.createCards();
		
		boolean keepPlaying = true;
		while(keepPlaying) {
			d.shuffle();
			d.dealCards();
			d.runGame();
			ConsoleUI.promptForBool("Do you want to play again (Y/N)", "Y", "N");
		}
	}

}

package edu.neumont.csc110.d.memory;

import java.io.IOException;
import java.util.Random;

import edu.neumont.csc110.d.consoleio.ConsoleUI;

public class Dealer {
	public Card[] cards;
	String[] messages = { "Apple", "Orange", "Peach", "Pear", "Mango", "Tomato", "Avacado", "Carrot" };
	Random r = new Random();

	public void createCards() {
		cards = new Card[messages.length * 2];
		for (int i = 0; i < cards.length; i += 2) {
			cards[i] = new Card();
			cards[i].message = messages[i / 2];
			cards[i + 1] = new Card();
			cards[i + 1].message = messages[i / 2];

		}
	}

	public void printCards(boolean showAll) {
		for (int i = 0; i < cards.length; i++) {
			System.out.print(i + " ");
			if (cards[i].shown || showAll) {
				System.out.println(cards[i].message);
			} else {
				System.out.println("?");
			}
		}
	}

	public void shuffle() {
		for (int i = 0; i < 100; i++) {
			int randomIndex = r.nextInt(cards.length);
			int randomIndex2 = r.nextInt(cards.length);
			Card savedOffCard = cards[randomIndex];
			cards[randomIndex] = cards[randomIndex2];
			cards[randomIndex2] = savedOffCard;

		}

	}

	public void dealCards() {

	}

	public void runGame() throws IOException {

		while (!isGameOver()) {
			printCards(false);

			int firstCardIndex = pickCard("Pick first card");
			cards[firstCardIndex].flip();
			printCards(false);

			int secondCardIndex = pickCard("Pick second card");
			cards[secondCardIndex].flip();
			printCards(false);

			if (!cards[firstCardIndex].equals(cards[secondCardIndex])) {
				cards[firstCardIndex].flip();
				cards[secondCardIndex].flip();
				System.out.println("No match!");
			} else {
				cards[firstCardIndex].matched = true;
				cards[firstCardIndex].matched = true;
				System.out.println("You got a match!");
			}

			ConsoleUI.promptForInput("Press enter to continue", true);
		}
		System.out.println("Game Over");
	}

	public boolean isGameOver() {
		for (Card card : cards) {
			if (!card.matched) {
				return false;
			}
		}
		return true;
	}

	public int pickCard(String prompt) throws IOException {

		int index = -1;
		while (index == -1) {
			index = ConsoleUI.promptForInt(prompt, 0, cards.length - 1);
			if (cards[index].shown) {
				System.out.println("Hey Lame-O, pick one that's not turned over.");
				index = -1;
			}
		}
		return index;
	}
}

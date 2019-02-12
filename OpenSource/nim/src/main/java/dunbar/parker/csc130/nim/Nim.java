package dunbar.parker.csc130.nim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nim {
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static int Player = 2;
	public static int heap1 = 3;
	public static int heap2 = 4;
	public static int heap3 = 5;

	public static void main(String args[]) throws IOException {

		while (checkWin()) {
			nextplayer();
			System.out.println(heap1);
			System.out.println(heap2);
			System.out.println(heap3);

			System.out.println("Pick a row/heap");
			String input = in.readLine();
			int rowNumber = Integer.parseInt(input);

			if (rowNumber == 1 || rowNumber == 2 || rowNumber == 3) {
				switch (rowNumber) {
				case 1:
					heap1 = remove(heap1);
					break;
				case 2:
					heap2 = remove(heap2);
					break;
				case 3:
					heap3 = remove(heap3);
					break;
				}
			} else {
				System.out.println("Invalid row number.");
			}

		}

	}

	private static boolean checkWin() {
		if (heap1 + heap2 + heap3 == 0) {
			System.out.println("Player " + Player + " has won!");
			return false;
		}
		return true;
	}

	private static void nextplayer() {
		if (Player == 1) {
			Player = 2;
		} else if (Player == 2) {
			Player = 1;
		}
		System.out.println("It is Player " + Player + "'s turn");
	}

	private static int remove(int heap) throws IOException {
		System.out.println("How many would you like to take?");
		String removeInput = in.readLine();
		int remove = Integer.parseInt(removeInput);
		int newHeap = 0;
		boolean validAmount = false;

		while (validAmount == false) {
			if (remove > heap || remove < 0) {
				System.out.println("Please select a valid amount.");
			} else {
				newHeap = heap - remove;
				validAmount = true;
			}
		}
		return newHeap;
	}
}

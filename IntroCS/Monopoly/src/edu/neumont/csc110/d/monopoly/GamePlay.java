package edu.neumont.csc110.d.monopoly;

import java.io.IOException;

public class GamePlay {

	public void play() throws IOException {
		Jail j = new Jail();
		boolean someoneHasWon = false;
		int playersNotBankrupt = 0;
		// Get Number of Players
		Player.Num_Player();
		do {
			if (Player.Player[Player.P][9] == 0) {
				Display.GameDisplay();
				if (Player.Player[Player.P][7] == 0) {
					GameBoard.MovePlayer();
				} 
			else if (Player.Player[Player.P][7] == 1) {
					Display.inJail();
					Player.Player[Player.P][13] += 1;
					if (Player.Player[Player.P][13] == 3) {
						j.getOutByPaying(Player.P);
						Player.Player[Player.P][7] = 0;
						Player.Player[Player.P][13] = 0;
					}
				}
				Player.switchPlayer();
			}
			for (int i = 0; i < Player.Player_Num; i++) {
				if (Player.Player[i][9] == 0) {
					playersNotBankrupt += 1;
				}
			}
			if (playersNotBankrupt > 1) {
				playersNotBankrupt = 0;
			} else if (playersNotBankrupt == 1) {
				for (int i = 0; i < Player.Player_Num; i++) {
					if (Player.Player[i][9] == 0) {
						System.out.println(
								"Player " + (i + 1) + " has won the game! Congratulations, Player " + (i + 1) + "!");
						someoneHasWon = true;
					}
				}
			} else {
				System.out.println("Something's gone wrong. It's a tie.");
				someoneHasWon = true;
			}
		} while (someoneHasWon == false);

		// Move spaces

		//

	}
}

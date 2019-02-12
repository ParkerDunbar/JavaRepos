package edu.neumont.csc110.d.monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static int Player_Num = 8;
	public static long[][] Player = new long[Player_Num][100];
	public static int[] housesOnEachProperty = new int[48];
	public static boolean initilized = false;
	public static int playerWhoBought = 10;
	public static int P = 0;

	public static long[][] inti_Player() {
		Banker B = new Banker();
		for (int i = 0; i < Player.length; i++) {
			for (int j = 0; j < Player[0].length; j++) {
				Player[i][j] = 0;
			}
		}

		for (int i = 0; i < Player_Num; i++) {
			B.startingMoney(i);
		}

		return Player;

	}

	public static void Num_Player() throws IOException { // try catch
		boolean truth = false;
		do {
			do {
				truth = false;
				try {
					System.out.println("How many players? (2-8)");
					String Input = in.readLine();
					Player_Num = Integer.parseInt(Input);
					truth = true;
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid input.");
					// Num_Player();// need a better way to loop this
				}
			} while (!truth);

			truth = false;
			if (Player_Num < 2) {
				System.out.println("Need at least 2 players. \n ");
				// better way
			} else if (Player_Num > 8) {
				System.out.println("Too many players. \n  ");
			} else {
				truth = true;
			}
		} while (!truth);

		inti_Player(); // ?????
		// System.out.print("Player " + i);
		PlaPiece();
	}

	public static void PlaPiece() throws IOException {
		String[] Piece = { "Scottish Terrier ", "Battleship", "Automobile", "Top Hat", "Thimble", "Shoe",
				"Wheelbarrow", "Cat" };
		for (int y = 0; y < Player_Num; y++) {
			boolean hasChosen = false;
			System.out.println("Player " + (P + 1) + " Pick Your Piece ");
			for (int i = 0; i < Piece.length; i++) {
				System.out.println((i + 1) + " " + Piece[i]);
			}
			while (hasChosen == false) {
				try {
					String Player_Pick = in.readLine();
					int Player_Piece = Integer.parseInt(Player_Pick);
					boolean choseWrong = false;
					for (int i = 0; i < Player_Num; i++) {
						if (Player[i][0] == Player_Piece) {
							System.out.println(" Taken ");
							// loop with out changing player
							choseWrong = true;
						}
					}
					if (Player[P][0] == 0 && choseWrong == false) {
						Player[P][0] = Player_Piece;
						hasChosen = true;
						// change Player then loop
						P++;
					}

					// loop tell all players have picked there piece
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid input.");
				}
			}
		}
		P = 0;
	}

	private static void initHouse() {
		for (int i = 0; i < 48; i++) {
			housesOnEachProperty[i] = 0;
		}
		initilized = true;
	}

	public static void house(int playerNum, int propertyNumber, int houseValue, int amountBuying) {
		Banker bank = new Banker();
		if (!initilized) {
			initHouse();
		}
		int b = housesOnEachProperty[propertyNumber];
		housesOnEachProperty[propertyNumber] += amountBuying;
		int h = housesOnEachProperty[propertyNumber];
		if (h > 5) {
			System.out.println("Invalid amount");
			housesOnEachProperty[propertyNumber] = b;
		} else if (h == 5) {
			bank.buyHotels(playerNum, 1, houseValue);
			Player[playerNum][4] -= b;
			Banker.Houses += b;
		} else if (h < 4) {
			bank.buyHouses(playerNum, amountBuying, houseValue);
		}
	}

	public static void auction(int worthOfProperty, int propertyNumber) throws IOException {
		Banker bank = new Banker();
		int bid = 10;
		boolean done = false;
		boolean bidOn = false;
		int theirBid = 0;
		long money = 0;
		System.out.println("Bidding starts at $10.");
		do {
			System.out.println("Player number? type '9' if everyone is done bidding");
			String rawPlayerNum = in.readLine();
			String rawBid = "5";
			done = false;
			try {
				int playerNum = Integer.parseInt(rawPlayerNum) - 1;
				if (playerNum == 8 && bidOn == true) {
					bank.buyAProperty(playerWhoBought, worthOfProperty, bid);
					Player[playerWhoBought][propertyNumber] = 1;
					done = true;
				} else{
					System.out.println("bid amount?");
					rawBid = in.readLine();
					theirBid = Integer.parseInt(rawBid);
					money = Player[playerNum][2];
				}
				if (money < theirBid && done == false) {
					System.out.println("Too little money");
				} else if (bid >= theirBid && done == false) {
					System.out.println("Your bid's too low");
				} else if (playerNum == 8 && bidOn == false && done == false) {
					System.out.println("No one bid yet!");
				} else {
					playerWhoBought = playerNum;
					bid = theirBid;
					bidOn = true;
				}
			} catch (NumberFormatException ex) {
			}
		} while (done == false);

	}
	public static void switchPlayer(){
		if(P<Player_Num-1){
			P++;}
			else if(P==Player_Num-1){P=0;}
	}
}

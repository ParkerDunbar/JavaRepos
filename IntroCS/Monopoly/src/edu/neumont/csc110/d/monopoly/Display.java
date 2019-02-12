package edu.neumont.csc110.d.monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Display {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	Player Plr = new Player();
	static Banker bank = new Banker();
	static String[] OwnedProps = new String[28];

	public static void GameDisplay() throws IOException {
		int Money = (int) Player.Player[Player.P][2];
		bank.bankrupt(Player.P);
		String Jail = JailCheck();
		String Spot = location();
		String Pice = Piece();
		OwnedProps = Prop();

		do {
			System.out.println("\nPlayer " + (Player.P + 1) + " " + Pice);
			System.out.println("\nMoney: $" + Money + "\n");
			System.out.println("Owned Propertys + Houses/Hotels:");
			House();
			System.out.println("\nSpot on board: \n" + Spot);
			while (Player.Player[Player.P][2] < 0) {
				if (Player.Player[Player.P][10] < 1) {
					Player.Player[Player.P][2] = 0;
					Player.Player[Player.P][9] = 1;
				}
				Mortgage();
			}
			if (Player.Player[Player.P][7] == 1) {
				System.out.println(Jail + "For " + Player.Player[Player.P][13] + " Turns");
			}
			if (Player.Player[Player.P][6] > 0) {
				System.out.println("You have " + Player.Player[Player.P][6] + " Get out of jail free cards");
			}

			System.out.println("Press Enter to Roll the Dice or buy to buy a house");
			String choice = in.readLine();
			boolean chosen = false;
			if (choice.equalsIgnoreCase("buy")) {
				while (chosen == false) {
					Buying_House();
					chosen = true;
				}
			}

			/*
			 * try { String Y_N = in.readLine(); if (Y_N.equalsIgnoreCase("Y"))
			 * { Dice.diceRollSum(); } else if (Y_N.equalsIgnoreCase("N")) { //
			 * ???? } } catch (Exception e) { System.out.println(" Catch "); }
			 */

		} while (Player.P == 8);
	}

	public static void inJail() throws IOException {
		Jail j = new Jail();
		boolean hasChosen = false;
		while (!hasChosen) {
			System.out.println(
					"What would you like to do? 1 to roll, 2 to get out of jail by paying, 3 to get out of jail by using a Get Out of Jail Free card.");
			String choice = in.readLine();
			if (choice.equalsIgnoreCase("1")) {
				Dice.diceRollSum();
				j.getOutByDoubles(Player.P);
				if (Dice.diceRollIsDouble()) {
					System.out.println("You got out of jail!");
					GameBoard.MovePlayer();
				}
				hasChosen = true;
			} else if (choice.equalsIgnoreCase("2")) {
				j.getOutByPaying(Player.P);
				System.out.println("You got out of jail!");
				GameBoard.MovePlayer();
				hasChosen = true;
			} else if (choice.equalsIgnoreCase("3")) {
				if (Player.Player[Player.P][6] > 0) {
					System.out.println("You got out of jail!");
					j.getOutByCard(Player.P);
					GameBoard.MovePlayer();
					hasChosen = true;
				}
			} else {
				System.out.println("Invalid response");
			}
		}
	}

	public static String[] Prop() {
		String[] Props = { " Mediterranean Avenue ", "Baltic Avenue ", "Reading Railroad ", "Oriental Avenue ",
				"Vermont Avenue ", "Connecticut Avenue  ", "St Charles Place ", "Electric Company ", "States Avenue ",
				"Virgina Avenue ", "Pennsylvania Railroad ", "St James Place  ", "Tennessee Avenue ",
				"New York Avenue ", "Kentucky Avenue ", "Indiana Avenue ", "Illinois Avenue ", "BO Railroad ",
				"Atlantic Avenue ", "Ventnor Avenue ", "Water Works ", "Marvin Gardens ", "Pacific Avenue ",
				"North Carolina Avenue ", "Pennsylvania Avenue ", "Short Line Railroad ", "Park Place ",
				"Board Walk " };
		String[] Print = new String[29];
		for (int i = 0; i <= Props.length; i++) {
			Print[i] = "";
		}
		for (int t = 0; t <= Props.length; t++) {
			if (Player.Player[Player.P][t + 20] == 1) {
				Print[t] = Props[t];
			}
		}
		return Print;
	}

	public static void Buying_House() throws IOException {
		boolean Like_to = false;
		boolean Where = false;
		boolean Many = false;
		do {
			try {

				System.out.println(" Would you like to buy a house \n Y/N ");
				String Y_N = in.readLine();
				if (Y_N.equalsIgnoreCase("y")) {
					do {
						for (int i = 0; i < 28; i++) {
							System.out.println((i + 1) + " For " + GameBoard.Propertiress.values()[i] + ", ");
						}
						System.out.println(" Where would like to build or type quit to quit");
						String Bld = in.readLine();

						int Build = Integer.parseInt(Bld);
						if (Player.Player[Player.P][Build + 19] == 1) {

							do {

								System.out.println(" How many houses would like 1-5/ 5 = Hotel ");
								String H_Numb = in.readLine();
								int Houses_wanted = Integer.parseInt(H_Numb);
								if (Houses_wanted > 0 && Houses_wanted < 6) {
									Player.housesOnEachProperty[Build + 20] += Houses_wanted;
									if (Player.housesOnEachProperty[Build + 20] >= 5) {
										System.out.println("Too many houses on the property ");
										Many = true;
									} else {
										bank.buyHouses(Player.P, Houses_wanted, 50);
									}

								} else {
									System.out.println(" Thats too many houses ");
									Many = true;
								}

							} while (Many == true);

						} else {
							System.out.println("You dont own the propertiess ");
							Where = true;
						}

					} while (Where == true);

				}
				if (Y_N.equalsIgnoreCase("N")) {

				} else {
					System.out.println(" Please enter Y or N ");
					Like_to = true;
				}
			} catch (NumberFormatException E) {
				Like_to = false;
				break;
			}
		} while (Like_to == true);// loop

	}

	public static void House() {
		for (int i = 20; i < 48; i++) {
			if (Player.Player[Player.P][i] == 1) {
				if (Player.housesOnEachProperty[i] == 0) {
					System.out.print(OwnedProps[i - 20] + "");
				} else if (Player.housesOnEachProperty[i] == 1) {
					System.out.print(OwnedProps[i - 20] + "1" + "-House, ");
				} else if (Player.housesOnEachProperty[i] < 5) {
					System.out.print(OwnedProps[i - 20] + Player.housesOnEachProperty[i] + "-Houses, ");
				} else {
					System.out.print(OwnedProps[i - 20] + "1" + "-Hotel, ");
				}
			}
		}

	}

	public static String JailCheck() {
		String InJail = " ";
		if (Player.Player[Player.P][7] == 1) {
			InJail = " IN JAIL ";
		}

		return InJail;
	}

	public static void unMortgage() throws IOException {
		boolean chosen = false;
		while (!chosen) {
			chosen = true;
			System.out.println("Please unMortgage a property. Press ");
			for (int i = 0; i < 28; i++) {
				System.out.println((i + 1) + " For " + GameBoard.Propertiress.values()[i] + ", ");
			}
			System.out.println("Please make sure you own it. And it's currently unMortgaged. ");
			String choice = in.readLine();
			if (choice.equals("1") && Properties.MAM && Player.Player[Player.P][20] == 1) {
				bank.unMortgage(Player.P, Properties.voBr);
				Properties.MAM = false;
			} else if (choice.equals("2") && Properties.BAM && Player.Player[Player.P][21] == 1) {
				bank.unMortgage(Player.P, Properties.voBr);
				Properties.BAM = false;
			} else if (choice.equals("3") && Properties.RRM && Player.Player[Player.P][22] == 1) {
				bank.unMortgage(Player.P, Properties.voRr);
				Properties.RRM = false;
			} else if (choice.equals("4") && Properties.OAM && Player.Player[Player.P][23] == 1) {
				bank.unMortgage(Player.P, Properties.voLbe);
				Properties.OAM = false;
			} else if (choice.equals("5") && Properties.VAM && Player.Player[Player.P][24] == 1) {
				bank.unMortgage(Player.P, Properties.voLbe);
				Properties.VAM = false;
			} else if (choice.equals("6") && Properties.CAM && Player.Player[Player.P][25] == 1) {
				bank.unMortgage(Player.P, Properties.voLbl);
				Properties.CAM = false;
			} else if (choice.equals("7") && Properties.SCM && Player.Player[Player.P][26] == 1) {
				bank.unMortgage(Player.P, Properties.voLpe);
				Properties.SCM = false;
			} else if (choice.equals("8") && Properties.ECM && Player.Player[Player.P][27] == 1) {
				bank.unMortgage(Player.P, Properties.voUlt);
				Properties.ECM = false;
			} else if (choice.equals("9") && Properties.SAM && Player.Player[Player.P][28] == 1) {
				bank.unMortgage(Player.P, Properties.voLpe);
				Properties.SAM = false;
			} else if (choice.equals("10") && Properties.ViM && Player.Player[Player.P][29] == 1) {
				bank.unMortgage(Player.P, Properties.voLpl);
				Properties.ViM = false;
			} else if (choice.equals("11") && Properties.PRM && Player.Player[Player.P][30] == 1) {
				bank.unMortgage(Player.P, Properties.voRr);
				Properties.PRM = false;
			} else if (choice.equals("12") && Properties.SJM && Player.Player[Player.P][31] == 1) {
				bank.unMortgage(Player.P, Properties.voOre);
				Properties.SJM = false;
			} else if (choice.equals("13") && Properties.TAM && Player.Player[Player.P][32] == 1) {
				bank.unMortgage(Player.P, Properties.voOre);
				Properties.TAM = false;
			} else if (choice.equals("14") && Properties.NYM && Player.Player[Player.P][33] == 1) {
				bank.unMortgage(Player.P, Properties.voOrl);
				Properties.NYM = false;
			} else if (choice.equals("15") && Properties.KAM && Player.Player[Player.P][34] == 1) {
				bank.unMortgage(Player.P, Properties.voRee);
				Properties.KAM = false;
			} else if (choice.equals("16") && Properties.IAM && Player.Player[Player.P][35] == 1) {
				bank.unMortgage(Player.P, Properties.voRee);
				Properties.IAM = false;
			} else if (choice.equals("17") && Properties.IlM && Player.Player[Player.P][36] == 1) {
				bank.unMortgage(Player.P, Properties.voRel);
				Properties.IlM = false;
			} else if (choice.equals("18") && Properties.BOM && Player.Player[Player.P][37] == 1) {
				bank.unMortgage(Player.P, Properties.voRr);
				Properties.BOM = false;
			} else if (choice.equals("19") && Properties.AAM && Player.Player[Player.P][38] == 1) {
				bank.unMortgage(Player.P, Properties.voYee);
				Properties.AAM = false;
			} else if (choice.equals("20") && Properties.VeM && Player.Player[Player.P][39] == 1) {
				bank.unMortgage(Player.P, Properties.voYee);
				Properties.VeM = false;
			} else if (choice.equals("21") && Properties.WWM && Player.Player[Player.P][40] == 1) {
				bank.unMortgage(Player.P, Properties.voUlt);
				Properties.WWM = false;
			} else if (choice.equals("22") && Properties.MGM && Player.Player[Player.P][41] == 1) {
				bank.unMortgage(Player.P, Properties.voYel);
				Properties.MGM = false;
			} else if (choice.equals("23") && Properties.PAM && Player.Player[Player.P][42] == 1) {
				bank.unMortgage(Player.P, Properties.voGre);
				Properties.PAM = false;
			} else if (choice.equals("24") && Properties.NCM && Player.Player[Player.P][43] == 1) {
				bank.unMortgage(Player.P, Properties.voGre);
				Properties.NCM = false;
			} else if (choice.equals("25") && Properties.PeM && Player.Player[Player.P][44] == 1) {
				bank.unMortgage(Player.P, Properties.voGrl);
				Properties.PeM = false;
			} else if (choice.equals("26") && Properties.SLM && Player.Player[Player.P][45] == 1) {
				bank.unMortgage(Player.P, Properties.voRr);
				Properties.SLM = false;
			} else if (choice.equals("27") && Properties.PPM && Player.Player[Player.P][46] == 1) {
				bank.unMortgage(Player.P, Properties.voBle);
				Properties.PPM = false;
			} else if (choice.equals("28") && Properties.BwM && Player.Player[Player.P][47] == 1) {
				bank.unMortgage(Player.P, Properties.voBll);
				Properties.BwM = false;
			} else {
				System.out.println("Invalid Input");
				chosen = false;
			}
		}
	}

	public static void Mortgage() throws IOException {
		boolean chosen = false;
		while (!chosen) {
			chosen = true;
			System.out.println("Please Mortgage a property. Press ");
			for (int i = 1; i < 28; i++) {
				System.out.println((i + 1) + " For " + GameBoard.Propertiress.values()[i] + ", ");
			}
			System.out.println("Please make sure you own it. And it's currently unMortgaged.");
			String choice = in.readLine();
			if (choice.equals("1") && !Properties.MAM && Player.Player[Player.P][20] == 1) {
				bank.mortgage(Player.P, Properties.voBr);
				Properties.MAM = true;
			} else if (choice.equals("2") && !Properties.BAM && Player.Player[Player.P][21] == 1) {
				bank.mortgage(Player.P, Properties.voBr);
				Properties.BAM = true;
			} else if (choice.equals("3") && !Properties.RRM && Player.Player[Player.P][22] == 1) {
				bank.mortgage(Player.P, Properties.voRr);
				Properties.RRM = true;
			} else if (choice.equals("4") && !Properties.OAM && Player.Player[Player.P][23] == 1) {
				bank.mortgage(Player.P, Properties.voLbe);
				Properties.OAM = true;
			} else if (choice.equals("5") && !Properties.VAM && Player.Player[Player.P][24] == 1) {
				bank.mortgage(Player.P, Properties.voLbe);
				Properties.VAM = true;
			} else if (choice.equals("6") && !Properties.CAM && Player.Player[Player.P][25] == 1) {
				bank.mortgage(Player.P, Properties.voLbl);
				Properties.CAM = true;
			} else if (choice.equals("7") && !Properties.SCM && Player.Player[Player.P][26] == 1) {
				bank.mortgage(Player.P, Properties.voLpe);
				Properties.SCM = true;
			} else if (choice.equals("8") && !Properties.ECM && Player.Player[Player.P][27] == 1) {
				bank.mortgage(Player.P, Properties.voUlt);
				Properties.ECM = true;
			} else if (choice.equals("9") && !Properties.SAM && Player.Player[Player.P][28] == 1) {
				bank.mortgage(Player.P, Properties.voLpe);
				Properties.SAM = true;
			} else if (choice.equals("10") && !Properties.ViM && Player.Player[Player.P][29] == 1) {
				bank.mortgage(Player.P, Properties.voLpl);
				Properties.ViM = true;
			} else if (choice.equals("11") && !Properties.PRM && Player.Player[Player.P][30] == 1) {
				bank.mortgage(Player.P, Properties.voRr);
				Properties.PRM = true;
			} else if (choice.equals("12") && !Properties.SJM && Player.Player[Player.P][31] == 1) {
				bank.mortgage(Player.P, Properties.voOre);
				Properties.SJM = true;
			} else if (choice.equals("13") && !Properties.TAM && Player.Player[Player.P][32] == 1) {
				bank.mortgage(Player.P, Properties.voOre);
				Properties.TAM = true;
			} else if (choice.equals("14") && !Properties.NYM && Player.Player[Player.P][33] == 1) {
				bank.mortgage(Player.P, Properties.voOrl);
				Properties.NYM = true;
			} else if (choice.equals("15") && !Properties.KAM && Player.Player[Player.P][34] == 1) {
				bank.mortgage(Player.P, Properties.voRee);
				Properties.KAM = true;
			} else if (choice.equals("16") && !Properties.IAM && Player.Player[Player.P][35] == 1) {
				bank.mortgage(Player.P, Properties.voRee);
				Properties.IAM = true;
			} else if (choice.equals("17") && !Properties.IlM && Player.Player[Player.P][36] == 1) {
				bank.mortgage(Player.P, Properties.voRel);
				Properties.IlM = true;
			} else if (choice.equals("18") && !Properties.BOM && Player.Player[Player.P][37] == 1) {
				bank.mortgage(Player.P, Properties.voRr);
				Properties.BOM = true;
			} else if (choice.equals("19") && !Properties.AAM && Player.Player[Player.P][38] == 1) {
				bank.mortgage(Player.P, Properties.voYee);
				Properties.AAM = true;
			} else if (choice.equals("20") && !Properties.VeM && Player.Player[Player.P][39] == 1) {
				bank.mortgage(Player.P, Properties.voYee);
				Properties.VeM = true;
			} else if (choice.equals("21") && !Properties.WWM && Player.Player[Player.P][40] == 1) {
				bank.mortgage(Player.P, Properties.voUlt);
				Properties.WWM = true;
			} else if (choice.equals("22") && !Properties.MGM && Player.Player[Player.P][41] == 1) {
				bank.mortgage(Player.P, Properties.voYel);
				Properties.MGM = true;
			} else if (choice.equals("23") && !Properties.PAM && Player.Player[Player.P][42] == 1) {
				bank.mortgage(Player.P, Properties.voGre);
				Properties.PAM = true;
			} else if (choice.equals("24") && !Properties.NCM && Player.Player[Player.P][43] == 1) {
				bank.mortgage(Player.P, Properties.voGre);
				Properties.NCM = true;
			} else if (choice.equals("25") && !Properties.PeM && Player.Player[Player.P][44] == 1) {
				bank.mortgage(Player.P, Properties.voGrl);
				Properties.PeM = true;
			} else if (choice.equals("26") && !Properties.SLM && Player.Player[Player.P][45] == 1) {
				bank.mortgage(Player.P, Properties.voRr);
				Properties.SLM = true;
			} else if (choice.equals("27") && !Properties.PPM && Player.Player[Player.P][46] == 1) {
				bank.mortgage(Player.P, Properties.voBle);
				Properties.PPM = true;
			} else if (choice.equals("28") && !Properties.BwM && Player.Player[Player.P][47] == 1) {
				bank.mortgage(Player.P, Properties.voBll);
				Properties.BwM = true;
			} else {
				System.out.println("Invalid Input");
				chosen = false;
			}
		}
	}

	public static String location() {
		if (Player.Player[Player.P][1] == 0) {//
			return "Go";
		}
		if (Player.Player[Player.P][1] == 1) {//
			return " Mediterranean Avenue";
		}
		if (Player.Player[Player.P][1] == 2 || Player.Player[Player.P][1] == 17 || Player.Player[Player.P][1] == 36) {// Chest//
			return " Communtiy Chest";
		}
		if (Player.Player[Player.P][1] == 3) {//
			return " Baltic Avenue";
		}
		if (Player.Player[Player.P][1] == 4) {//
			return " Income Tax";
		}
		if (Player.Player[Player.P][1] == 5) {
			return " Reading Railroad";
		}
		if (Player.Player[Player.P][1] == 6) {
			return " Oriental Avenue";
		}
		if (Player.Player[Player.P][1] == 7 || Player.Player[Player.P][1] == 22 || Player.Player[Player.P][1] == 36) {// Chance
			return " Chance";
		}
		if (Player.Player[Player.P][1] == 8) {
			return " Vermont Avenue";
		}
		if (Player.Player[Player.P][1] == 9) {
			return " Connecticut Avenue";
		}
		if (Player.Player[Player.P][1] == 10) {
			return " Just Visiting";
		}
		if (Player.Player[Player.P][1] == 11) {
			return " ST.Charles Place";
		}
		if (Player.Player[Player.P][1] == 12) {
			return " Electric Company";
		}
		if (Player.Player[Player.P][1] == 13) {
			return " States Avenue";
		}
		if (Player.Player[Player.P][1] == 14) {
			return " Virginia Avenue";
		}
		if (Player.Player[Player.P][1] == 15) {
			return " Pennsylvania Railroad";
		}
		if (Player.Player[Player.P][1] == 16) {
			return " ST.James Place";
		}
		if (Player.Player[Player.P][1] == 19) {
			return " Tennessee Avenue";
		}
		if (Player.Player[Player.P][1] == 20) {
			return " New York Avenue";
		}
		if (Player.Player[Player.P][1] == 21) {
			return " Free Parking";
		}
		if (Player.Player[Player.P][1] == 22) {
			return " Kentucky Avenue";
		}
		if (Player.Player[Player.P][1] == 23) {
			return " Indiana Avenue";
		}
		if (Player.Player[Player.P][1] == 24) {
			return " Illinois Avenue";
		}
		if (Player.Player[Player.P][1] == 25) {
			return " B&O Railroad";
		}
		if (Player.Player[Player.P][1] == 26) {
			return " Atlanic Avenue";
		}
		if (Player.Player[Player.P][1] == 27) {
			return " Ventnor Avenue";
		}
		if (Player.Player[Player.P][1] == 28) {
			return " Water Works";
		}
		if (Player.Player[Player.P][1] == 29) {
			return " Marivin Gardens";
		}
		if (Player.Player[Player.P][1] == 30) {
			return " Go to Jail";
		}
		if (Player.Player[Player.P][1] == 31) {
			return " Pacific Avenue";
		}
		if (Player.Player[Player.P][1] == 32) {
			return " North Carolina Avenue";
		}
		if (Player.Player[Player.P][1] == 34) {
			return " Pennsylvania Avenue";
		}
		if (Player.Player[Player.P][1] == 35) {
			return " Short Line ";
		}
		if (Player.Player[Player.P][1] == 37) {
			return " Park Place";
		}
		if (Player.Player[Player.P][1] == 38) {
			return " Luxury Tax";
		}
		if (Player.Player[Player.P][1] == 39) {
			return " Boardwalk";
		}

		return " ";

	}

	public static String Piece() {
		String[] Piece = { "Scottish Terrier ", "Battleship", "Automobile", "Top Hat", "Thimble", "Shoe", "Wheelbarrow",
				"Cat" };
		for (int i = 0; i < Piece.length; i++) {
			if (Player.Player[Player.P][0] == (i + 1)) {
				return Piece[i];
			}
		}

		return "";
	}

	public static void Trade() throws IOException {
		boolean Like = false;
		boolean Players = false;
		boolean Own = false;
		boolean TradeOwn = false;
		do {
			System.out.println("Would you like to trade a property \n Y/N");
			String Yes_No = in.readLine();
			if (Yes_No.equalsIgnoreCase("Y")) {
				do {
					try {
						System.out.println(" Who would you like to trade with ");
						String TradePlayer = in.readLine();
						int Trade_Player = Integer.parseInt(TradePlayer);
						if (Trade_Player > 0 && Trade_Player < Player.Player_Num) {
							do {
								System.out.println("What Prop do you want to trade ");
								try {

									String Prop = in.readLine();
									int PProper = Integer.parseInt(Prop);
									if (Player.Player[Player.P][PProper + 20] == 1) {
										do {
											System.out.println(" What Prop do you want ");
											String TProp = in.readLine();
											int TradeP_Prop = Integer.parseInt(TProp);
											if (Player.Player[Trade_Player][TradeP_Prop + 20] == 1) {
												Player.Player[Player.P][PProper + 20] = Player.Player[Trade_Player][TradeP_Prop + 20];
											} else {
												System.out.println("Thay dont own that ");
												TradeOwn = true;
											}
										} while (TradeOwn == true);
									} else {
										System.out.println(" You dont own that ");
										Own = true;
									}

								} catch (NumberFormatException E) {
									System.out.println(" Please Enter a Number ");
								}
							} while (Own == true);
						} else {
							System.out.println("Enter a valid Player ");
							Players = true;
						}

					} catch (NumberFormatException E) {
						System.out.println(" Please Enter A Number ");
						Players = true;
					}
				} while (Players == true);
			}
			if (Yes_No.equalsIgnoreCase("N")) {

			} else {
				System.out.println("Please enter Y or N");
				Like = true;
			}
		} while (Like == true);
	}
}

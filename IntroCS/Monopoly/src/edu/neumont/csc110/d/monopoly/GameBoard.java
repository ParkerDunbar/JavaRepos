package edu.neumont.csc110.d.monopoly;

import java.io.IOException;

public class GameBoard {
	public int[] Board;

	// public long[][] Player;
	Player Plr = new Player();
	static Properties Prop = new Properties();
	static Jail Jail = new Jail();
	static Banker Bank = new Banker();

	public enum Propertires {
		Go, Mediterranean, Chest, Baltic, Income_Tax, Reading_RR, Oriental, Chance, Vermont, Connecticut, Visiting, ST_Charles, Electric_Co, States, Virginia, Pennsylvania_RR, ST_James, Chest2, Tennessee, New_York, Free_Parking, Kentucky, Chance2, Indiana, Illinois, BO_RR, Atlantic, Ventnor, Water_Works, Marvin, Go_To_Jail, Pacific, North_Carolina, Chest3, Pennsylvania, Sort_Line_RR, Chance3, Park, Luxury_Tax, Boardwalk
	}
	public enum Propertiress {
		Mediterranean, Baltic, Reading_RR, Oriental, Vermont, Connecticut, ST_Charles, Electric_Co, States, Virginia, Pennsylvania_RR, ST_James, Tennessee, New_York, Kentucky, Indiana, Illinois, BO_RR, Atlantic, Ventnor, Water_Works, Marvin, Pacific, North_Carolina, Pennsylvania, Sort_Line_RR, Park, Boardwalk
	}

	public void gameboard() {
		Board = new int[40];

	}

	public static void MovePlayer() throws IOException {
		int Space = (int) Player.Player[Player.P][1];
		int Move = Dice.diceRollSum(); // Dice
		System.out.println("You've rolled a " + Move);
		Space = Move + Space;
		if(Dice.diceRollIsDouble()){Jail.toJailAfterOneDouble(Player.P);}
		if (Space > 39) {
			Space -= 40;
			Player.Player[Player.P][1] = Space;
			Proper();
		} else if (Space > 0) {
			Player.Player[Player.P][1] = Space;
			System.out.println();
			Proper();
		}

	}

	public static void Proper() throws IOException {
		Banker bank = new Banker();
		Propertires Place = Propertires.values()[(int)Player.Player[Player.P][1]];
		switch (Place) {
		case Go:
			bank.passGo(Player.P);
			System.out.println("You've landed on Go");
			break;
		case Mediterranean:
			System.out.println("You've landed on Mediterranean avenue");
			Prop.mediterraneanAvenue(Player.P);
			break;
		case Chest:
			System.out.println("You've landed on Community Chest");
			Chest.CommunityChest(Player.P,Player.Player_Num);
			break;
		case Baltic:
			System.out.println("You've landed on Baltic Avenue");
			Prop.balticAvenue(Player.P);
			break;
		case Income_Tax:
			System.out.println("You've landed on Income Tax");
			Bank.incomeTax(Player.P);
			break;
		case Reading_RR:
			System.out.println("You've landed on Reading Railroad");
			Prop.readingRailroad(Player.P);
			break;
		case Vermont:
			System.out.println("You've landed on Vermont Avenue");
			Prop.vermontAvenue(Player.P);
			break;
		case Oriental:
			System.out.println("You've landed on Oriental Avenue");
			Prop.orientalAvenue(Player.P);
			break;
		case Chance:
			System.out.println("You've landed on Chance");
			Chance.ChanceCard(Player.P,Player.Player_Num);
			break;
		case Connecticut:
			System.out.println("You've landed on Connecticut Avenue");
			Prop.connecticutAvenue(Player.P);
			break;
		case Visiting:
			System.out.println("You've landed on Just Visiting");
			break;
		case ST_Charles:
			System.out.println("You've landed on St. Charles Place");
			Prop.stCharlesPlace(Player.P);
			break;
		case Electric_Co:
			System.out.println("You've landed on Electric Company");
			Prop.electricCompany(Player.P);
			break;
		case States:
			System.out.println("You've landed on States Avenue");
			Prop.statesAvenue(Player.P);
			break;
		case Virginia:
			System.out.println("You've landed on Virginia Avenue");
			Prop.virginiaAvenue(Player.P);
			break;
		case Pennsylvania_RR:
			System.out.println("You've landed on Pennsylvania Railroad");
			Prop.pennsylvaniaRailroad(Player.P);
			break;
		case ST_James:
			System.out.println("You've landed on St. James Place");
			Prop.stJamesPlace(Player.P);
			break;
		case Chest2:
			System.out.println("You've landed on Community Chest");
			Chest.CommunityChest(Player.P,Player.Player_Num);
			break;
		case Tennessee:
			System.out.println("You've landed on Tennessee Avenue");
			Prop.tennesseeAvenue(Player.P);
			break;
		case New_York:
			System.out.println("You've landed on New York Avenue");
			Prop.newYorkAvenue(Player.P);
			break;
		case Free_Parking:
			System.out.println("You've landed on Free Parking");
			break;
		case Kentucky:
			System.out.println("You've landed on Kentuky Avenue");
			Prop.kentuckyAvenue(Player.P);
			break;
		case Chance2:
			System.out.println("You've landed on Chance");
			Chance.ChanceCard(Player.P,Player.Player_Num);
			break;
		case Indiana:
			System.out.println("You've landed on Indiana");
			Prop.indianaAvenue(Player.P);
			break;
		case Illinois:
			System.out.println("You've landed on Illinois");
			Prop.illinoisAvenue(Player.P);
			break;
		case BO_RR:
			System.out.println("You've landed on B&O Railroad");
			Prop.bAndORailroad(Player.P);
			break;
		case Atlantic:
			System.out.println("You've landed on Altlantic Avenue");
			Prop.atlanticAvenue(Player.P);
			break;
		case Ventnor:
			System.out.println("You've landed on Ventnor Avenue");
			Prop.ventnorAvenue(Player.P);
			break;
		case Water_Works:
			System.out.println("You've landed on Water Works");
			Prop.waterWorks(Player.P);
			break;
		case Marvin:
			System.out.println("You've landed on Marvin Gardens");
			Prop.marvinGardens(Player.P);
			break;
		case Go_To_Jail:
			System.out.println("You're going to jail!");
			Jail.toJailByGoToJail(Player.P);
			break;
		case Pacific:
			System.out.println("You've landed on Pacific Avenue");
			Prop.pacificAvenue(Player.P);
			break;
		case North_Carolina:
			System.out.println("You've landed on North Carolina Avenue");
			Prop.northCarolinaAvenue(Player.P);
			break;
		case Chest3:
			System.out.println("You've landed on Community Chest");
			Chest.CommunityChest(Player.P,Player.Player_Num);
			break;
		case Pennsylvania:
			System.out.println("You've landed on Pennsylvania Avenue");
			Prop.pennsylvaniaAvenue(Player.P);
			break;
		case Sort_Line_RR:
			System.out.println("You've landed on Short Line Railroad");
			Prop.shortLine(Player.P);
			break;
		case Chance3:
			System.out.println("You've landed on Chance");
			Chance.ChanceCard(Player.P,Player.Player_Num);
			break;
		case Park:
			System.out.println("You've landed on Park Place");
			Prop.parkPlace(Player.P);
			break;
		case Luxury_Tax:
			System.out.println("You've landed on Luxury Tax");
			Bank.luxuryTax(Player.P);
			break;
		case Boardwalk:
			System.out.println("You've landed on Boardwalk");
			Prop.boardwalk(Player.P);
			break;

		}

	}

}


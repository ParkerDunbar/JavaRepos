package edu.neumont.csc110.d.monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Properties {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	boolean aPlayerOwns = false;
	public static final int voBr = 30;
	public static final int voLbe = 50;
	public static final int voLbl = 60;
	public static final int voLpe = 70;
	public static final int voUlt = 75;
	public static final int voLpl = 80;
	public static final int voOre = 90;
	public static final int voOrl = 100;
	public static final int voRr = 100;
	public static final int voRee = 110;
	public static final int voRel = 120;
	public static final int voYee = 130;
	public static final int voYel = 140;
	public static final int voGre = 150;
	public static final int voGrl = 160;
	public static final int voBle = 175;
	public static final int voBll = 200;
	
	public static boolean MAM = false;
	public static boolean BAM = false;
	public static boolean RRM = false;
	public static boolean OAM = false;
	public static boolean VAM = false;
	public static boolean CAM = false;
	public static boolean SCM = false;
	public static boolean ECM = false;
	public static boolean SAM = false;
	public static boolean ViM = false;
	public static boolean PRM = false;
	public static boolean SJM = false;
	public static boolean TAM = false;
	public static boolean NYM = false;
	public static boolean KAM = false;
	public static boolean IAM = false;
	public static boolean IlM = false;
	public static boolean BOM = false;
	public static boolean AAM = false;
	public static boolean VeM = false;
	public static boolean WWM = false;
	public static boolean MGM = false;
	public static boolean PAM = false;
	public static boolean NCM = false;
	public static boolean PeM = false;
	public static boolean SLM = false;
	public static boolean PPM = false;
	public static boolean BwM = false;
	//Rent
	//Monopoly Rent Conditions
	//Property values
	//Cost

	//20 - Brown
	public void mediterraneanAvenue(int playerNumber) throws IOException {
		//Cost $60
		//Mortgage $30
		//Houses $50 each
		//Hotels $50 each
		
		//Rent $2
		//Monopoly Rent $4
		//1 House $10
		//2 House $30
		//3 House $90
		//4 House $160
		//1 Hotel $250
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns=10;
		int rent = 2;
		int menuCheck = 0;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][20] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][20] == 1 && Player.Player[playerWhoOwns][21] == 1 && Player.housesOnEachProperty[20] == 0) {
				rent *= 2;
			}
			if(Player.housesOnEachProperty[20] == 1) {
				rent = 10;
			}
			if(Player.housesOnEachProperty[20] == 2) {
				rent = 30;
			}
			if(Player.housesOnEachProperty[20] == 3) {
				rent = 90;
			}
			if(Player.housesOnEachProperty[20] == 4) {
				rent = 160;
			}
			if(Player.housesOnEachProperty[20] == 5) {
				rent = 250;
			}

			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($60)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][20] = 1;
						bank.buyAProperty(playerNumber, 60, 60);
					}
					
					else if(choice == 2) {
						Player.auction(60, 20);
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
				
			}while(menuCheck == 1);
		}


	}
	//21 - Brown
	public void balticAvenue(int playerNumber) throws IOException {
		//Cost $60
		//Mortgage $30
		//Houses $50 each
		//Hotels $50 each
		
		//Rent $4
		//Monopoly Rent $8
		//1 House $20
		//2 House $60
		//3 House $180
		//4 House $320
		//1 Hotel $450
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 4;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][21] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][20] == 1 && Player.Player[playerWhoOwns][21] == 1 && Player.housesOnEachProperty[21] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[21] == 1) {
				rent = 20;
			}
			if(Player.housesOnEachProperty[21] == 2) {
				rent = 60;
			}
			if(Player.housesOnEachProperty[21] == 3) {
				rent = 180;
			}
			if(Player.housesOnEachProperty[21] == 4) {
				rent = 320;
			}
			if(Player.housesOnEachProperty[21] == 5) {
				rent = 450;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($60)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][21] = 1;
						bank.buyAProperty(playerNumber, 60, 60);
					}
					
					else if(choice == 2) {
						Player.auction(60, 21);
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
				
			}while(menuCheck == 1);
		}

	}
	//22 - Railroad
	public void readingRailroad(int playerNumber) throws IOException {
		//Cost $200
		//Mortgage $100
		
		//Rents
		//1 Railroad $25
		//2 Railroad $50
		//3 Railroad $100
		//4 Railroad $200
		Banker bank = new Banker();
		int playerWhoOwns = 10;
		int rent = 0;
		int menuCheck;
		aPlayerOwns = false;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][11] >= 1 && Player.Player[i][22] == 1){
				playerWhoOwns = i;
				rent = 25;
				aPlayerOwns = true;
				if(Player.Player[i][11] >= 2){
					playerWhoOwns = i;
					rent = 50;
					if(Player.Player[i][11] >= 3){
						playerWhoOwns = i;
						rent = 100;
						if(Player.Player[i][11] >= 4){
							playerWhoOwns = i;
							rent = 200;
							}
						}
					}
				bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
				System.out.println("You've paid the rent for this space.");
				}
		}
			
			
			if(aPlayerOwns == false){
				
				do {
					menuCheck = 0;
					System.out.println("What would you like to do?");
					System.out.println("1 Buy railroad ($200)");
					System.out.println("2 Auction off property");
				
					String input = in.readLine();
					
					try {
						int choice = Integer.parseInt(input);
				
				
						if(choice == 1){
							Player.Player[playerNumber][22] = 1;
							Player.Player[playerNumber][11] += 1;
							bank.buyAProperty(playerNumber, 200, 200);
						}
						
						else if(choice == 2) {
							Player.auction(200, 22);
							Player.Player[Player.playerWhoBought][11]+=1;
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
					
				}while(menuCheck == 1);
			}
			
		
		
		

	}
	//23 - Light Blue
	public void orientalAvenue(int playerNumber) throws IOException {
		//Cost $100
		//Mortgage $50
		//Houses $50 each
		//Hotels $50 each
		
		//Rent $6
		//Monopoly Rent $12
		//1 House $30
		//2 House $90
		//3 House $270
		//4 House $400
		//1 Hotel $550
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 6;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][23] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][23] == 1 && Player.Player[playerWhoOwns][24] == 1 && Player.Player[playerWhoOwns][25] == 1 && Player.housesOnEachProperty[23] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[23] == 1) {
				rent = 30;
			}
			if(Player.housesOnEachProperty[23] == 2) {
				rent = 90;
			}
			if(Player.housesOnEachProperty[23] == 3) {
				rent = 270;
			}
			if(Player.housesOnEachProperty[23] == 4) {
				rent = 400;
			}
			if(Player.housesOnEachProperty[23] == 5) {
				rent = 550;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($100)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][23] = 1;
						bank.buyAProperty(playerNumber, 100, 100);
					}
					
					else if(choice == 2) {
						Player.auction(100, 23);
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
				
			}while(menuCheck == 1);
		}

	}
	//24 - Light Blue
	public void vermontAvenue(int playerNumber) throws IOException {
		//Cost $100
		//Mortgage $50
		//Houses $50 each
		//Hotels $50 each
		
		//Rent $6
		//Monopoly Rent $12
		//1 House $30
		//2 House $90
		//3 House $270
		//4 House $400
		//1 Hotel $550
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 6;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][24] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][23] == 1 && Player.Player[playerWhoOwns][24] == 1 && Player.Player[playerWhoOwns][25] == 1 && Player.housesOnEachProperty[24] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[24] == 1) {
				rent = 30;
			}
			if(Player.housesOnEachProperty[24] == 2) {
				rent = 90;
			}
			if(Player.housesOnEachProperty[24] == 3) {
				rent = 270;
			}
			if(Player.housesOnEachProperty[24] == 4) {
				rent = 400;
			}
			if(Player.housesOnEachProperty[24] == 5) {
				rent = 550;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($100)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][24] = 1;
						bank.buyAProperty(playerNumber, 100, 100);
					}
					
					else if(choice == 2) {
						Player.auction(100, 24);
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
				
			}while(menuCheck == 1);
		}

	}
	//25 - Light Blue
	public void connecticutAvenue(int playerNumber) throws IOException {
		//Cost $120
		//Mortgage $60
		//Houses $50 each
		//Hotels $50 each
		
		//Rent $8
		//Monopoly Rent $16
		//1 House $40
		//2 House $100
		//3 House $300
		//4 House $450
		//1 Hotel $600
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 8;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][25] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][23] == 1 && Player.Player[playerWhoOwns][24] == 1 && Player.Player[playerWhoOwns][25] == 1 && Player.housesOnEachProperty[25] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[25] == 1) {
				rent = 40;
			}
			if(Player.housesOnEachProperty[25] == 2) {
				rent = 100;
			}
			if(Player.housesOnEachProperty[25] == 3) {
				rent = 300;
			}
			if(Player.housesOnEachProperty[25] == 4) {
				rent = 450;
			}
			if(Player.housesOnEachProperty[25] == 5) {
				rent = 600;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($120)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][25] = 1;
						bank.buyAProperty(playerNumber, 120, 120);
					}
					
					else if(choice == 2) {
						Player.auction(120, 25);
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
				
			}while(menuCheck == 1);
		}

		
	}
	//26 - Pink
	public void stCharlesPlace(int playerNumber) throws IOException {
		//Cost $140
		//Mortgage $70
		//Houses $100 each
		//Hotels $100 each
		
		//Rent $10
		//Monopoly Rent $20
		//1 House $50
		//2 House $150
		//3 House $450
		//4 House $625
		//1 Hotel $750
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 10;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][26] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][26] == 1 && Player.Player[playerWhoOwns][28] == 1 && Player.Player[playerWhoOwns][29] == 1 && Player.housesOnEachProperty[26] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[26] == 1) {
				rent = 50;
			}
			if(Player.housesOnEachProperty[26] == 2) {
				rent = 150;
			}
			if(Player.housesOnEachProperty[26] == 3) {
				rent = 450;
			}
			if(Player.housesOnEachProperty[26] == 4) {
				rent = 625;
			}
			if(Player.housesOnEachProperty[26] == 5) {
				rent = 750;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($140)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][26] = 1;
						bank.buyAProperty(playerNumber, 140, 140);
					}
					
					else if(choice == 2) {
						Player.auction(140, 26);
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
				
			}while(menuCheck == 1);
		}
	}
	//27 - Utility
	public void electricCompany(int playerNumber) throws IOException {
		//Cost $150
		//Mortgage $75
		
		//Rents
		//1 Owned $4 x DiceRoll
		//2 Owned $10 x DiceRoll
		Banker bank = new Banker();
		int playerWhoOwns = 10;
		int rent = 0;
		int menuCheck;
		aPlayerOwns = false;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][12] >= 1 && Player.Player[i][27] == 1){
				aPlayerOwns = true;
				playerWhoOwns = i;
				rent = Dice.diceRollSum() * 4;
				if(Player.Player[i][12] >= 2){
					playerWhoOwns = i;
					rent *= 2.5;
				}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
			}
		}
			if(aPlayerOwns == false) {
				do {
					menuCheck = 0;
					System.out.println("What would you like to do?");
					System.out.println("1 Buy utility ($150)");
					System.out.println("2 Auction off property");
				
					String input = in.readLine();
					
					try {
						int choice = Integer.parseInt(input);
				
				
						if(choice == 1){
							Player.Player[playerNumber][27] = 1;
							Player.Player[playerNumber][12] += 1;
							bank.buyAProperty(playerNumber, 150, 150);
						}
						
						else if(choice == 2) {
							Player.auction(150, 27);
							Player.Player[Player.playerWhoBought][12]+=1;
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
					
				}while(menuCheck == 1);
			}
		
		
		
	}
	//28 - Pink
	public void statesAvenue(int playerNumber) throws IOException {
		//Cost $140
		//Mortgage $70
		//Houses $100 each
		//Hotels $100 each
		
		//Rent $10
		//Monopoly Rent $20
		//1 House $50
		//2 House $150
		//3 House $450
		//4 House $625
		//1 Hotel $750
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 10;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][28] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][26] == 1 && Player.Player[playerWhoOwns][28] == 1 && Player.Player[playerWhoOwns][29] == 1 && Player.housesOnEachProperty[28] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[28] == 1) {
				rent = 50;
			}
			if(Player.housesOnEachProperty[28] == 2) {
				rent = 150;
			}
			if(Player.housesOnEachProperty[28] == 3) {
				rent = 450;
			}
			if(Player.housesOnEachProperty[28] == 4) {
				rent = 625;
			}
			if(Player.housesOnEachProperty[28] == 5) {
				rent = 750;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($140)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][28] = 1;
						bank.buyAProperty(playerNumber, 140, 140);
					}
					
					else if(choice == 2) {
						Player.auction(140, 28);
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
				
			}while(menuCheck == 1);
		}
	}
	//29 - Pink
	public void virginiaAvenue(int playerNumber) throws IOException {
		//Cost $160
		//Mortgage $80
		//Houses $100 each
		//Hotels $100 each
		
		//Rent $12
		//Monopoly Rent $24
		//1 House $60
		//2 House $180
		//3 House $500
		//4 House $700
		//1 Hotel $900
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 12;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][29] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][26] == 1 && Player.Player[playerWhoOwns][28] == 1 && Player.Player[playerWhoOwns][29] == 1 && Player.housesOnEachProperty[29] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[29] == 1) {
				rent = 60;
			}
			if(Player.housesOnEachProperty[29] == 2) {
				rent = 180;
			}
			if(Player.housesOnEachProperty[29] == 3) {
				rent = 500;
			}
			if(Player.housesOnEachProperty[29] == 4) {
				rent = 700;
			}
			if(Player.housesOnEachProperty[29] == 5) {
				rent = 900;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($160)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][29] = 1;
						bank.buyAProperty(playerNumber, 160, 160);
					}
					
					else if(choice == 2) {
						Player.auction(160, 29);
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
				
			}while(menuCheck == 1);
		}
	}
	//30 - Railroad
	public void pennsylvaniaRailroad(int playerNumber) throws IOException {
		//Cost $200
		//Mortgage $100
		
		//Rents
		//1 Railroad $25
		//2 Railroad $50
		//3 Railroad $100
		//4 Railroad $200
		Banker bank = new Banker();
		int playerWhoOwns = 10;
		int rent = 0;
		int menuCheck;
		aPlayerOwns = false;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][11] >= 1 && Player.Player[i][30] == 1){
				aPlayerOwns = true;
				playerWhoOwns = i;
				rent = 25;
				if(Player.Player[i][11] >= 2){
					playerWhoOwns = i;
					rent = 50;
					if(Player.Player[i][11] >= 3){
						playerWhoOwns = i;
						rent = 100;
						if(Player.Player[i][11] >= 4){
							playerWhoOwns = i;
							rent = 200;
							}
						}
					}
				bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
				System.out.println("You've paid the rent for this space.");
				}
			}
			
			if(aPlayerOwns == false) {
				
				do {
					menuCheck = 0;
					System.out.println("What would you like to do?");
					System.out.println("1 Buy railroad ($200)");
					System.out.println("2 Auction off property");
				
					String input = in.readLine();
					
					try {
						int choice = Integer.parseInt(input);
				
				
						if(choice == 1){
							Player.Player[playerNumber][30] = 1;
							Player.Player[playerNumber][11] += 1;
							bank.buyAProperty(playerNumber, 200, 200);
						}
						
						else if(choice == 2) {
							Player.auction(200, 30);
							Player.Player[Player.playerWhoBought][11]+=1;
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
					
				}while(menuCheck == 1);
			}
			
		
	}
	//31 - Orange
	public void stJamesPlace(int playerNumber) throws IOException {
		//Cost $180
		//Mortgage $90
		//Houses $100 each
		//Hotels $100 each
		
		//Rent $14
		//Monopoly Rent $28
		//1 House $70
		//2 House $200
		//3 House $550
		//4 House $750
		//1 Hotel $950
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 14;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][31] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][31] == 1 && Player.Player[playerWhoOwns][32] == 1 && Player.Player[playerWhoOwns][33] == 1 && Player.housesOnEachProperty[31] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[31] == 1) {
				rent = 70;
			}
			if(Player.housesOnEachProperty[31] == 2) {
				rent = 200;
			}
			if(Player.housesOnEachProperty[31] == 3) {
				rent = 550;
			}
			if(Player.housesOnEachProperty[31] == 4) {
				rent = 750;
			}
			if(Player.housesOnEachProperty[31] == 5) {
				rent = 950;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($180)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][31] = 1;
						bank.buyAProperty(playerNumber, 180, 180);
					}
					
					else if(choice == 2) {
						Player.auction(180, 31);
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
				
			}while(menuCheck == 1);
		}
	}
	//32 - Orange
	public void tennesseeAvenue(int playerNumber) throws IOException {
		//Cost $180
		//Mortgage $90
		//Houses $100 each
		//Hotels $100 each
		
		//Rent $14
		//Monopoly Rent $28
		//1 House $70
		//2 House $200
		//3 House $550
		//4 House $750
		//1 Hotel $950
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 14;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][32] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][31] == 1 && Player.Player[playerWhoOwns][32] == 1 && Player.Player[playerWhoOwns][33] == 1 && Player.housesOnEachProperty[32] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[32] == 1) {
				rent = 70;
			}
			if(Player.housesOnEachProperty[32] == 2) {
				rent = 200;
			}
			if(Player.housesOnEachProperty[32] == 3) {
				rent = 550;
			}
			if(Player.housesOnEachProperty[32] == 4) {
				rent = 750;
			}
			if(Player.housesOnEachProperty[32] == 5) {
				rent = 950;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($180)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][32] = 1;
						bank.buyAProperty(playerNumber, 180, 180);
					}
					
					else if(choice == 2) {
						Player.auction(180, 32);
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
				
			}while(menuCheck == 1);
		}
		
	}
	//33 - Orange
	public void newYorkAvenue(int playerNumber) throws IOException {
		//Cost $200
		//Mortgage $100
		//Houses $100 each
		//Hotels $100 each
		
		//Rent $16
		//Monopoly Rent $32
		//1 House $80
		//2 House $220
		//3 House $600
		//4 House $800
		//1 Hotel $1000
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 16;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][33] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][31] == 1 && Player.Player[playerWhoOwns][32] == 1 && Player.Player[playerWhoOwns][33] == 1 && Player.housesOnEachProperty[33] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[33] == 1) {
				rent = 80;
			}
			if(Player.housesOnEachProperty[33] == 2) {
				rent = 220;
			}
			if(Player.housesOnEachProperty[33] == 3) {
				rent = 600;
			}
			if(Player.housesOnEachProperty[33] == 4) {
				rent = 800;
			}
			if(Player.housesOnEachProperty[33] == 5) {
				rent = 1000;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($200)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][33] = 1;
						bank.buyAProperty(playerNumber, 200, 200);
					}
					
					else if(choice == 2) {
						Player.auction(200, 33);
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
				
			}while(menuCheck == 1);
		}
	}
	//34 - Red
	public void kentuckyAvenue(int playerNumber) throws IOException {
		//Cost $220
		//Mortgage $110
		//Houses $150 each
		//Hotels $150 each
		
		//Rent $18
		//Monopoly Rent $36
		//1 House $90
		//2 House $250
		//3 House $700
		//4 House $875
		//1 Hotel $1050
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 18;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][34] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][34] == 1 && Player.Player[playerWhoOwns][35] == 1 && Player.Player[playerWhoOwns][36] == 1 && Player.housesOnEachProperty[34] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[34] == 1) {
				rent = 90;
			}
			if(Player.housesOnEachProperty[34] == 2) {
				rent = 250;
			}
			if(Player.housesOnEachProperty[34] == 3) {
				rent = 700;
			}
			if(Player.housesOnEachProperty[34] == 4) {
				rent = 875;
			}
			if(Player.housesOnEachProperty[34] == 5) {
				rent = 1050;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($220)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][34] = 1;
						bank.buyAProperty(playerNumber, 220, 220);
					}
					
					else if(choice == 2) {
						Player.auction(220, 34);
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
				
			}while(menuCheck == 1);
		}
	}
	//35 - Red
	public void indianaAvenue(int playerNumber) throws IOException {
		//Cost $220
		//Mortgage $110
		//Houses $150 each
		//Hotels $150 each
		
		//Rent $18
		//Monopoly Rent $36
		//1 House $90
		//2 House $250
		//3 House $700
		//4 House $875
		//1 Hotel $1050
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 18;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][35] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][34] == 1 && Player.Player[playerWhoOwns][35] == 1 && Player.Player[playerWhoOwns][36] == 1 && Player.housesOnEachProperty[35] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[35] == 1) {
				rent = 90;
			}
			if(Player.housesOnEachProperty[35] == 2) {
				rent = 250;
			}
			if(Player.housesOnEachProperty[35] == 3) {
				rent = 700;
			}
			if(Player.housesOnEachProperty[35] == 4) {
				rent = 875;
			}
			if(Player.housesOnEachProperty[35] == 5) {
				rent = 1050;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($220)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][35] = 1;
						bank.buyAProperty(playerNumber, 220, 220);
					}
					
					else if(choice == 2) {
						Player.auction(220, 35);
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
				
			}while(menuCheck == 1);
		}
	}
	//36 - Red
	public void illinoisAvenue(int playerNumber) throws IOException {
		//Cost $240
		//Mortgage $120
		//Houses $150 each
		//Hotels $150 each
		
		//Rent $20
		//Monopoly Rent $40
		//1 House $100
		//2 House $300
		//3 House $750
		//4 House $925
		//1 Hotel $1100
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 20;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][36] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][34] == 1 && Player.Player[playerWhoOwns][35] == 1 && Player.Player[playerWhoOwns][36] == 1 && Player.housesOnEachProperty[36] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[36] == 1) {
				rent = 100;
			}
			if(Player.housesOnEachProperty[36] == 2) {
				rent = 300;
			}
			if(Player.housesOnEachProperty[36] == 3) {
				rent = 750;
			}
			if(Player.housesOnEachProperty[36] == 4) {
				rent = 925;
			}
			if(Player.housesOnEachProperty[36] == 5) {
				rent = 1100;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($240)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][36] = 1;
						bank.buyAProperty(playerNumber, 240, 240);
					}
					
					else if(choice == 2) {
						Player.auction(240, 36);
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
				
			}while(menuCheck == 1);
		}
	}
	//37 - Railroad
	public void bAndORailroad(int playerNumber) throws IOException {
		//Cost $200
		//Mortgage $100
		
		//Rents
		//1 Railroad $25
		//2 Railroad $50
		//3 Railroad $100
		//4 Railroad $200
		Banker bank = new Banker();
		int playerWhoOwns = 10;
		int rent = 0;
		int menuCheck;
		aPlayerOwns = false;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][11] >= 1 && Player.Player[i][37] == 1){
				aPlayerOwns = true;
				playerWhoOwns = i;
				rent = 25;
				if(Player.Player[i][11] >= 2){
					playerWhoOwns = i;
					rent = 50;
					if(Player.Player[i][11] >= 3){
						playerWhoOwns = i;
						rent = 100;
						if(Player.Player[i][11] >= 4){
							playerWhoOwns = i;
							rent = 200;
							}
						}
					}
				bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
				System.out.println("You've paid the rent for this space.");
				}
			
		}
			if(aPlayerOwns == false) {
				
				do {
					menuCheck = 0;
					System.out.println("What would you like to do?");
					System.out.println("1 Buy railroad ($200)");
					System.out.println("2 Auction off property");
				
					String input = in.readLine();
					
					try {
						int choice = Integer.parseInt(input);
				
				
						if(choice == 1){
							Player.Player[playerNumber][37] = 1;
							Player.Player[playerNumber][11] += 1;
							bank.buyAProperty(playerNumber, 200, 200);
						}
						
						else if(choice == 2) {
							Player.auction(200, 37);
							Player.Player[Player.playerWhoBought][11]+=1;
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
					
				}while(menuCheck == 1);
			}
			
		
	}
	//38 - Yellow
	public void atlanticAvenue(int playerNumber) throws IOException {
		//Cost $260
		//Mortgage $130
		//Houses $150 each
		//Hotels $150 each
		
		//Rent $22
		//Monopoly Rent $44
		//1 House $110
		//2 House $330
		//3 House $800
		//4 House $975
		//1 Hotel $1150
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 22;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][38] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][38] == 1 && Player.Player[playerWhoOwns][39] == 1 && Player.Player[playerWhoOwns][41] == 1 && Player.housesOnEachProperty[38] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[38] == 1) {
				rent = 110;
			}
			if(Player.housesOnEachProperty[38] == 2) {
				rent = 330;
			}
			if(Player.housesOnEachProperty[38] == 3) {
				rent = 800;
			}
			if(Player.housesOnEachProperty[38] == 4) {
				rent = 975;
			}
			if(Player.housesOnEachProperty[38] == 5) {
				rent = 1150;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($260)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][38] = 1;
						bank.buyAProperty(playerNumber, 260, 260);
					}
					
					else if(choice == 2) {
						Player.auction(260, 38);
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
				
			}while(menuCheck == 1);
		}
	}
	//39 - Yellow
	public void ventnorAvenue(int playerNumber) throws IOException {
		//Cost $260
		//Mortgage $130
		//Houses $150 each
		//Hotels $150 each
		
		//Rent $22
		//Monopoly Rent $44
		//1 House $110
		//2 House $330
		//3 House $800
		//4 House $975
		//1 Hotel $1150
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 22;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][39] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][38] == 1 && Player.Player[playerWhoOwns][39] == 1 && Player.Player[playerWhoOwns][41] == 1 && Player.housesOnEachProperty[39] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[38] == 1) {
				rent = 110;
			}
			if(Player.housesOnEachProperty[38] == 2) {
				rent = 330;
			}
			if(Player.housesOnEachProperty[38] == 3) {
				rent = 800;
			}
			if(Player.housesOnEachProperty[38] == 4) {
				rent = 975;
			}
			if(Player.housesOnEachProperty[38] == 5) {
				rent = 1150;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($260)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][39] = 1;
						bank.buyAProperty(playerNumber, 260, 260);
					}
					
					else if(choice == 2) {
						Player.auction(260, 39);
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
				
			}while(menuCheck == 1);
		}
	}
	//40 - Utility
	public void waterWorks(int playerNumber) throws IOException {
		//Cost $150
		//Mortgage $75
		
		//Rents
		//1 Owned $4 x DiceRoll
		//2 Owned $10 x DiceRoll
		Banker bank = new Banker();
		int playerWhoOwns = 10;
		int rent = 0;
		int menuCheck;
		aPlayerOwns = false;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][12] >= 1 && Player.Player[i][40] == 1){
				aPlayerOwns = true;
				playerWhoOwns = i;
				rent = Dice.diceRollSum() * 4;
				if(Player.Player[i][12] >= 2){
					playerWhoOwns = i;
					rent *= 2.5;
				}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
			}
		}
			if(aPlayerOwns == false) {
				do {
					menuCheck = 0;
					System.out.println("What would you like to do?");
					System.out.println("1 Buy utility ($150)");
					System.out.println("2 Auction off property");
				
					String input = in.readLine();
					
					try {
						int choice = Integer.parseInt(input);
				
				
						if(choice == 1){
							Player.Player[playerNumber][40] = 1;
							Player.Player[playerNumber][12] += 1;
							bank.buyAProperty(playerNumber, 150, 150);
						}
						
						else if(choice == 2) {
							Player.auction(150, 40);
							Player.Player[Player.playerWhoBought][12]+=1;
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
					
				}while(menuCheck == 1);
			}
		
	}
	//41 - Yellow
	public void marvinGardens(int playerNumber) throws IOException {
		//Cost $280
		//Mortgage $140
		//Houses $150 each
		//Hotels $150 each
		
		//Rent $24
		//Monopoly Rent $48
		//1 House $120
		//2 House $360
		//3 House $850
		//4 House $1025
		//1 Hotel $1200
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 24;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][41] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][38] == 1 && Player.Player[playerWhoOwns][39] == 1 && Player.Player[playerWhoOwns][41] == 1 && Player.housesOnEachProperty[41] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[38] == 1) {
				rent = 120;
			}
			if(Player.housesOnEachProperty[38] == 2) {
				rent = 360;
			}
			if(Player.housesOnEachProperty[38] == 3) {
				rent = 850;
			}
			if(Player.housesOnEachProperty[38] == 4) {
				rent = 1025;
			}
			if(Player.housesOnEachProperty[38] == 5) {
				rent = 1200;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($280)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][41] = 1;
						bank.buyAProperty(playerNumber, 280, 280);
					}
					
					else if(choice == 2) {
						Player.auction(280, 41);
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
				
			}while(menuCheck == 1);
		}
	}
	//42 - Green
	public void pacificAvenue(int playerNumber) throws IOException {
		//Cost $300
		//Mortgage $150
		//Houses $200 each
		//Hotels $200 each
		
		//Rent $26
		//Monopoly Rent $52
		//1 House $130
		//2 House $390
		//3 House $900
		//4 House $1100
		//1 Hotel $1275
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 26;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][42] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][42] == 1 && Player.Player[playerWhoOwns][43] == 1 && Player.Player[playerWhoOwns][44] == 1 && Player.housesOnEachProperty[42] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[42] == 1) {
				rent = 130;
			}
			if(Player.housesOnEachProperty[42] == 2) {
				rent = 390;
			}
			if(Player.housesOnEachProperty[42] == 3) {
				rent = 900;
			}
			if(Player.housesOnEachProperty[42] == 4) {
				rent = 1100;
			}
			if(Player.housesOnEachProperty[42] == 5) {
				rent = 1275;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($300)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][42] = 1;
						bank.buyAProperty(playerNumber, 300, 300);
					}
					
					else if(choice == 2) {
						Player.auction(300, 42);
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
				
			}while(menuCheck == 1);
		}
	}
	//43 - Green
	public void northCarolinaAvenue(int playerNumber) throws IOException {
		//Cost $300
		//Mortgage $150
		//Houses $200 each
		//Hotels $200 each
		
		//Rent $26
		//Monopoly Rent $52
		//1 House $130
		//2 House $390
		//3 House $900
		//4 House $1100
		//1 Hotel $1275
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 26;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][43] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][42] == 1 && Player.Player[playerWhoOwns][43] == 1 && Player.Player[playerWhoOwns][44] == 1 && Player.housesOnEachProperty[43] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[43] == 1) {
				rent = 130;
			}
			if(Player.housesOnEachProperty[43] == 2) {
				rent = 390;
			}
			if(Player.housesOnEachProperty[43] == 3) {
				rent = 900;
			}
			if(Player.housesOnEachProperty[43] == 4) {
				rent = 1100;
			}
			if(Player.housesOnEachProperty[43] == 5) {
				rent = 1275;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($300)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][43] = 1;
						bank.buyAProperty(playerNumber, 300, 300);
					}
					
					else if(choice == 2) {
						Player.auction(300, 43);
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
				
			}while(menuCheck == 1);
		}
	}
	//44 - Green
	public void pennsylvaniaAvenue(int playerNumber) throws IOException {
		//Cost $320
		//Mortgage $160
		//Houses $200 each
		//Hotels $200 each
		
		//Rent $28
		//Monopoly Rent $56
		//1 House $150
		//2 House $450
		//3 House $1000
		//4 House $1200
		//1 Hotel $1400
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 28;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][44] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][42] == 1 && Player.Player[playerWhoOwns][43] == 1 && Player.Player[playerWhoOwns][44] == 1 && Player.housesOnEachProperty[44] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[42] == 1) {
				rent = 150;
			}
			if(Player.housesOnEachProperty[42] == 2) {
				rent = 450;
			}
			if(Player.housesOnEachProperty[42] == 3) {
				rent = 1000;
			}
			if(Player.housesOnEachProperty[42] == 4) {
				rent = 1200;
			}
			if(Player.housesOnEachProperty[42] == 5) {
				rent = 1400;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($320)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][44] = 1;
						bank.buyAProperty(playerNumber, 320, 320);
					}
					
					else if(choice == 2) {
						Player.auction(320, 44);
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
				
			}while(menuCheck == 1);
		}
	}
	//45 - Railroad
	public void shortLine(int playerNumber) throws IOException {
		//Cost $200
		//Mortgage $100
		
		//Rents
		//1 Railroad $25
		//2 Railroad $50
		//3 Railroad $100
		//4 Railroad $200
		Banker bank = new Banker();
		int playerWhoOwns = 10;
		int rent = 0;
		int menuCheck;
		aPlayerOwns = false;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][11] >= 1 && Player.Player[i][45] == 1){
				aPlayerOwns = true;
				playerWhoOwns = i;
				rent = 25;
				if(Player.Player[i][11] >= 2){
					playerWhoOwns = i;
					rent = 50;
					if(Player.Player[i][11] >= 3){
						playerWhoOwns = i;
						rent = 100;
						if(Player.Player[i][11] >= 4){
							playerWhoOwns = i;
							rent = 200;
							}
						}
					}
				bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
				System.out.println("You've paid the rent for this space.");
				}
			
		}
			if(aPlayerOwns = false) {
				
				do {
					menuCheck = 0;
					System.out.println("What would you like to do?");
					System.out.println("1 Buy railroad ($200)");
					System.out.println("2 Auction off property");
				
					String input = in.readLine();
					
					try {
						int choice = Integer.parseInt(input);
				
				
						if(choice == 1){
							Player.Player[playerNumber][45] = 1;
							Player.Player[playerNumber][11] += 1;
							bank.buyAProperty(playerNumber, 200, 200);
						}
						
						else if(choice == 2) {
							Player.auction(200, 45);
							Player.Player[Player.playerWhoBought][11]+=1;
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
					
				}while(menuCheck == 1);
			}
			
		
	}
	//46 - Dark Blue
	public void parkPlace(int playerNumber) throws IOException {
		//Cost $350
		//Mortgage $175
		//Houses $200 each
		//Hotels $200 each
		
		//Rent $35
		//Monopoly Rent $70
		//1 House $175
		//2 House $500
		//3 House $1100
		//4 House $1300
		//1 Hotel $1500
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 35;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][46] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][46] == 1 && Player.Player[playerWhoOwns][47] == 1 && Player.housesOnEachProperty[46] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[42] == 1) {
				rent = 175;
			}
			if(Player.housesOnEachProperty[42] == 2) {
				rent = 500;
			}
			if(Player.housesOnEachProperty[42] == 3) {
				rent = 1100;
			}
			if(Player.housesOnEachProperty[42] == 4) {
				rent = 1300;
			}
			if(Player.housesOnEachProperty[42] == 5) {
				rent = 1500;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($350)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][46] = 1;
						bank.buyAProperty(playerNumber, 350, 350);
					}
					
					else if(choice == 2) {
						Player.auction(350, 46);
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
				
			}while(menuCheck == 1);
		}
	}
	//47 - Dark Blue
	public void boardwalk(int playerNumber) throws IOException {
		//Cost $400
		//Mortgage $200
		//Houses $200 each
		//Hotels $200 each
		
		//Rent $50
		//Monopoly Rent $100
		//1 House $200
		//2 House $600
		//3 House $1400
		//4 House $1700
		//1 Hotel $2000
		
		Banker bank = new Banker();
		boolean bought = false;
		int playerWhoOwns = 10;
		int rent = 50;
		int menuCheck;
		for(int i=0;i<Player.Player_Num;i++){
			if(Player.Player[i][47] == 1){
				bought = true;
				playerWhoOwns = i;
				}
			}
		
		if(bought == true) {
			if(Player.Player[playerWhoOwns][46] == 1 && Player.Player[playerWhoOwns][47] == 1 && Player.housesOnEachProperty[47] == 0){
				rent *= 2;
			}
			if(Player.housesOnEachProperty[47] == 1) {
				rent = 200;
			}
			if(Player.housesOnEachProperty[47] == 2) {
				rent = 600;
			}
			if(Player.housesOnEachProperty[47] == 3) {
				rent = 1400;
			}
			if(Player.housesOnEachProperty[47] == 4) {
				rent = 1700;
			}
			if(Player.housesOnEachProperty[47] == 5) {
				rent = 2000;
			}
			bank.exchangeAnAmount(playerNumber, playerWhoOwns, rent);
			System.out.println("You've paid the rent for this space.");
		}
		
		else {
			
			do {
				menuCheck = 0;
				System.out.println("What would you like to do?");
				System.out.println("1 Buy property ($400)");
				System.out.println("2 Auction off property");
			
				String input = in.readLine();
				
				try {
					int choice = Integer.parseInt(input);
			
			
					if(choice == 1){
						Player.Player[playerNumber][47] = 1;
						bank.buyAProperty(playerNumber, 400, 400);
					}
					
					else if(choice == 2) {
						Player.auction(400, 47);
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
				
			}while(menuCheck == 1);
		}
	}
}



package edu.neumont.csc110.d.monopoly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Chance {
	public enum ChanceCards {
		advanceToGo, advanceToIllinoisAvenue, advanceToStcharlesPlace, advanceToNearestUtility, advanceToNearestRR, bankPay50, getOutOfJail, back3, goToJail, payPerHouseHotel, poorTax, readingRailroad, payEach50, collect150, collect$100,

	}
	private static Properties prop = new Properties();
	private static Banker bank = new Banker();
	private static Jail j = new Jail();

	public static void ChanceCard(int playerNum, int numberOfPlayers) throws IOException {
		long boardSpace = Player.Player[playerNum][1];
		Random randotm = new Random();
		int random = randotm.nextInt(14 - 0);
		ArrayList<ChanceCards> usedCardList2 = new ArrayList<>();
		if (usedCardList2.size() == 15) {
			usedCardList2.clear();
		}
		ChanceCards cardNumber = ChanceCards.values()[random];
		switch (cardNumber) {
		case advanceToGo:
			if (usedCardList2.contains(ChanceCards.advanceToGo)) {
				ChanceCard(playerNum, numberOfPlayers);
			} else {
				Player.Player[playerNum][1] = 0;
				bank.passGo(Player.P);
				usedCardList2.add(ChanceCards.advanceToGo);
			}
			break;
		case advanceToIllinoisAvenue:
			if (usedCardList2.contains(ChanceCards.advanceToIllinoisAvenue)) {
				ChanceCard(playerNum, numberOfPlayers);
			} else {
				Player.Player[playerNum][1] = 24;
				prop.illinoisAvenue(Player.P);
				usedCardList2.add(ChanceCards.advanceToIllinoisAvenue);
			}
			break;
		case advanceToStcharlesPlace:
			if (usedCardList2.contains(ChanceCards.advanceToStcharlesPlace)) {
				ChanceCard(playerNum, numberOfPlayers);
			} else {
				Player.Player[playerNum][1] = 11;
				prop.stCharlesPlace(Player.P);
				usedCardList2.add(ChanceCards.advanceToStcharlesPlace);
			}
			break;
		case advanceToNearestUtility:
			if (usedCardList2.contains(ChanceCards.advanceToNearestUtility)) {
				ChanceCard(playerNum, numberOfPlayers);
			} else {

				if (boardSpace == 36 || boardSpace == 7) {
					Player.Player[playerNum][1] = 12;
					prop.electricCompany(Player.P);
				}

				if (boardSpace == 22) {
					Player.Player[playerNum][1] = 28;
					prop.waterWorks(Player.P);

				}
				usedCardList2.add(ChanceCards.advanceToNearestUtility);
			}
			break;
		case advanceToNearestRR:
			if (usedCardList2.contains(ChanceCards.advanceToNearestRR)) {
				ChanceCard(playerNum, numberOfPlayers);
			} else {
				if (boardSpace < 5 || boardSpace > 35) {
					Player.Player[playerNum][1] = 5;
					prop.readingRailroad(Player.P);
				}
				if (boardSpace < 15 && boardSpace > 5) {
					Player.Player[playerNum][1] = 15;
					prop.pennsylvaniaRailroad(Player.P);
				}
				if (boardSpace < 25 && boardSpace > 15) {
					Player.Player[playerNum][1] = 25;
					prop.bAndORailroad(Player.P);
				}
				if (boardSpace < 35 && boardSpace > 25) {
					Player.Player[playerNum][1] = 35;
					prop.shortLine(Player.P);
				}
					usedCardList2.add(ChanceCards.advanceToNearestRR);
				
			}

			break;
		case bankPay50:
			if (usedCardList2.contains(ChanceCards.bankPay50)) {
				ChanceCard(playerNum, numberOfPlayers);
			} else {
				bank.addAnAmount(playerNum, 50);
				usedCardList2.add(ChanceCards.bankPay50);
			}
			break;
		case getOutOfJail:
			if(usedCardList2.contains(ChanceCards.getOutOfJail)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
			Player.Player[playerNum][6] += 1;
			usedCardList2.add(ChanceCards.getOutOfJail);
			}
			break;
		case back3:
			if(usedCardList2.contains(ChanceCards.back3)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
				if(Player.Player[Player.P][1]==7){bank.incomeTax(Player.P);}
				else if(Player.Player[Player.P][1]==22){prop.newYorkAvenue(Player.P);}
				else if(Player.Player[Player.P][1]==36){Chest.CommunityChest(Player.P, numberOfPlayers);
				}
			Player.Player[playerNum][1] = (boardSpace - 3);
			usedCardList2.add(ChanceCards.back3);
			}
			break;
		case goToJail:
			if(usedCardList2.contains(ChanceCards.goToJail)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
			j.toJailByGoToJail(Player.P);
			usedCardList2.add(ChanceCards.goToJail);
			break;
			}
			case payPerHouseHotel:
			if(usedCardList2.contains(ChanceCards.payPerHouseHotel)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
			int houseFee = (int) Player.Player[playerNum][4] * 25;
			int hotelFee = (int) Player.Player[playerNum][5] * 100;
			bank.subtractAnAmount(playerNum,(hotelFee + houseFee));
			usedCardList2.add(ChanceCards.payPerHouseHotel);
			}
			break;
		case poorTax:
			if(usedCardList2.contains(ChanceCards.poorTax)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
			bank.subtractAnAmount(playerNum, 50);
			usedCardList2.add(ChanceCards.poorTax);
			}
			break;
		case readingRailroad:
			if(usedCardList2.contains(ChanceCards.readingRailroad)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
			Player.Player[playerNum][1] = 5;
			prop.readingRailroad(Player.P);
			usedCardList2.add(ChanceCards.readingRailroad);
			}
			break;
		case payEach50:
			if(usedCardList2.contains(ChanceCards.payEach50)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
			for (int i = 0; i < numberOfPlayers; i++) {
				bank.addAnAmount(i, 50);
			}
			bank.subtractAnAmount(playerNum, 50* numberOfPlayers);
			usedCardList2.add(ChanceCards.payEach50);
			}

			break;
		case collect150:
			if(usedCardList2.contains(ChanceCards.collect150)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
			bank.addAnAmount(playerNum, 150);
			usedCardList2.add(ChanceCards.collect150);
			}
			break;
		case collect$100:
			if(usedCardList2.contains(ChanceCards.collect$100)){
				ChanceCard(playerNum, numberOfPlayers);
			}
			else{
			bank.addAnAmount(playerNum, 100);
			usedCardList2.add(ChanceCards.collect$100);
			}
			break;
		}
	}
}
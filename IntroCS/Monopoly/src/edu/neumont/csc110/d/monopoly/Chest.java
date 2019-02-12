package edu.neumont.csc110.d.monopoly;


import java.util.ArrayList;
import java.util.Random;


public class Chest {
	public enum cChestCards {
		advanceToGo, bankError, doctorsFee, stockSell, getOutOfJail, goToJail, get50FromAll, holidayFundMatures, incomeTaxRefund, birthdayMoney, schoolFees, consultancyFee, streetRepairs, beautyContest2nd, inheritance
	}

	private static Banker bank = new Banker();

	public static void CommunityChest(int playerNum, int numberOfPlayers) {
		//long boardSpace = Player.Player[playerNum][1];
		Random randotm = new Random();
		int random = randotm.nextInt(14 - 0);
		ArrayList<cChestCards> usedCardList = new ArrayList<>();
		if (usedCardList.size() == 15) {
			usedCardList.clear();
			;
		}

		cChestCards cardNumber = cChestCards.values()[random];
		switch (cardNumber) {
		case advanceToGo:
			if (usedCardList.contains(cChestCards.advanceToGo)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				Player.Player[playerNum][1] = 0;
				bank.passGo(Player.P);
				usedCardList.add(cChestCards.advanceToGo);
			}
			break;
		case bankError:
			if (usedCardList.contains(cChestCards.bankError)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.addAnAmount(playerNum, 200);
				usedCardList.add(cChestCards.bankError);
			}
			break;
		case doctorsFee:
			if (usedCardList.contains(cChestCards.doctorsFee)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.subtractAnAmount(playerNum, 50);
				usedCardList.add(cChestCards.doctorsFee);
			}
			break;
		case stockSell:
			if (usedCardList.contains(cChestCards.stockSell)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.addAnAmount(playerNum, 50);
				usedCardList.add(cChestCards.stockSell);
			}
			break;
		case getOutOfJail:
			if (usedCardList.contains(cChestCards.getOutOfJail)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				Player.Player[playerNum][6] += 1;
				usedCardList.add(cChestCards.getOutOfJail);
			}
			break;
		case goToJail:
			if (usedCardList.contains(cChestCards.goToJail)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				Player.Player[playerNum][7] = 1;
				usedCardList.add(cChestCards.goToJail);
			}
			break;
		case get50FromAll:
			if (usedCardList.contains(cChestCards.get50FromAll)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.addAnAmount(playerNum, (50 * numberOfPlayers));
				for (int i = 0; i < numberOfPlayers; i++) {
					bank.subtractAnAmount(i, 50);
					usedCardList.add(cChestCards.get50FromAll);
				}
			}
			break;
		case holidayFundMatures:
			if (usedCardList.contains(cChestCards.holidayFundMatures)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.addAnAmount(playerNum, 100);
				usedCardList.add(cChestCards.holidayFundMatures);
				break;
			}
		case incomeTaxRefund:
			if (usedCardList.contains(cChestCards.incomeTaxRefund)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.addAnAmount(playerNum, 20);
				usedCardList.add(cChestCards.incomeTaxRefund);
				break;
			}

		case birthdayMoney:
			if (usedCardList.contains(cChestCards.birthdayMoney)) {
				CommunityChest(playerNum, numberOfPlayers);

			} else {
				bank.addAnAmount(playerNum, (10* numberOfPlayers));
				for (int i = 0; i < numberOfPlayers; i++) {
					bank.subtractAnAmount(i, 10);
					usedCardList.add(cChestCards.birthdayMoney);
				}
			}
			break;
		case schoolFees:
			if (usedCardList.contains(cChestCards.schoolFees)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.subtractAnAmount(playerNum, 150);
				usedCardList.add(cChestCards.schoolFees);
			}
			break;
		case consultancyFee:
			if (usedCardList.contains(cChestCards.streetRepairs)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.addAnAmount(playerNum, 25);
				usedCardList.add(cChestCards.consultancyFee);
			}
			break;
		case streetRepairs:
			if (usedCardList.contains(cChestCards.streetRepairs)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				int houseFee = (int)Player.Player[playerNum][4] * 40;
			int	 hotelFee = (int)Player.Player[playerNum][5] * 115;
				bank.subtractAnAmount(playerNum, (hotelFee+ houseFee));
				usedCardList.add(cChestCards.streetRepairs);

			}
			break;
		case beautyContest2nd:

			if (usedCardList.contains(cChestCards.beautyContest2nd)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {

				bank.addAnAmount(playerNum, 10);
				usedCardList.add(cChestCards.beautyContest2nd);
			}
			break;
		case inheritance:

			if (usedCardList.contains(cChestCards.inheritance)) {
				CommunityChest(playerNum, numberOfPlayers);
			} else {
				bank.addAnAmount(playerNum, 100);
				usedCardList.add(cChestCards.inheritance);
			}

			break;

		}

	}

}

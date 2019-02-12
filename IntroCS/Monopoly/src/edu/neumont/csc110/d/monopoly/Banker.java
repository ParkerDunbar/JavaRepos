package edu.neumont.csc110.d.monopoly;

public class Banker {
	final private int startingMoney = 1500;
	final private int passGo = 200;
	final private int startingPositionLoansHousesHotelsGetOutCardsAndUnmortgagedProperties = 0;
	public static int Houses = 32;
	public static int Hotels = 12;
	public void startingMoney(int playerNum){
		Player.Player[playerNum][1]=startingPositionLoansHousesHotelsGetOutCardsAndUnmortgagedProperties;
		Player.Player[playerNum][2]=startingMoney;
		Player.Player[playerNum][3]=startingPositionLoansHousesHotelsGetOutCardsAndUnmortgagedProperties;
		Player.Player[playerNum][4]=startingPositionLoansHousesHotelsGetOutCardsAndUnmortgagedProperties;
		Player.Player[playerNum][5]=startingPositionLoansHousesHotelsGetOutCardsAndUnmortgagedProperties;
		Player.Player[playerNum][6]=startingPositionLoansHousesHotelsGetOutCardsAndUnmortgagedProperties;
		Player.Player[playerNum][7]=0;
		Player.Player[playerNum][8]=startingMoney;
		Player.Player[playerNum][9]=0;
		Player.Player[playerNum][10]=startingPositionLoansHousesHotelsGetOutCardsAndUnmortgagedProperties;
		}
	public void passGo(int playerNum){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][8];
		money += passGo;
		worth += passGo;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][8]=worth;
	}
	public void luxuryTax(int playerNum){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][8];
		money -= 75;
		worth -= 75;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][8]=worth;
	}
	public void incomeTax(int playerNum){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][8];
			 if(worth>=2000){money-=200;worth-=200;}
        else if(worth<2000){money-=(worth/10);worth-=(worth/10);}
			 Player.Player[playerNum][2]=money;
			 Player.Player[playerNum][8]=worth;
	}
	public void mortgage(int playerNum, int mortgageValueOfProperty){
		long money = Player.Player[playerNum][2];
		long loans = Player.Player[playerNum][3];
		Player.Player[playerNum][10]-=1;
		money += mortgageValueOfProperty;
		loans += mortgageValueOfProperty;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][3]=loans;
		
	}
	public void unMortgage(int playerNum, int mortgageValueOfProperty){
		long money = Player.Player[playerNum][2];
		long loans = Player.Player[playerNum][3];
		Player.Player[playerNum][10]+=1;
		money -= (mortgageValueOfProperty*1.1);
		loans -= (mortgageValueOfProperty);
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][3]=loans;
	}
	public void subtractAnAmount(int playerNum, int amount){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][8];
		money -= amount;
		worth -= amount;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][8]=worth;
	}
	public void addAnAmount(int playerNum, int amount){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][2];
		money += amount;
		worth += amount;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][8]=worth;
	}
	public void exchangeAnAmount(int playerNumGiving, int playerNumReceiving, int amount){
		long moneyOfGiver = Player.Player[playerNumGiving][2];
		long moneyOfReceiver = Player.Player[playerNumReceiving][2];
		moneyOfGiver -= amount;
		moneyOfReceiver += amount;
		Player.Player[playerNumGiving][2]=moneyOfGiver;
		Player.Player[playerNumReceiving][2]=moneyOfReceiver;
	}
	public void exchangeAnAmountOfGetOutCards(int playerNumGiving, int playerNumReceiving, int amount){
		long cardsOfGiver = Player.Player[playerNumGiving][6];
		long cardsOfReceiver = Player.Player[playerNumReceiving][6];
		if(cardsOfGiver>0){
			cardsOfGiver -= amount;
			cardsOfReceiver += amount;
			Player.Player[playerNumGiving][6]=cardsOfGiver;
			Player.Player[playerNumReceiving][6]=cardsOfReceiver;
			}
	}
	public void buyAProperty(int playerNum, int worthOfProperty, int amountPaidForTheProperty){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][8];
		Player.Player[playerNum][10]+=1;
		worth += worthOfProperty;
		worth -= amountPaidForTheProperty;
		money -= amountPaidForTheProperty;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][8]=worth;
	}
	public void sellAProperty(int playerNum, int worthOfProperty, int amountPropertySoldFor){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][8];
		Player.Player[playerNum][10]-=1;
		worth -= worthOfProperty;
		worth += amountPropertySoldFor;
		money += amountPropertySoldFor;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][8]=worth;
	}
	public void sellHouses(int playerNum, int amount, int costOfEachHouse){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][8];
		long houses = Player.Player[playerNum][4];
		houses -= amount;
		money += ((costOfEachHouse*amount)/2);
		worth -= ((costOfEachHouse*amount)/2);
		Player.Player[playerNum][4]=houses;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][8]=worth;
		Houses += amount;
	}
	public void sellHotels(int playerNum, int amount, int costOfEachHotel){
		long money = Player.Player[playerNum][2];
		long worth = Player.Player[playerNum][8];
		long hotels = Player.Player[playerNum][5];
		hotels -= amount;
		money += ((costOfEachHotel*amount)/2);
		worth -= ((costOfEachHotel*amount)/2);
		Player.Player[playerNum][5]=hotels;
		Player.Player[playerNum][2]=money;
		Player.Player[playerNum][8]=worth;
		Hotels += amount;
	}
	public void buyHouses(int playerNum, int amount, int costOfEachHouse){
		long money = Player.Player[playerNum][2];
		long houses = Player.Player[playerNum][4];
		houses += amount;
		money -= (costOfEachHouse*amount);
		Player.Player[playerNum][4]=houses;
		Player.Player[playerNum][2]=money;
		Houses -= amount;
	}
	public void buyHotels(int playerNum, int amount, int costOfEachHotel){
		long money = Player.Player[playerNum][2];
		long hotels = Player.Player[playerNum][5];
		hotels += amount;
		money -= (costOfEachHotel*amount);
		Player.Player[playerNum][5]=hotels;
		Player.Player[playerNum][2]=money;
		Hotels -= amount;
	}	
	public void addMoneyToTotalWorth(int playerNum, int amount){
		long worth = Player.Player[playerNum][8];
		worth += amount;
		Player.Player[playerNum][8]=worth;
	}
	public void removeMoneyFromTotalWorth(int playerNum, int amount){
		long worth = Player.Player[playerNum][8];
		worth -= amount;
		Player.Player[playerNum][8]=worth;
	}
	public void bankrupt(int playerNum){
		if((Player.Player[playerNum][2]-Player.Player[playerNum][3])<0&&Player.Player[playerNum][10]<1){Player.Player[playerNum][9]=1;}
	}
}
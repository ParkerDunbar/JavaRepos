package edu.neumont.csc110.d.monopoly;


public class Jail {
	public void getOutByDoubles(int playerNum){
		if(Dice.diceRollIsDouble()==true){Player.Player[playerNum][7]=0;}
	}
	public void toJailAfterOneDouble(int playerNum){
		if(Dice.diceRollIsDouble()==true){Dice.diceRollSum();Dice.diceRollIsDouble();
			if(Dice.diceRollIsDouble()==true){Dice.diceRollSum();Dice.diceRollIsDouble();
				if(Dice.diceRollIsDouble()==true){Player.Player[playerNum][1]=10;Player.Player[playerNum][7]=1;}
				}}
	}
	public void toJailAfterTwoDoubles(int playerNum){
			if(Dice.diceRollIsDouble()==true){Dice.diceRollSum();Dice.diceRollIsDouble();
				if(Dice.diceRollIsDouble()==true){Player.Player[playerNum][1]=10;Player.Player[playerNum][7]=1;}
				}
	}
	public void toJailByGoToJail(int playerNum){
		if(Player.Player[playerNum][1]==30||Player.Player[playerNum][1]==10){Player.Player[playerNum][1]=10;Player.Player[playerNum][7]=1;}
	}
	public void getOutByPaying(int playerNum){
		Banker b = new Banker();
		if(Player.Player[playerNum][2]>49){b.subtractAnAmount(playerNum,50);;
		Player.Player[playerNum][7]=0;}	
	}
	public void getOutByCard(int playerNum){
		long getOutCards = Player.Player[playerNum][6];
		if(getOutCards>0){Player.Player[playerNum][6]=(getOutCards-1);
		Player.Player[playerNum][7]=0;}
		
	}
}


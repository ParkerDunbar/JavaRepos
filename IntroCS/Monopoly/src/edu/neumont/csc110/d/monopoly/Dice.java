package edu.neumont.csc110.d.monopoly;

public class Dice {
	private static int roll1;
	private static int roll2;
	public static int diceRollSum(){
		roll1=(int)(Math.random()*6+1);
		roll2=(int)(Math.random()*6+1);
		int sum=roll1+roll2;
		return sum;
	}
	public static boolean diceRollIsDouble(){
		boolean doubl = false;
		if(roll1==roll2){doubl = true;}
		return doubl;
	}
}

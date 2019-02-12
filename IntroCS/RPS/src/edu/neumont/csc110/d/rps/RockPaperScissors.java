package edu.neumont.csc110.d.rps;

import java.util.Random;
import edu.neumont.csc110.d.mytypes.WeaponOfChoice;

public class RockPaperScissors {
	
	public static WeaponOfChoice selectWeaponOfChoice() {
		WeaponOfChoice result = null;
		Random randNumberGenerator = new Random();
		int randomNumber = randNumberGenerator.nextInt(3);
		if(randomNumber == 0) {
			result = WeaponOfChoice.Rock;
		}
		if(randomNumber == 1) {
			result = WeaponOfChoice.Paper;
		}
		if(randomNumber == 2) {
			result = WeaponOfChoice.Scissors;
		}
		return result;
	}
	
	public static void main (String[] args) {
		WeaponOfChoice result = null;
		result = selectWeaponOfChoice();
		System.out.println(result);
		
	}
}

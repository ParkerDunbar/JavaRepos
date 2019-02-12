package edu.neumont.csc150.towersofhanoi;

public class TowersOfHanoi {
	private static int moves = 0;
	public static void main(String[] args) {
		int discs = Integer.parseInt(args[0]);
		move(discs, 1, 2, 3);
		System.out.println("Number of moves: " + moves);
	}

	public static void move(int discs, int startPole, int middlePole, int endPole) {
		moves++;
		if (discs == 1) {
			System.out.println("Disc moved from pole " + startPole + " to pole " + endPole);
		} 
		else {
			move(discs - 1, startPole, endPole, middlePole);
			
			System.out.println("Disc moved from pole " + startPole + " to pole " + endPole);
			
			move(discs - 1, middlePole, startPole, endPole);
		}
	}

}

package edu.neumont.csc150.ttt.controller;

import java.io.IOException;

import edu.neumont.csc150.ttt.model.Board;
import edu.neumont.csc150.ttt.model.OPlayer;
import edu.neumont.csc150.ttt.model.Player;
import edu.neumont.csc150.ttt.model.XPlayer;
import edu.neumont.csc150.ttt.view.Display;

public class Gameplay {
	private Display ui = new Display();
	private static Board board = new Board();

	public static Player xplayer = new XPlayer("X");
	public static Player oplayer = new OPlayer("O");
	public static Player whoseTurnIsIt;
	private boolean isQuit = false;
	private boolean replay = false;
	public int tie = 0;
	
	public void run() throws IOException {
		ui.displayWelcomeMessage();
		while(!replay) {
			isQuit = false;
			board.initBoard();
			whoseTurnIsIt = oplayer;
		
			while(!isQuit) {
				tie = 0;
				ui.printBoard();
				switchTurns();
				ui.displayPlayerTurn();
				takeSquare(ui.selectRow(), ui.selectCol());
				checkWin();
			}
		ui.displayWinner();
		replay = ui.promptForReset();
		}
		ui.displayGoodbyeMessage();
		
		//Initialize board
		//XPlayer selects square
		//Checks if square is available
		//Either takes square / Returns square is taken
		//Check win / tie condition
		//Change turn
	}
	

	/**
	 * checks to see if there is a winner or a tie
	 */
	private void checkWin() {
		
		if(getBoard().square[0][0].getPlayer() == xplayer && getBoard().square[0][1].getPlayer() == xplayer && getBoard().square[0][2].getPlayer() == xplayer) {
			isQuit = true;
		}
		else if(getBoard().square[0][0].getPlayer() == oplayer && getBoard().square[0][1].getPlayer() == oplayer && getBoard().square[0][2].getPlayer() == oplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[1][0].getPlayer() == xplayer && getBoard().square[1][1].getPlayer() == xplayer && getBoard().square[1][2].getPlayer() == xplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[1][0].getPlayer() == oplayer && getBoard().square[1][1].getPlayer() == oplayer && getBoard().square[1][2].getPlayer() == oplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[2][0].getPlayer() == xplayer && getBoard().square[2][1].getPlayer() == xplayer && getBoard().square[2][2].getPlayer() == xplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[2][0].getPlayer() == oplayer && getBoard().square[2][1].getPlayer() == oplayer && getBoard().square[2][2].getPlayer() == oplayer) {
			isQuit = true;
		}
		
		
		
		
		
		else if(getBoard().square[0][0].getPlayer() == xplayer && getBoard().square[1][0].getPlayer() == xplayer && getBoard().square[2][0].getPlayer() == xplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[0][0].getPlayer() == oplayer && getBoard().square[1][0].getPlayer() == oplayer && getBoard().square[2][0].getPlayer() == oplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[0][1].getPlayer() == xplayer && getBoard().square[1][1].getPlayer() == xplayer && getBoard().square[2][1].getPlayer() == xplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[0][1].getPlayer() == oplayer && getBoard().square[1][1].getPlayer() == oplayer && getBoard().square[2][1].getPlayer() == oplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[0][2].getPlayer() == xplayer && getBoard().square[1][2].getPlayer() == xplayer && getBoard().square[2][2].getPlayer() == xplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[0][2].getPlayer() == oplayer && getBoard().square[1][2].getPlayer() == oplayer && getBoard().square[2][2].getPlayer() == oplayer) {
			isQuit = true;
		}
		
		
		
		
		
		else if(getBoard().square[0][0].getPlayer() == xplayer && getBoard().square[1][1].getPlayer() == xplayer && getBoard().square[2][2].getPlayer() == xplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[0][0].getPlayer() == oplayer && getBoard().square[1][1].getPlayer() == oplayer && getBoard().square[2][2].getPlayer() == oplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[0][2].getPlayer() == xplayer && getBoard().square[1][1].getPlayer() == xplayer && getBoard().square[2][0].getPlayer() == xplayer) {
			isQuit = true;
		}
		
		else if(getBoard().square[0][2].getPlayer() == oplayer && getBoard().square[1][1].getPlayer() == oplayer && getBoard().square[2][0].getPlayer() == oplayer) {
			isQuit = true;
		}
		
		
		
		
		for(int i=0;i<getBoard().square.length;i++) {
			for(int j=0;j<getBoard().square.length;j++) {
				if(!getBoard().square[i][j].isAvailable()) {
					tie++;
				}
				
			}
		}
		if(tie == 9) {
			isQuit = true;
		}
	}


	/**
	 * @param takes in the requested square takes it based on current player
	 * checks to see if square is already taken, reprompts if it is
	 **/
	private void takeSquare(int i, int j) throws IOException {
		if(getBoard().square[i][j].isAvailable()) {
			getBoard().square[i][j].setAvailable(false);
			getBoard().square[i][j].setPlayer(whoseTurnIsIt);

		}
		else {
			ui.displaySpaceTaken();
			takeSquare(ui.selectRow(), ui.selectCol());
		}
		
		
	}


	/**
	 * switches the turn of the players
	 */
	private void switchTurns() {
		if(whoseTurnIsIt == xplayer) {
			whoseTurnIsIt = oplayer;
		}
		else if(whoseTurnIsIt == oplayer) {
			whoseTurnIsIt = xplayer;
		}
		
	}
	
	/**
	 * 
	 * @return the current board
	 */
	public static Board getBoard() {
		return board;
	}
	
	
}

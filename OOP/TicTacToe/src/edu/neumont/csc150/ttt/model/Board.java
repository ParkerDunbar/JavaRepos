package edu.neumont.csc150.ttt.model;

public class Board extends BoardSquare{
	
	public BoardSquare[][] square = new BoardSquare[3][3];
	
	/**
	 * initializes the board at the start of a new game
	 */
	public void initBoard() {
		for(int i=0;i<square.length;i++) {
			for(int j=0;j<square.length;j++) {
				square[i][j] = new BoardSquare();
				square[i][j].setAvailable(true);
				
			}
		}
	}
	

}

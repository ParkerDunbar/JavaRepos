package edu.neumont.csc110.d.maze;

public class Puzzle {

	public static void main(String[] args) {
		
		char [][] maze = {
			{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
			{'S',' ',' ',' ',' ',' ','*',' ','*',' ','*','*',' ',' ',' ','*',' ','*',' ','*'},
			{'*',' ','*','*','*',' ','*',' ',' ',' ',' ','*',' ','*',' ',' ',' ',' ',' ','*'},
			{'*',' ','*',' ','*',' ','*','*','*','*',' ',' ',' ','*','*','*','*','*','*','*'},
			{'*',' ','*',' ','*',' ','*',' ',' ','*',' ','*',' ',' ',' ',' ',' ',' ',' ','*'},
			{'*',' ','*',' ','*',' ',' ',' ',' ','*',' ','*',' ','*','*','*','*','*',' ','*'},
			{'*',' ','*',' ','*','*','*','*',' ','*',' ','*',' ','*',' ',' ','*',' ',' ','*'},
			{'*',' ',' ',' ',' ',' ',' ','*',' ','*',' ','*',' ','*',' ','*','*','*','*','*'},
			{'*','*','*',' ','*','*',' ','*',' ','*',' ','*',' ','*',' ',' ',' ',' ',' ','*'},
			{'*',' ','*',' ','*',' ',' ','*',' ','*','*','*',' ','*','*',' ','*',' ','*','*'},
			{'*',' ','*',' ','*',' ','*',' ',' ',' ',' ',' ',' ','*',' ',' ','*',' ',' ','*'},
			{'*',' ','*',' ','*',' ','*','*','*','*','*','*','*','*','*',' ','*','*',' ','*'},
			{'*',' ',' ',' ','*',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','*',' ',' ','*'},
			{'*',' ','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*',' ','*'},
			{'*',' ','*',' ','*',' ','*',' ','*',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','*'},
			{'*',' ','*',' ',' ',' ',' ',' ','*',' ','*','*','*','*','*',' ','*','*',' ','*'},
			{'*',' ','*','*','*',' ','*','*','*',' ','*',' ',' ',' ','*',' ',' ',' ',' ','*'},
			{'*',' ','*',' ','*',' ','*',' ','*',' ','*','*','*',' ','*',' ','*','*',' ','*'},
			{'*',' ',' ',' ',' ',' ',' ',' ','*',' ',' ',' ','*',' ',' ',' ',' ',' ',' ','*'},
			{'*','*','*','*','*','*','*','*','*','*','*','E','*','*','*','*','*','*','*','*'},
		};
		printMaze(maze);
	}
	
	public static void printMaze(char[][] maze) {
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}

}

package dunbar.parker.csc250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Queens {
	static int boardSize = 0;
	static int moves = 0;
	static int prints = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean valid = true;
		int queens = 0;
		while (valid) {
			System.out.println("Please enter an integer greater than 0");
			String input = in.readLine();
			queens = Integer.parseInt(input);
			if (queens > 0) {
				valid = false;
			} else {
				System.out.println("Invalid input.");
			}
		}

		for (int i = 1; i <= queens; i++) {
			if (i == 2 || i == 3) {
				System.out.println(i + ": Failed");
			} else {
				boardSize = i;
				moves = 0;
				prints = 0;
				char[][] board = new char[boardSize][boardSize];

				for (int j = 0; j < i; j++) {
					Arrays.fill(board[j], '-');
				}
				placeQueen(board, 0, 0);
			}
		}
	}

	private static void placeQueen(char[][] board, int r, int c) {
		if (c == 0 && r == boardSize) {
			if (prints == 0) {
				System.out.println(boardSize + ": Completed in " + moves + " steps");
				for (int i = 0; i < boardSize; i++) {
					for (int j = 0; j < boardSize; j++)
						System.out.print(board[i][j] + " ");
					System.out.println();
				}
				System.out.println();
				prints++;
				return;
			}
		}
		moves++;
		for (int i = 0; i < boardSize; i++) {
			if (isSafe(board, r, i)) {
				board[r][i] = 'Q';
				placeQueen(board, r + 1, 0);
				board[r][i] = '-';
			}
		}
	}

	private static boolean isSafe(char mat[][], int r, int c) {
		for (int i = 0; i < r; i++)
			if (mat[i][c] == 'Q')
				return false;

		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
			if (mat[i][j] == 'Q')
				return false;

		for (int i = r, j = c; i >= 0 && j < boardSize; i--, j++)
			if (mat[i][j] == 'Q')
				return false;

		return true;
	}

}

package dunbar.parker.csc230.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Driver {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Say hi to ELIZA!");
		while (true) {
			String userInput = bf.readLine();
			userInput = userInput.toLowerCase();

			char state = 'A';
			for (char c : userInput.toCharArray()) {
				switch (state) {
				case 'A':
					if (c == 'h')
						state = 'B';
					else if (c == ' ')
						state = 'A';
					else
						state = 'D';
					break;
				case 'B':
					if (c == 'i')
						state = 'C';
					else if (c == ' ')
						state = 'A';
					else
						state = 'D';
					break;
				case 'C':
					if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?')
						state = 'E';
					else 
						state = 'D';
					break;
				case 'D':
					if (c == ' ')
						state = 'A';
					break;
				case 'E':
					break;
				}
			}

			boolean found = false;
			if (state == 'C' || state == 'E')
				found = true;

			determineOutput(found);
		}
	}

	private static void determineOutput(boolean found) {
		Random rand = new Random();



		if (found) {
			int greeting = rand.nextInt(3);
			switch (greeting) {
			case 0:
				System.out.println("Hello there!");
				break;
			case 1:
				System.out.println("Hey!");
				break;
			case 2:
				System.out.println("Hi!");
				break;
			}
		}
		else {
			int unrecognized = rand.nextInt(2);
			switch (unrecognized) {
			case 0:
				System.out.println("Huh?");
				break;
			case 1:
				System.out.println("Not sure what you said there.");
				break;
			}
		}
	}
}

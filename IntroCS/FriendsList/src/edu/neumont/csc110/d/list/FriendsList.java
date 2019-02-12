package edu.neumont.csc110.d.list;

import java.io.IOException;
import java.util.ArrayList;


public class FriendsList {

	public static void main(String[] args) throws IOException {
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		boolean ifQuit = false;
		ArrayList<String> friends = new ArrayList<>();

		do {
			System.out.println("Welcome to your Friends List.");
			System.out.println();
			String[] options = { "1 - Add a Friend", "2 - Remove a Friend", "3 - Show My Friends",
					"0 - Quit" };
			for (int i = 0; i < options.length; i++) {
				System.out.println(options[i]);
			}

			int userOption = ConsoleUI.promptForInt("Please select an option.", 0, 3);
			
			if(userOption == 0) {
				ifQuit = true;
			}
			else if(userOption == 1) {
				friends = userAddFriend(friends);
			}
			else if(userOption == 2) {
				friends = userRemoveFriend(friends);
			}
			else if(userOption == 3) {
				userFriendList(friends);
			}
			
		} while (ifQuit == false);
		System.out.println("Thank you for using Friends List!");
	}
	
	public static ArrayList<String> userAddFriend(ArrayList<String> friends) throws IOException {
		String userFriend = ConsoleUI.promptForInput("Who would you like to add?", false);
		friends.add(userFriend);
		return friends;
	}
	
	public static ArrayList<String> userRemoveFriend(ArrayList<String> friends) throws IOException {
		String userFriend = ConsoleUI.promptForInput("Who would you like to remove?", false);
		friends.remove(userFriend);
		return friends;
	}
	
	public static void userFriendList(ArrayList<String> friends) throws IOException {
		System.out.println("Here is a list of all of your friends:");
		System.out.println(friends);
		ConsoleUI.promptForInput("Press enter to continue", true);
	}
}

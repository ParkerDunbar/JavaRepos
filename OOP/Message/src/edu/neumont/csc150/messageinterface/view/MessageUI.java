package edu.neumont.csc150.messageinterface.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import edu.neumont.csc150.messageinterface.controller.MessageApp;
import edu.neumont.csc150.messageinterface.model.Email;

public class MessageUI {
	
	private BufferedReader in = null;
	
	public MessageUI() {
		Reader reader = new InputStreamReader(System.in);
		in = new BufferedReader(reader);
	}

	public String getFromEmailFromUser() throws IOException {
		boolean isGoodInput = false;
		String userInput = null;
		while(!isGoodInput) {
			displayString("Please enter your email: ");
			userInput = in.readLine().trim();
			if(userInput.length() == 0) {
				displayErrorString("You have to type something...");
			}
			else if(!userInput.contains("@") && !userInput.contains(".")) {
				displayErrorString("This don't look like an email address.");
			}
			else {
				isGoodInput = true;
			}
		}
		return userInput;
	}

	public int getMainMenuSelection() throws IOException {
		boolean isGoodInput = false;
		String userInput = null;
		int userParseInt = 0;
		String[] menuOptions = new String[MessageApp.UserActions.COUNT_OF_USER_ACTIONS];
		menuOptions[MessageApp.UserActions.EXIT] = "Exit";
		menuOptions[MessageApp.UserActions.CREATE_MESSAGE] = "Create a new message";
		menuOptions[MessageApp.UserActions.DISPLAY_MESSAGE] = "Display the current pending message";
		menuOptions[MessageApp.UserActions.SET_SUBJECT] = "Set the current message subject";
		menuOptions[MessageApp.UserActions.SET_BODY] = "Set the current messsage body text";
		menuOptions[MessageApp.UserActions.ADD_RECIPIENT] = "Add a recipient to the message";
		menuOptions[MessageApp.UserActions.ADD_ATTACHMENT] = "Add an attachment to the message";
		menuOptions[MessageApp.UserActions.SAVE_MESSAGE] = "Save the current message";
		menuOptions[MessageApp.UserActions.LOAD_MESSAGE] = "Load a message";
		
		for(int i=0;i<menuOptions.length;i++) {
			displayString(i + " " + menuOptions[i]);
		}
		while(!isGoodInput) {
			userInput = in.readLine();
			
			try {
				userParseInt = Integer.parseInt(userInput);
			}
			catch(NumberFormatException ex) {
				userParseInt = -1;
			}
			if(userParseInt < 0 || userParseInt > menuOptions.length) {
				displayErrorString("Please select an option.");
			}
			else {
				isGoodInput = true;
			}
		}
		return userParseInt;
	}

	public String getAttachmentPath() throws IOException {
		boolean isGoodInput = false;
		String userInput = null;
		while(!isGoodInput) {
			displayString("Please enter the path to the attachment");
			userInput = in.readLine();
			if(userInput.length() == 0) {
				displayErrorString("You have to type something...");
			}
			else {
				isGoodInput = true;
			}
		}
		return userInput;
	}

	public String getRecipient() throws IOException {
		boolean isGoodInput = false;
		String userInput = null;
		while(!isGoodInput) {
			displayString("Please enter the recipient's address: ");
			userInput = in.readLine().trim();
			if(userInput.length() == 0) {
				displayErrorString("You have to type something...");
			}
			else if(!userInput.contains("@") && !userInput.contains(".")) {
				displayErrorString("This doesn't look like an email address.");
			}
			else {
				isGoodInput = true;
			}
		}
		return userInput;
	}

	public void displayString(String string) {
		System.out.println(string);
	}
	
	public void displayErrorString(String string) {
		System.out.println(string);
	}

	public String getMessageBody() throws IOException {
		displayString("Please type the text of the message here:");
		String userInput = in.readLine();
		return userInput;
	}

	public String getMessageSubject() throws IOException {
		boolean isGoodInput = false;
		String userInput = null;
		while(!isGoodInput) {
			displayString("Please enter the message subject:");
			userInput = in.readLine().trim();
			if(userInput.length() == 0) {
				displayErrorString("You have to type something...");
			}
			else {
				isGoodInput = true;
			}
		}
		return userInput;
	}

	public void displayWelcomeString() {
		displayString("Welcome to your Email server.");
		
	}

	public void displayExitString() {
		displayString("Goodbye.");
		
	}

	public void displayMessageCreated() {
		displayString("Message successfully created.");
		
	}

	public void displaySubjectSet() {
		displayString("Subject successfully set.");
		
	}

	public void displayBodySet() {
		displayString("Message body successfully set.");
		
	}
	
	public void displayMessageLoaded() {
		displayString("Message successfully loaded.");
		
	}
	
	public void displayFailedLoad() {
		displayString("Load path does not exist!");
		
	}

	public void displayMessageSaved() {
		displayString("Message successfully saved.");
		
	}

	public boolean checkIfMessageCreated(Email msg) {
		if(msg == null) {
			displayErrorString("You have to create a message first!");
			return false;
		}
		else {
			return true;
		}
	}

	public String loadMessage() throws IOException {
		boolean isGoodInput = false;
		String userInput = null;
		while(!isGoodInput) {
			displayString("Please enter a load flie location: ");
			userInput = in.readLine();
			if(userInput.length() == 0) {
				displayErrorString("You have to type something...");
			}
			else if(!userInput.contains(".")) {
				displayErrorString("Please enter a valid file path.");
			}
			else {
				isGoodInput = true;
			}
		}
		return userInput;
	}

		

	public String saveMessage() throws IOException {
		boolean isGoodInput = false;
		String userInput = null;
		while(!isGoodInput) {
			displayString("Please enter a save flie location: ");
			userInput = in.readLine();
			if(userInput.length() == 0) {
				displayErrorString("You have to type something...");
			}
			else if(!userInput.contains(".")) {
				displayErrorString("Please enter a valid file path.");
			}
			else {
				isGoodInput = true;
			}
		}
		return userInput;
		
	}




}

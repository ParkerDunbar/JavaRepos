package edu.neumont.csc150.messageinterface.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.neumont.csc150.messageinterface.model.Email;
import edu.neumont.csc150.messageinterface.view.MessageUI;

public class MessageApp {
	
	public class UserActions {
		public static final int EXIT = 0;
		public static final int CREATE_MESSAGE = 1;
		public static final int SET_SUBJECT = 2;
		public static final int SET_BODY = 3;
		public static final int ADD_RECIPIENT = 4;
		public static final int ADD_ATTACHMENT = 5;
		public static final int DISPLAY_MESSAGE = 6;
		public static final int SAVE_MESSAGE = 7;
		public static final int LOAD_MESSAGE = 8;
		//public static final int SEND_MESSAGE = 7;
		public static final int COUNT_OF_USER_ACTIONS = 9;
		
	}
	
	private MessageUI ui = new MessageUI();
	private Email msg;
	private String fromEmail;
	private boolean isExitTime = false;
	
	public void run() throws IOException, ClassNotFoundException {
		this.setFromEmail(ui.getFromEmailFromUser());
		ui.displayWelcomeString();
		while(!isExitTime) {
			//get user's selection
			int selection = ui.getMainMenuSelection();
			//handle their selection (create a message, set the sender,
			//set the subject, compose the body, add recipients, add attachments,
			//send the message)
			this.handleUserSelection(selection);
			//(TODO in future version - store message histroy, etc.)
		}
	}

	private void handleUserSelection(int selection) throws IOException, ClassNotFoundException {
		switch(selection) {
		case UserActions.EXIT:
			this.isExitTime = true;
			ui.displayExitString();
			break;
		case UserActions.CREATE_MESSAGE:
			this.msg = new Email();
			this.msg.setSender(this.getFromEmail());
			ui.displayMessageCreated();
			break;
		case UserActions.SET_SUBJECT:
			if(ui.checkIfMessageCreated(this.msg)) {
				this.handleSetSubject();
				ui.displaySubjectSet();
			}
			break;
		case UserActions.SET_BODY:
			if(ui.checkIfMessageCreated(this.msg)) {
				this.handleSetBody();
				ui.displayBodySet();
			}
			break;
		case UserActions.ADD_RECIPIENT:
			if(ui.checkIfMessageCreated(this.msg)) {
				this.handleAddRecipient();
			}
			break;
		case UserActions.ADD_ATTACHMENT:
			if(ui.checkIfMessageCreated(this.msg)) {
				this.handleAddAttachment();
			}
			break;
		case UserActions.DISPLAY_MESSAGE:
			if(ui.checkIfMessageCreated(this.msg)) {
				ui.displayString(this.msg.toString());
			}
			break;
		case UserActions.SAVE_MESSAGE:
			if(ui.checkIfMessageCreated(this.msg)) {
				this.handleSaveMessage();
				ui.displayMessageSaved();
			}
			break;
		case UserActions.LOAD_MESSAGE:
			this.handleLoadMessage();
			break;
		default:
			throw new IllegalArgumentException("unrecognized selection: " + selection);
		}
		
		
	}

	private void handleLoadMessage() throws IOException, ClassNotFoundException {
		String loadPath = ui.loadMessage();
		File load = new File(loadPath);
		if(load.exists()) {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(load));
			Object obj = in.readObject();
			this.msg = (Email)obj;
			this.msg.toString();
			ui.displayMessageLoaded();
		}
		else {
			ui.displayFailedLoad();
		}
		
	}

	private void handleSaveMessage() throws IOException {
		String savePath = ui.saveMessage();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(savePath));
		out.writeObject(this.msg);
		out.close();
		
	}

	private void handleAddAttachment() throws IOException {
		String filePath = ui.getAttachmentPath();
		File attachment = new File(filePath);
		this.msg.addAttachment(attachment);
		
	}

	private void handleAddRecipient() throws IOException {
		String recipient = ui.getRecipient();
		this.msg.addRecipient(recipient);
		
	}

	private void handleSetBody() throws IOException {
		String body = ui.getMessageBody();
		this.msg.setMessageBody(body);
		
	}

	private void handleSetSubject() throws IOException {
		String subject = ui.getMessageSubject();
		this.msg.setSubject(subject);
	}

	/**
	 * @return the username
	 */
	public String getFromEmail() {
		return fromEmail;
	}

	/**
	 * @param username the username to set
	 */
	public void setFromEmail(String username) {
		if(username == null || username.length() == 0) {
			throw new IllegalArgumentException("from email cannot be null");
		}
		this.fromEmail = username;
	}

}

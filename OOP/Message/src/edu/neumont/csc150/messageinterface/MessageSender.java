package edu.neumont.csc150.messageinterface;

import java.io.IOException;

import edu.neumont.csc150.messageinterface.controller.MessageApp;

public class MessageSender {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		MessageApp app = new MessageApp();
		app.run();

	}

}

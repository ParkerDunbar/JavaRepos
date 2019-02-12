package edu.neumont.csc150.publishsubscribe;

import edu.neumont.csc150.TextMessageReceiverExercise.ISMSReceiver;
import edu.neumont.csc150.TextMessageReceiverExercise.SMSCommunicationEngine;

public class Subscribe implements ISMSReceiver{

	public static void main(String[] args) {
		Subscribe receiver = new Subscribe();
		SMSCommunicationEngine engine = new SMSCommunicationEngine();
		engine.registerReceiver(receiver);
		engine.startReceivingMessages(5);
	}

	@Override
	public void messageReceived(String messageText) {
		System.out.println(messageText);
		
	}

}

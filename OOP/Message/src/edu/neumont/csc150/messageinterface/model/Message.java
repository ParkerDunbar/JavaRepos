package edu.neumont.csc150.messageinterface.model;

import java.io.File;

/**
 * Represents methods that should be available
 * in CSC150 implementations of a Message
 * @author rcox
 *
 */
public interface Message {
	
	/**
	 * @param recipient the recipient to add to the message
	 */
	void addRecipient(String recipient);
	
	/**
	 * @param attachmentFile the attachment to add to the message
	 */
	void addAttachment(File attachmentFile);
	
	/**
	 * @param subject the value to set as the message subject
	 */
	void setSubject(String subject);
	
	/**
	 * Sets the message body for this message
	 * @param msg the new message body text
	 */
	void setMessageBody(String msg);
	
	/**
	 * @return the date the message was created
	 * 			formatted as YYYY/MM/DD HH:MM:SS
	 */
	String getCreatedDate();
	
	/**
	 * @return the address of the sender for this message
	 */
	String getSender();

	/**
	 * @return the current message subject
	 */
	String getSubject();
	
	/**
	 * @return the message body text
	 */
	String getMessageBody();
	
	/** 
	 * @return an array of recipients that have been added
	 */
	String[] getRecipients();
	
	/**
	 * @return an array of file attachments that have been added
	 */
	File[] getAttachments();
}
package edu.neumont.csc150.messageinterface.model;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Email implements Message, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subject;
	private String msg;
	private String sender;
	private Calendar createdDate;
	private ArrayList<String> recipients = new ArrayList<>();
	private ArrayList<File> attachments = new ArrayList<>();
	
	public Email() {
		this.createdDate = Calendar.getInstance();
	}
	
	
	@Override
	public void addRecipient(String recipient) {
		if(recipient == null || recipient.length() == 0) {
			throw new IllegalArgumentException("recipient cannot be null or empty");
		}
		if(!this.recipients.contains(recipient)) {
			this.recipients.add(recipient);
		}
	}

	@Override
	public void addAttachment(File attachmentFile) {
		if(attachmentFile == null) {
			throw new IllegalArgumentException("attachmentFile cannot be null");
		}
		if(!this.attachments.contains(attachmentFile)) {
			this.attachments.add(attachmentFile);
		}
	}

	@Override
	public void setSubject(String subject) {
		if(subject == null || subject.length() == 0) {
			throw new IllegalArgumentException("subject cannot be null or empty");
		}
		this.subject = subject;
	}

	@Override
	public void setMessageBody(String msg) {
		if(msg == null) {
			throw new IllegalArgumentException("msg cannot be null");
		}
		this.msg = msg;
		
	}

	@Override
	public String getCreatedDate() {
		SimpleDateFormat fmt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		fmt.setTimeZone(this.createdDate.getTimeZone());
		return fmt.format(this.createdDate.getTime());
	}

	@Override
	public String getSender() {
		return this.sender;
	}

	@Override
	public String getSubject() {
		return this.subject;
	}

	@Override
	public String getMessageBody() {
		return this.msg;
	}

	@Override
	public String[] getRecipients() {
		return this.recipients.toArray(new String[this.recipients.size()]);
	}

	@Override
	public File[] getAttachments() {
		return this.attachments.toArray(new File[this.attachments.size()]);
	}


	public void setSender(String sender) {
		if(sender == null || sender.length() == 0) {
			throw new IllegalArgumentException("sender cannot be null");
		}
		this.sender = sender;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Email)) {
			return false;
		}
		Email other = (Email)obj;
		if(!this.getSender().equals(other.getSender()) ||
				!this.getSubject().equals(other.getSubject()) ||
				!this.getMessageBody().equals(other.getMessageBody())) {
			return false;
		}
		
		if(this.recipients.size() != other.getRecipients().length) {
			return false;
		}
		for(int i=0; i<this.recipients.size(); i++) {
			String curRecipient = other.getRecipients()[i];
			if(!this.recipients.contains(curRecipient)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss a");
		fmt.setTimeZone(this.createdDate.getTimeZone());
		ArrayList<String> fileList = new ArrayList<>();
		for(File file : this.attachments) {
			fileList.add(file.getAbsolutePath());
		}
		String retVal = "Created-Date:" + fmt.format(this.createdDate.getTime()) + "\n" + 
						"FROM: " + this.getSender() + "\n" + 
						"To: " + String.join(", ", this.recipients) + "\n" + 
						"Subject: " + this.getSubject() + "\n" +
						"Message Text: " + this.getMessageBody() + "\n\n" +
						"Attachments: " + String.join("\n\t", fileList) + "\n";
		return retVal;
	}

	
	
}

package curtis.max.model.messages;

import java.util.List;

public class MessageList extends Message {
	public List<ChatMessage> messages;

	public MessageList(List<ChatMessage> msg) {
		this.setType(2);
		this.messages = msg;
	}

	public List<ChatMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ChatMessage> messages) {
		this.messages = messages;
	}
}

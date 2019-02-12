package curtis.max.endpoints;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/endpoint")
public class EndPointChat {
	private static List<EndPointChat> users = new CopyOnWriteArrayList<>();
	private static List<String> messages = new CopyOnWriteArrayList<>();
	private static List<String> userList = new CopyOnWriteArrayList<>();
	Session sesssion;
/*
 * adds a user when a connetion is made 
 */
	@OnOpen
	public void onOpen(Session session) {
		this.sesssion = session;
		users.add(this);
	}
/*
 * romeves user when conetion is closed and removes lists if all conetions are closed
 */
	@OnClose
	public void onClose(Session session) {
		users.remove(this);
		if (users.size() == 0) {
			messages.removeAll(messages);
			userList.removeAll(userList);
		}
	}
/**
 * check if a new user msg or a chat msg sends proper lists back 
 * 
 * @param message the text for the message 
 */
	@OnMessage
	public void onMessage(String message) {
		if (message.contains("X#$$#X")) {
			userList.add(message);
			broadcast(userList);
		} else {
			messages.add(message);
			broadcast(messages);
		}
	}

	/**
	 * send message to all active listiners 
	 * @param message the list that is going to be brodcast 
	 */
	private void broadcast(List<String> message) {
		for (EndPointChat user : users) {
			try {
				String msg = "";
				for (int i = 0; i < message.size(); i++) {
					msg += message.get(i);
					msg += "\n";
				}
				user.sesssion.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				users.remove(this);
				try {
					user.sesssion.close();
				} catch (IOException e1) {
					e.printStackTrace();
				}
			}
		}
	}

}

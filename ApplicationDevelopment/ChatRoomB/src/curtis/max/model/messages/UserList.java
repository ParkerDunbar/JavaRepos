package curtis.max.model.messages;

import java.util.List;

import curtis.max.model.users.User;

public class UserList extends Message {
	public List<User> users;

	public UserList(List<User> users) {
		this.setType(1);
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

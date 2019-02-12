package dunbar.parker.gen;

import java.util.ArrayList;

import com.neufree.contacts.Contact;

public class ListTest {

	public static void main(String[] args) {
		GenList<Contact> list = new GenList();
		list.add(new Contact());
//		list.add("Hello");
//		list.add(54);
//		list.add(1.5);
		
		ArrayList<String> arrayList = new ArrayList();
		arrayList.add("My String");
		
		countInstances(list, Student.class);
	}
	
	public static <T extends Contact> Contact findFirst(GenList<Contact> list, Class<T> type) {
		for(int i = 0; i < 10; i++) {
			Contact c = list.get(i);
			if (type.isAssignableFrom(c.getClass())) {
				return type.cast(c);
			}
		}
		return null;
	}

	public static <T extends Contact> int countInstances(GenList<Contact> list, Class<T> type) {
		int count = 0;
		for(int i = 0; i < 10; i++) {
			Contact c = list.get(i);
			if(type.isAssignableFrom(c.getClass())) {
				count++;
			}
		}
		return count;
	}
}

class Student extends Contact {
	
}

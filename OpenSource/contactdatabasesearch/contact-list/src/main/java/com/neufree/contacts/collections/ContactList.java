package com.neufree.contacts.collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neufree.contacts.Contact;

public class ContactList extends ArrayList<Contact> {
	private static final long serialVersionUID = 1L;
	
	private Map<String, List<Integer>> nameIndex = new HashMap<>();
	
	//Separate file for each hashmap
	//ObjectOutputStream when serializing to file
	//Save it when updated
	
	@Override
	public boolean add(Contact c) {
		List<Integer> indexList = nameIndex.get(c.getFirstName());
		if(indexList == null) {
			indexList = new ArrayList<>();
			nameIndex.put(c.getFirstName(), indexList);
		}
		indexList.add(this.size());
		return super.add(c);
	}
	
	public List<Contact> searchByName(String name) {
		List<Integer> index = nameIndex.get(name); 
		if(index == null) {
			return null;
		}
		List<Contact> contactList = new ArrayList<>();
		for(Integer i : index) {
			contactList.add(this.get(i));
		}
		return contactList;
		
		
//		for(Contact c : this) {
//			if(c.getName().equals(name)) {
//				return c;
//			}
//		}
//		return null;
	}
	
	public void save(String filePath) throws IOException {
		try(FileOutputStream out = new FileOutputStream(filePath)) {
			try(ObjectOutputStream obj = new ObjectOutputStream(out)) {
				obj.writeObject(this);
			}
		}
	}
	
	public void load(String filePath) throws IOException, ClassNotFoundException {
		try(FileInputStream in = new FileInputStream(filePath)) {
			try(ObjectInputStream obj = new ObjectInputStream(in)) {
				Object rawObj = obj.readObject();
				ContactList loaded = ((ContactList)rawObj);
				this.clear();
				this.addAll(loaded);
			}
		}
	}
	
	public void sortByName() {
		Comparator<Contact> cmp = new Comparator<Contact>() {
			public int compare(Contact o1, Contact o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		};
		this.sort(cmp);
	}
	
}

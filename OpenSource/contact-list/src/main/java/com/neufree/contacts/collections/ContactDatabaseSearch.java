package com.neufree.contacts.collections;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neufree.contacts.Contact;

public class ContactDatabaseSearch {
private RandomAccessFile file;
	
	private int nextOffset = 8;
	
	private Map<String, List<Integer>> firstNameIndex = new HashMap<>();
	private Map<String, List<Integer>> lastNameIndex = new HashMap<>();
	private Map<String, List<Integer>> primaryEmailIndex = new HashMap<>();
	private Map<String, List<Integer>> primaryPhoneIndex = new HashMap<>();
	
	//Separate file for each hashmap
	//ObjectOutputStream when serializing to file
	//Save it when updated
	
	public ContactDatabaseSearch(String path) throws IOException, ClassNotFoundException {
		boolean readOffsetFromFile = new File(path).exists();
		file = new RandomAccessFile(path, "rw");
		if(readOffsetFromFile) {
			nextOffset = file.readInt();
		}
		
		boolean serializedFilesExist = new File("firstname.ser").exists();
		if(serializedFilesExist) {
			loadHashMap("firstname.ser");
			loadHashMap("lastname.ser");
			loadHashMap("primaryEmail.ser");
			loadHashMap("primaryPhone.ser");
		}
	}
	
	//First Name
	public List<Contact> searchByFirstName(String firstName) throws IOException {
		List<Integer> indecies = firstNameIndex.get(firstName);
		List<Contact> results = new ArrayList<>();
		if(indecies == null) {
			return new ArrayList<>();
		}
		
		for(Integer index : indecies) {
			Contact c = this.read(index);
			results.add(c);
		}
		return results;
	}
	private void addToFirstNameIndex(Contact c, int index) {
		List<Integer> list = firstNameIndex.get(c.getFirstName());
		if(list == null) {
			list = new ArrayList<>();
			firstNameIndex.put(c.getFirstName(), list);
		}
		list.add(index);
	}
	
	//Last Name
	public List<Contact> searchByLastName(String lastName) throws IOException {
		List<Integer> indecies = lastNameIndex.get(lastName);
		List<Contact> results = new ArrayList<>();
		if(indecies == null) {
			return new ArrayList<>();
		}
		
		for(Integer index : indecies) {
			Contact c = this.read(index);
			results.add(c);
		}
		return results;
	}
	private void addToLastNameIndex(Contact c, int index) {
		List<Integer> list = lastNameIndex.get(c.getLastName());
		if(list == null) {
			list = new ArrayList<>();
			lastNameIndex.put(c.getLastName(), list);
		}
		list.add(index);
	}
	
	//Primary Email
	public List<Contact> searchByPrimaryEmail(String primaryEmail) throws IOException {
		List<Integer> indecies = primaryEmailIndex.get(primaryEmail);
		List<Contact> results = new ArrayList<>();
		if(indecies == null) {
			return new ArrayList<>();
		}
		
		for(Integer index : indecies) {
			Contact c = this.read(index);
			results.add(c);
		}
		return results;
	}
	private void addToPrimaryEmailIndex(Contact c, int index) {
		List<Integer> list = primaryEmailIndex.get(c.getPrimaryEmail());
		if(list == null) {
			list = new ArrayList<>();
			primaryEmailIndex.put(c.getPrimaryEmail(), list);
		}
		list.add(index);
	}
	
	//Primary Phone
	public List<Contact> searchByPrimaryPhone(String primaryPhone) throws IOException {
		List<Integer> indecies = primaryPhoneIndex.get(primaryPhone);
		List<Contact> results = new ArrayList<>();
		if(indecies == null) {
			return new ArrayList<>();
		}
		
		for(Integer index : indecies) {
			Contact c = this.read(index);
			results.add(c);
		}
		return results;
	}
	private void addToPrimaryPhoneIndex(Contact c, int index) {
		List<Integer> list = primaryPhoneIndex.get(c.getPrimaryPhone());
		if(list == null) {
			list = new ArrayList<>();
			primaryPhoneIndex.put(c.getPrimaryPhone(), list);
		}
		list.add(index);
	}
	
	
	public void insert(Contact c) throws IOException {
		addToFirstNameIndex(c, (nextOffset - 8) / 1044);
		addToLastNameIndex(c, (nextOffset - 8) / 1044);
		addToPrimaryEmailIndex(c, (nextOffset - 8) / 1044);
		addToPrimaryPhoneIndex(c, (nextOffset - 8) / 1044);
		saveHashMap("firstname.ser", firstNameIndex);
		saveHashMap("lastname.ser", lastNameIndex);
		saveHashMap("primaryemail.ser", primaryEmailIndex);
		saveHashMap("primaryphone.ser", primaryPhoneIndex);
		
		
		byte[] buffer;
		String byteArray = c.serialize();
		buffer = byteArray.getBytes();
		
		file.seek(nextOffset);
		file.write(buffer);
		nextOffset += buffer.length;
		updateNextOffset();
	}
	
	private void updateNextOffset() throws IOException {
		int currentOffset = nextOffset;
		file.seek(0);
		file.writeInt(currentOffset);
	}
	
	public Contact read(int index) throws IOException {
		byte[] buffer = new byte[1044];
		int byteSeek = 8 + (index * 1044);
		file.seek(byteSeek);
		file.readFully(buffer);
		
		Contact c = new Contact();
		c = c.deserialize(buffer);
		return c;
	}
	
	private void saveHashMap(String filePath, Map<String, List<Integer>> hash) throws IOException {
		try(FileOutputStream out = new FileOutputStream(filePath)) {
			try(ObjectOutputStream obj = new ObjectOutputStream(out)) {
				obj.writeObject(hash);
			}
		}
	}
	
	public void loadHashMap(String filePath) throws IOException, ClassNotFoundException {
		try(FileInputStream in = new FileInputStream(filePath)) {
			try(ObjectInputStream obj = new ObjectInputStream(in)) {
				if(filePath == "firstname.ser") {
					firstNameIndex = (Map<String, List<Integer>>) obj.readObject();
				}
				if(filePath == "lastname.ser") {
					lastNameIndex = (Map<String, List<Integer>>) obj.readObject();
				}
				if(filePath == "primaryEmail.ser") {
					primaryEmailIndex = (Map<String, List<Integer>>) obj.readObject();
				}
				if(filePath == "primaryPhone.ser") {
					primaryPhoneIndex = (Map<String, List<Integer>>) obj.readObject();
				}
				obj.close();
				in.close();
				System.out.println("Load successful");
				
//			      Set set = hash.entrySet();
//			      Iterator iterator = set.iterator();
//			      while(iterator.hasNext()) {
//			         Map.Entry mentry = (Map.Entry)iterator.next();
//			         System.out.print("key: "+ mentry.getKey() + " & Value: ");
//			         System.out.println(mentry.getValue());
//			      }
			}
		}
	}
}

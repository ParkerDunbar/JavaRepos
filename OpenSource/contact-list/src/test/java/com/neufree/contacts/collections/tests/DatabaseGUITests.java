package com.neufree.contacts.collections.tests;

import java.io.IOException;
import java.util.Random;
import com.neufree.contacts.Contact;
import com.neufree.contacts.collections.ContactDatabase;

public class DatabaseGUITests {

	public static void main(String[] args) throws IOException {
		ContactDatabase d = new ContactDatabase("C:\\Users\\Parker Dunbar\\OpenSource\\contact-list\\test.txt");
//		Random r = new Random();
//		String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String num = "0123456789";
//		int alphL = alph.length();
//		int numL = num.length();
//		
//		long startTime = System.nanoTime();
//		for(int i = 0; i < 3000; i++) {
//			String firstName = "", lastName = "", priEmail = "", secEmail = "", priPhone = "", secPhone = "";
//			for(int j = 0; j < 5; j++) {
//				firstName += alph.charAt(r.nextInt(alphL));
//				lastName += alph.charAt(r.nextInt(alphL));
//				priEmail += alph.charAt(r.nextInt(alphL));
//				secEmail += alph.charAt(r.nextInt(alphL));
//				priPhone += num.charAt(r.nextInt(numL));
//				secPhone += num.charAt(r.nextInt(numL));
//			}
//			Contact c = new Contact(firstName, lastName, priEmail, secEmail, priPhone, secPhone);
//			d.insert(c);
//		}
		
		Contact c = new Contact();
		c = d.read(7);
		System.out.println(c);
		c = d.read(500);
		System.out.println(c);
		c = d.read(2000);
		System.out.println(c);

	}

}

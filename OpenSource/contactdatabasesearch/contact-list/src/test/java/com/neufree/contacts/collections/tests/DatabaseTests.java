package com.neufree.contacts.collections.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Random;

import org.junit.Test;

import com.neufree.contacts.Contact;
import com.neufree.contacts.collections.ContactDatabase;

public class DatabaseTests {

	@Test
	public void test() throws IOException {
		ContactDatabase d = new ContactDatabase("C:\\Users\\Parker Dunbar\\OpenSource\\contact-list\\test.txt");
		Random r = new Random();
		String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String num = "0123456789";
		int alphL = alph.length();
		int numL = num.length();
		
		long startTime = System.nanoTime();
		for(int i = 0; i < 3000; i++) {
			String firstName = "", lastName = "", priEmail = "", secEmail = "", priPhone = "", secPhone = "";
			for(int j = 0; j < 5; j++) {
				firstName += alph.charAt(r.nextInt(alphL));
				lastName += alph.charAt(r.nextInt(alphL));
				priEmail += alph.charAt(r.nextInt(alphL));
				secEmail += alph.charAt(r.nextInt(alphL));
				priPhone += num.charAt(r.nextInt(numL));
				secPhone += num.charAt(r.nextInt(numL));
			}
			Contact c = new Contact(firstName, lastName, priEmail, secEmail, priPhone, secPhone);
			d.insert(c);
		}
		long endTime = System.nanoTime();
		System.out.println("Request Completed in "+ ((endTime - startTime) /1000000.0) + " ms");
		
		
		Contact c = new Contact();
		startTime = System.nanoTime();
		c = d.read(7);
		System.out.println(c);
		c = d.read(500);
		System.out.println(c);
		c = d.read(2000);
		System.out.println(c);
		endTime = System.nanoTime();
		System.out.println("Request Completed in "+ ((endTime - startTime) /1000000.0) + " ms");
	}

}

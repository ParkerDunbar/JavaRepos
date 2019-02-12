package edu.neumont.csc150.simplefile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

public class SimpleFile {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person p = new Person("Collin", "Broke", 511012311);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.sav"));
		out.writeObject(p);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.sav"));
		Object obj = in.readObject();
		Person p2 = (Person)obj;
		System.out.println(p2.toString());
		
		
		
		/*
		 * READER
		 */
		
		/*
		//FileInputStream inFile = new FileInputStream("text.txt");
		//InputStreamReader inFileReader = new InputStreamReader(inFile);
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("text.txt")));
		
		while(in.ready()) {
			String line = in.readLine();
			System.out.println(line);
		}
		
		in.close();
		*/
		

		
		/*
		 * WRITER
		 */
		
		/*
		//InputStreamReader inFile = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		//OutputStream outFile = new FileOutputStream("text.txt");
		PrintStream out = new PrintStream(new FileOutputStream("text.txt"));
		
		final int NUM_LINES = 3;
		for(int i=0;i<NUM_LINES;i++) {
			System.out.println("Enter a line that I will write to the file for you...");
			String line = in.readLine();
			out.println(line);
		}
		
		out.close();
		*/
	}

}

package edu.neumont.csc150.filewriter;

import java.io.File;
import java.io.IOException;

public class FileWriter {

	public static void main(String[] args) throws IOException {
		FileInputOutput io = new FileInputOutput();
		File file = new File("mytest.txt");
		io.setOutputToFile(file);
		
		System.out.println("Please enter the first line: ");
		String line1 = io.readTextLine();
		io.writeTextLine(line1);
		System.out.println("Please enter the second line: ");
		String line2 = io.readTextLine();
		io.writeTextLine(line2);
		System.out.println("Please enter the thrid line: ");
		String line3 = io.readTextLine();
		io.writeTextLine(line3);
		

	}

}

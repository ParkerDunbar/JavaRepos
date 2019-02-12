package edu.neumont.csc150.hellofile;

import java.io.File;
import java.io.FileNotFoundException;

public class HelloFile {

	public static void main(String[] args) throws FileNotFoundException {
		HelloInputOutput io = new HelloInputOutput();
		File file = new File("mytest.txt");
		
		//io.setOutputToFile(file);
		//io.writeTextLine("Hello World");
		io.setInputToFile(file);
		String line = io.readTextLine();
		System.out.println(line);
		String line2 = io.readTextLine();
		System.out.println(line2);
		
				

	}

}

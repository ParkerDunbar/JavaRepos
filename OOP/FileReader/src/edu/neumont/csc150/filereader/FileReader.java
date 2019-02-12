package edu.neumont.csc150.filereader;

import java.io.File;
import java.io.IOException;

public class FileReader {

	public static void main(String[] args) throws IOException {
		FileInputOutput io = new FileInputOutput();
		File file = new File("mytest.txt");
		
		io.setInputToFile(file);
		while(io.ready()) {
			String allLines = io.readText();
			System.out.println(allLines);
		}

	}

}

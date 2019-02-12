package edu.neumont.csc150.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputOutput {
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public void setInputToFile(File file) throws FileNotFoundException {
		in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));	
	}
	
	public String readText() throws IOException {
		return in.readLine();
	}
	
	public boolean ready() throws IOException {
		if(in.ready()) {
			return true;
		}
		return false;
	}

}

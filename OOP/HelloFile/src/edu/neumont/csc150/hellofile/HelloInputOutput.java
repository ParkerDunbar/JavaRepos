package edu.neumont.csc150.hellofile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class HelloInputOutput {
	private PrintStream out = System.out;
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void writeTextLine(String text) {
		out.println(text);
	}
	
	public String readTextLine() {
		try {
			return in.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setInputToFile(File file) throws FileNotFoundException {
		in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	}
	
	
	public void setOutputWriter(PrintStream writer) {
		this.out = writer;
	}
	
	public void setOutputToFile(File file) {
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fileOut);
			this.out = ps;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package edu.neumont.csc150.observer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Traffic {

	public static void main(String[] args) {
		StreetLight light = new StreetLight();
		Driver driver1 = new Driver();
		Driver driver2 = new Driver();
		
		light.subscribe(driver1);
		light.subscribe(driver2);
		keepAppOpen();

	}
	
	private static void keepAppOpen() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			in.readLine();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}

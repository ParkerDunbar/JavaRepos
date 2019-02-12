package edu.neumont.csc110.d.shiftcipher;

import java.io.IOException;

public class Vinegere {

	public static void main(String[] args) throws IOException {
		String plainText = ConsoleUI.promptForInput("Enter your secret message", false);
		String key = ConsoleUI.promptForInput("Enter the secret key", false);
		
		String cipherText = Cipher.encrypt(plainText, key);
		System.out.println("Encrypted text = " + cipherText);
		

	}
	
}

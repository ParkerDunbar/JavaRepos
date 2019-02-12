package edu.neumont.csc110.d.shiftcipher;

public class Cipher {
	
	public static final int COUNT_CHARS_IN_ALPHA = 26;
	
	static char[] alpha;
	
	
	public static String encrypt(String plainText, String key) {
		String expandedKey = expandKey(key, plainText.length());
		initArray();
		String cipher = "";
		for(int i=0; i<plainText.length(); i++){
			char plainChar = plainText.charAt(i);
			char keyChar = expandedKey.charAt(i);
			char cipherChar = (char) (plainChar - 97 + keyChar - 97);
			if(cipherChar >= COUNT_CHARS_IN_ALPHA){
				cipherChar -= COUNT_CHARS_IN_ALPHA;
			}
			cipherChar = alpha[cipherChar];
			
			cipher += cipherChar;
		}
		
		return cipher;
	}
	
	
	private static String expandKey(String key, int length) {
		String result = "";
		int i = 0;
		while(result.length() != length) {
			result += key.charAt(i);
			i++;
			if(i >= key.length()) {
				i = 0;
			}
		}
		
		return result;
	}

	private static void initArray() {
		if (alpha == null) {
			alpha = new char[COUNT_CHARS_IN_ALPHA];
			for (int i = 0; i < COUNT_CHARS_IN_ALPHA; i++) {
				alpha[i] = (char) (97 + i);
				System.out.print(alpha[i] + " ");
			}
			System.out.println();
		}
		
	}
}
	
	
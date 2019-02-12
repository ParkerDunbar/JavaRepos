package dunbar.parker.csc252;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Network {

	public static void main(String[] args) throws IOException {
		String filePath = getValidFilePath();
	}

	private static String getValidFilePath() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean notValid = true;
		String filePath = "";
		while (notValid) {
			// C:\Users\Parker Dunbar\Downloads\IsomorphInput1.txt
			System.out.println("Please enter a valid file path:");
			filePath = reader.readLine();
			File input = new File(filePath);
			if (input.exists() && !input.isDirectory()) {
				notValid = false;
			} else {
				System.out.println("Not a valid file path.");
			}
		}
		return filePath;
	}
}

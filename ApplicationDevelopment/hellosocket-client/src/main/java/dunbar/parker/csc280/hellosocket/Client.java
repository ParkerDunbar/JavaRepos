package dunbar.parker.csc280.hellosocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Socket sock = new Socket("localhost", Integer.parseInt(args[0]));
		System.out.println("Client connected to Server.");
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();

		while (true) {
			System.out.println("Enter a message to send to the Server:");
			String userInput = reader.readLine();

			System.out.println("Client says: " + userInput);
			userInput += "\n";
			out.write(userInput.getBytes());
			Thread.sleep(1000);
			
			int b;
			String input = "";
			while ((b = in.read()) != -1 && b != 10) {
				input += (char) b;
			}
			System.out.println("Server says: " + input);
		}

	}

}
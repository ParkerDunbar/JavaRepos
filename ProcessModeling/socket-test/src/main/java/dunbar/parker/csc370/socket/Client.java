package dunbar.parker.csc370.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		try(Socket sock = new Socket("localhost", 2500)) {
			System.out.println("Connection established");
			try (PrintStream out = new PrintStream(sock.getOutputStream())) {
				System.out.println("Sending text: \"Hello\"");
				out.println("Hello");
				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String line = in.readLine();
				System.out.println("Server said: \"" + line + "\"");
			}
		}
	}
}
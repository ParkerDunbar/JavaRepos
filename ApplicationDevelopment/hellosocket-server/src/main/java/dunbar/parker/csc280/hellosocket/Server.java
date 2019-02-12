package dunbar.parker.csc280.hellosocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("Waiting for Client connection...");
		ServerSocket servSock = new ServerSocket(Integer.parseInt(args[0]));
		Socket sock = servSock.accept();
		System.out.println("Server connected to Client.");
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();

		while (true) {
			int b;
			String input = "";
			while ((b = in.read()) != -1 && b != 10) {
				input += (char) b;
			}
			System.out.println("Recieved from Client: " + input);
			System.out.println("Sending to Client: " + input);
			input += "\n";
			out.write(input.getBytes());
		}

	}

}

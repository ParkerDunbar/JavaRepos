package dunbar.parker.csc280.hellosocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket sock = new Socket("localhost", 8080);
		
		OutputStream out = sock.getOutputStream();
		String sendMe = "Hello";
		int length = sendMe.length();
		String strLen = String.format("%4d", length);
		out.write(strLen.getBytes());
		out.write(sendMe.getBytes());
	}

}

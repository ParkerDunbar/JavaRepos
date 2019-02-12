package dunbar.parker.csc280.hellosocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket servSock = new ServerSocket(8080);
		Socket sock = servSock.accept();
		
		byte[] received = new byte[4];
		InputStream in = sock.getInputStream();
		in.read(received);
		String readString = new String(received);
		int readSize = Integer.parseInt(readString);
		byte[] body = new byte[readSize];
	}

}
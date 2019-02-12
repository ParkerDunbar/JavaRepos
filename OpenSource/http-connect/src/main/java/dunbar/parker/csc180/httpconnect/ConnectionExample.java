package dunbar.parker.csc180.httpconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionExample {

	public void run() throws IOException {
		String strURL = "http://google.com/";
		URL url = new URL(strURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		try {
			try (InputStream in = con.getInputStream()) {
				//try (BufferedReader inReader = new BufferedReader(new InputStreamReader(in))) {
				String pageContent = "";
				int current = 0;
				while((current = in.read()) != -1) {
					byte[] buf = new byte[1];
					buf[0] = (byte)current;
					pageContent += new String(buf);
				}
				System.out.println(pageContent);
//					while (inReader.ready()) {
//						String line = inReader.readLine() + "\r\n";
//						System.out.println(line);
//					}
				//}
			}
		}
		finally {
			con.disconnect();
		}
	}

	public static void main(String[] args) throws IOException {
		ConnectionExample ce = new ConnectionExample();
		ce.run();
	}

}

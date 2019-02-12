package dunbar.parker.csc280.httpserver;

import java.io.IOException;

public class ServerStart {

	public static void main(String[] args) {
		HttpServer server = new HttpServer(8080);
		server.run();
	}

}

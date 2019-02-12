package dunbar.parker.csc280.httpserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class HttpServer {

	public enum HttpMethod {
		Get, Post, Error
	}
	private ServerSocket servSock;
	private SocketIOManager socketIO = new SocketIOManager();
	private String directory = "C:\\Users\\Parker Dunbar\\Desktop\\www\\";

	public HttpServer(int port) {
		try {
			servSock = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try (Socket socket = servSock.accept() ){
			// Read the http request
			Map<String, String> headers = socketIO.readHttpRequestHeaders(socket.getInputStream());
			// Determine request type
			HttpMethod requestMethod = determineRequestType(headers);
			// Take action (load the file etc)
			switch(requestMethod) {
			case Get:
				String path = determineGetPath(headers);
				String type = getType(path);
				String file = getFile(path);
				socketIO.writeHttpResponseHeaders(socket.getOutputStream(), type, file.length());
				socketIO.writeHttpResponseBody(socket.getOutputStream(), file);
				break;
			case Post:
				String fileName = determineFilename(headers);
				System.out.println(fileName);
				String contents = socketIO.readHttpRequestBody(socket.getInputStream());
				System.out.println(contents);
				String output = "<html><body><H1>SUCCESS</H1></body></html>";
				writeFile(fileName, contents);
				socketIO.writeHttpResponseHeaders(socket.getOutputStream(), "text/xml", -1);
				break;
			default:
				break;
			}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void writeFile(String fileName, String contents) throws IOException {
		String fileDirectory = "C:\\Users\\Parker Dunbar\\Desktop\\www\\upload\\" + fileName;
		FileWriter out = new FileWriter(fileDirectory);
		out.write(contents);
	}

	private String determineFilename(Map<String, String> headers) {
		String request = headers.get("CMD");
		request = request.substring(6, request.length() - 8);
		request = request.trim();
		return request;
	}

	private String getFile(String path) throws IOException {
		String filePath = "";
		if(path.length() == 1) {
			filePath = directory + "index.html";
		}
		else {
			filePath = directory + path.substring(1);
		}
		
		File file = new File(filePath);
		FileReader in = new FileReader(file);
		
		char[] charBuffer = new char[(int) file.length()];
		int fileLength = in.read(charBuffer);
		
		String html = "";
		for(int i = 0; i < fileLength; i++) {
			html += charBuffer[i];
		}
		return html;
	}
	
	private String getType(String path) {
		String type;
		if(path.contains(".css")) {
			type = "text/css";
		}
		else {
			type = "text/html";;
		}
		return type;
	}

	private String determineGetPath(Map<String, String> headers) {
		String request = headers.get("CMD");
		request = request.substring(4, request.length() - 8);
		request = request.trim();
		return request;
	}

	private HttpMethod determineRequestType(Map<String, String> headers) {
		String request = headers.get("CMD");
		if(request.contains("GET")) {
			return HttpMethod.Get;
		}
		else if(request.contains("POST")) {
			return HttpMethod.Post;
		}
		else {
			return HttpMethod.Error;
		}
	}
	
	
	/* Example HTTP response (good)
	 * 
	 * HTTP/1.0 200 OK
	 * Content-type: text/html
	 * Content-length: 237
	 * 
	 * <html>...</html>
	 * 
	 * 
	 * Example HTTP reponse (bad)
	 * 
	 * HTTP/1.0 404 NotFound
	 * Content-type: text/html
	 * Content-length: 644
	 * 
	 * <html> <body> <h1>File not found</h1> </body> </html>
	 */
}

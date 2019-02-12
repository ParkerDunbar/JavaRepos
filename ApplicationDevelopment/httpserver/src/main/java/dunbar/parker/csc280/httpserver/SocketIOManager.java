package dunbar.parker.csc280.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class SocketIOManager {

	private String SL200 = "HTTP/1.0 200 OK";
	private String CT = "Content-type: ";
	private String CL = "Content-length: ";
	private String END = "\r\n";

	public Map<String, String> readHttpRequestHeaders(InputStream in) throws IOException {
		String rawHeaders = readToTerminalSymbol(in, "\r\n\r\n");
		Map<String, String> headers = new HashMap<>();
		String[] headersArray = rawHeaders.split("\r\n");
		for (String h : headersArray) {
			h = h.trim();
			System.out.println(h);
			String[] kvArr = h.split(": ");
			if (kvArr.length == 2) {
				headers.put(kvArr[0].trim(), kvArr[1].trim());
			} else {
				headers.put("CMD", h);
			}
		}
		return headers;
	}

	public String readHttpRequestBody (InputStream in) throws IOException {
		String contents = "";
		int length = in.available();
		for(int i = 0; i < length; i++) {
			contents += (char) in.read();
		}
		return contents;
	}

	public void writeHttpResponseHeaders(OutputStream out, String type, int length) throws IOException {
		
		String headResponse = "";
		headResponse += SL200;
		headResponse += END;
		headResponse += CT;
		headResponse += type;
		headResponse += END;
		if(length == -1) {
			headResponse += CL;
			headResponse += length;
			headResponse += END;
		}
		headResponse += 
		headResponse += END;
		
		out.write(headResponse.getBytes());
		out.flush();
	}

	public void writeHttpResponseBody(OutputStream out, String bodyData) throws IOException {
		out.write(bodyData.getBytes());
		out.flush();
	}

	public String readToTerminalSymbol(InputStream in, String ts) throws IOException {
		int b;
		String readIn = "";
		while ((b = in.read()) != -1) {
			readIn += (char) b;
			if (readIn.endsWith(ts)) {
				break;
			}
		}
		return readIn;
	}

	public String readKnownLength(InputStream in, int size) {
		return null;
	}
}

package dunbar.parker.csc280;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("In doGet");
//		resp.setStatus(217);
		resp.addHeader("Content-type", "text/html");
		resp.getOutputStream().println("Is it me you're looking for?");
//		throw new RuntimeException("Wrong");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType(req.getContentType());
		//Reading body of post request is assignment
		byte[] buffer = new byte[req.getInputStream().available()];
		req.getInputStream().read(buffer);
		String stringBody = new String(buffer);
		resp.getOutputStream().println(stringBody);
	}

}

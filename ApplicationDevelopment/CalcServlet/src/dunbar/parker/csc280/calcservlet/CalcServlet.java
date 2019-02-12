package dunbar.parker.csc280.calcservlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/add", "/subtract", "/multiply", "/divide"})
public class CalcServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String query = req.getQueryString();
		String URI = req.getRequestURI();
		String operand1;
		String operand2;
		Double o1 = 0.0;
		Double o2 = 0.0;
		Boolean incorrect = true;
		
		if(query != null) {
			incorrect = false;
			operand1 = req.getParameter("operand1");
			System.out.println(operand1);
			operand2 = req.getParameter("operand2");
			System.out.println(operand2);
			o1 = Double.parseDouble(operand1);
			o2 = Double.parseDouble(operand2);
		}
		
		
		String html = "<H1>Your answer is: ";
		Double output;
		switch (URI) {
		case "/CalcServlet/add":
			if(!incorrect) {
				output = o1 + o2;
				resp.getOutputStream().println(html + output + "</H1>");
			}
			else {
			resp.getOutputStream().println("Add\nInvalid operands");
			resp.setStatus(500);
			}
			break;
		case "/CalcServlet/subtract":
			if(!incorrect) {
				output = o1 - o2;
				resp.getOutputStream().println(html + output + "</H1>");
			}
			else {
			resp.getOutputStream().println("Subtract\nInvalid operands");
			resp.setStatus(500);
			}
			break;
		case "/CalcServlet/multiply":
			if(!incorrect) {
				output = o1 * o2;
				resp.getOutputStream().println(html + output + "</H1>");
			}
			else {
			resp.getOutputStream().println("Multiply\nInvalid operands");
			resp.setStatus(500);
			}
			break;
		case "/CalcServlet/divide":
			if(!incorrect) {
				output = o1 / o2;
				resp.getOutputStream().println(html + output + "</H1>");
			}
			else {
				resp.getOutputStream().println("Divide\nInvalid operands");
				resp.setStatus(500);
			}
			break;
		default:
			resp.setStatus(404);
			resp.getOutputStream().println("Request Not Found");
			break;
		}
	}
}



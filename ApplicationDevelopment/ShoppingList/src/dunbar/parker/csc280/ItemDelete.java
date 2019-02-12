package dunbar.parker.csc280;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ItemDelete
 */
@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delItemNum = request.getParameter("deleteItemNumber");
		int itemNum = Integer.parseInt(delItemNum) - 1;
		
		HttpSession session = request.getSession(true);
		List<Item> items = (List<Item>) session.getAttribute("itemlist");
		
		items.remove(itemNum);
		
		session.setAttribute("itemlist", items);
		RequestDispatcher d = request.getRequestDispatcher("shoppinglist.jsp");
		d.forward(request, response);
		
		
	}

}

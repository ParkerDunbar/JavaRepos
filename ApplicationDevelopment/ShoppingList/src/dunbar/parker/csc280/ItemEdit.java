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
 * Servlet implementation class ItemEdit
 */
@WebServlet("/ItemEdit")
public class ItemEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inItemNumber = request.getParameter("editItemNumber");
		int itemNum = Integer.parseInt(inItemNumber) - 1;
		String AttrName = request.getParameter("editAttributeName");
		String Attr = request.getParameter("editAttribute");
		
		HttpSession session = request.getSession(true);
		List<Item> items = (List<Item>) session.getAttribute("itemlist");
		
		switch (AttrName.toLowerCase()) {
		case "name":
			items.get(itemNum).setName(Attr);
			break;
		case "description":
			items.get(itemNum).setDesc(Attr);
			break;
		case "quantity":
			int qty = Integer.parseInt(Attr);
			items.get(itemNum).setQty(qty);
			break;
		case "price":
			double price = Double.parseDouble(Attr);
			items.get(itemNum).setPrice(price);
			break;
		default:
			break;
		}
		
		session.setAttribute("itemlist", items);
		RequestDispatcher d = request.getRequestDispatcher("shoppinglist.jsp");
		d.forward(request, response);
		
	}

}

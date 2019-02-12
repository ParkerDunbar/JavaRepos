package dunbar.parker.csc280;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingList
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Item> itemList = new ArrayList<>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("itemname");
		String desc = request.getParameter("itemdesc");
		String itmqty = request.getParameter("itemqty");
		int qty = Integer.parseInt(itmqty);
		String itmprice = request.getParameter("itemprice");
		double price = Double.parseDouble(itmprice);
		
		Item item = new Item(name, desc, qty, price);
		itemList.add(item);
		

		HttpSession session = request.getSession(true);
		session.setAttribute("itemlist", itemList);
		
		RequestDispatcher d = request.getRequestDispatcher("shoppinglist.jsp");
		d.forward(request, response);
	}

}

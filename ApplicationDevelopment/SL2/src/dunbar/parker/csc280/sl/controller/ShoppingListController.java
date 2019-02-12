package dunbar.parker.csc280.sl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dunbar.parker.csc280.sl.model.ShoppingList;
import dunbar.parker.csc280.sl.model.User;

@WebServlet("/ShoppingList")
public class ShoppingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("shoppinglist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String httpMethod = request.getParameter("http_method");
		if (httpMethod != null && httpMethod.equalsIgnoreCase("delete")) {
			doDelete(request, response);
			return;
		} else if (httpMethod != null && httpMethod.equalsIgnoreCase("put")) {
			doPut(request, response);
			return;
		}
		String listName = request.getParameter("newListName");
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		// Authenticate User -- If invalid send to login
		user.getShoppingLists().add(new ShoppingList(listName));
		response.sendRedirect("ShoppingList");
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) {
		String oldName = request.getParameter("oldName");
		String newName = request.getParameter("newName");
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		ShoppingList list = user.getShoppingLists().stream().filter(l -> l.equals(new ShoppingList(oldName)))
				.findFirst().orElse(null);
		if(list != null) {
			list.setName(newName);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String listName = request.getParameter("list");
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		user.getShoppingLists().remove(new ShoppingList(listName));
		response.sendRedirect("ShoppingList");
	}

}

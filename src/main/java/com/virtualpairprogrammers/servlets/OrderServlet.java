package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3187360444156774168L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		out.println(""
				+ "<html>"
				+ "<body>"
				+ "	<h1>Caiçara's Restaurant</h1>");
		
		out.println("<h2>Order your food</h2>");
		out.println("<form action='orderReceived.html' method='POST'>");
		out.println("<ul>");
		
		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> menuItems = menuDataService.getFullMenu();
		
		for (MenuItem menuItem: menuItems) {
			out.println("<li>"+menuItem+"<input type='text' name='item_"+menuItem.getId()+"'/></li>"); 
		}
		
		out.println("</ul>");
		out.println("<input type='submit'/>");
		out.println("</form>");
		
		out.println(""
				+ "</body>"
				+ "</html>");
		
		out.close();
	}
	
}

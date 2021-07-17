package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class ViewMenuServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1540513938731675834L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> menuItems = menuDataService.getFullMenu();
		
		out.println(""
				+ "<html>"
				+ "<body>"
				+ "	<h1>Caiçara's Restaurant</h1>"
				+ "	<h2>Menu</h2>"
				+ "	<ul>");
		for(MenuItem menuItem : menuItems) {
			out.println("<li>"+ menuItem +"</li>");
		}
		
		out.println(""
				+ "	</ul>"
				+ "</body>"
				+ "</html>");
		out.close();
	}

}

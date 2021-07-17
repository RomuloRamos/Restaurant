package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;


public class MenuSearchServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5742658646295132901L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String searchTerm = request.getParameter("searchTerm");
		
		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> menuItems = menuDataService.find(searchTerm);
		
		out.println(""
				+ "<html>"
				+ "<body>"
				+ "	<h1>Cai�ara's Restaurant</h1>");
		if(menuItems.size()>0) {
			out.println(""
					+ "	<h2>Dishes containing "+ searchTerm +"</h2>"
					+ "	<ul>");
			for(MenuItem menuItem : menuItems) {
				out.println("<li>"+ menuItem +" "+ menuItem.getDescription() +"</li>");
			}
			
			out.println("</ul>");
		}
		else {
			out.println("<p>I'm sorry, there are no dishes containing " + searchTerm+"</p>");
		}
		
		out.println(""
				+ "</body>"
				+ "</html>");
		out.close();
	}

}

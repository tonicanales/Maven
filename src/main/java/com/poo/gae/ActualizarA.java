package com.poo.gae;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;


/**
 * Servlet implementation class SRAdmin
 */
public class ActualizarA extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) 
			throws ServletException, IOException {
	
		// Set response content type
	      response.setContentType("text/html");
	 
	      PrintWriter out = response.getWriter();
	      String title = "Admin";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	      
	      DBAdmin dbAdmin = new DBAdmin();
	      String id = req.getParameter("ID");
	      if (id.equals("")) id="0";
	      dbAdmin.connect();
	    	Admin nuevo = dbAdmin.find(Admin.class, Integer.parseInt(req.getParameter("ID")));
	      dbAdmin.close();
	      
	      if (nuevo == null){
	    	  response.sendRedirect("/actualizarA.html");
	      } else {
	      
	      	nuevo.setName(req.getParameter("name"));
	      
	    	dbAdmin.updateAdmin(nuevo);
	      }
	      out.println(docType +
	 	         "<html><body><form action='/index.html'><input type = 'submit' value = 'Volver'/></form></body></html>"
	 	      );
	}

	
}

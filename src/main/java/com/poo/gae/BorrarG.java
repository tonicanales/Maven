package com.poo.gae;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.Gallery;


/**
 * Servlet implementation class SRAdmin
 */
public class BorrarG extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) 
			throws ServletException, IOException {
	
		// Set response content type
	      response.setContentType("text/html");
	 
	      PrintWriter out = response.getWriter();
	      String title = "Admin";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	      
	      DBAdmin dbAdmin = new DBAdmin();
	      dbAdmin.connect();
	      	Gallery gallery = dbAdmin.entitymanager.find(Gallery.class, Integer.parseInt(req.getParameter("ID")));
	      dbAdmin.close();
	      if (gallery == null){
	    	  response.sendRedirect("/borrarG.html");
	      } else {
	    	  dbAdmin.removeGallery(gallery);
	      }
	      out.println(docType +
	 	         "<html><body><form action='/index.html'><input type = 'submit' value = 'Volver'/></form></body></html>"
	 	      );
	}

	
}

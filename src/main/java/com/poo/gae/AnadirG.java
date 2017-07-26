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
public class AnadirG extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) 
			throws ServletException, IOException {
	
		// Set response content type
	      response.setContentType("text/html");
	 
	      PrintWriter out = response.getWriter();
	      String title = "Admin";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	      
	      DBAdmin admin = new DBAdmin();
	      Gallery nuevaGallery = new Gallery();
	      
	    admin.connect();
			Admin admin2 = admin.entitymanager.find(Admin.class, Integer.parseInt(req.getParameter("ID")));
		admin.close();
		if (admin2 == null){
	    	  response.sendRedirect("/anadirG.html");
	     } else {
			
		nuevaGallery.setAdmin(admin2);
		nuevaGallery.setDescription(req.getParameter("Descripción"));
		nuevaGallery.setName(req.getParameter("Nombre"));
		admin.createGallery(admin2, nuevaGallery);
	         
	      out.println(docType +
	 	         "<html><body><form action='/index.html'><input type = 'submit' value = 'Volver'/></form></body></html>"
	 	      );
	      
	      }
	}	
		
}

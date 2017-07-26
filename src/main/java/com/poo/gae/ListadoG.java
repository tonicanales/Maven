package com.poo.gae;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.Gallery;


/**
 * Servlet implementation class SRAdmin
 */
public class ListadoG extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) 
			throws ServletException, IOException {
	
		// Set response content type
	      response.setContentType("text/html");
	 
	      PrintWriter out = response.getWriter();
	      String title = "Galerías";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	      DBAdmin dbAdmin = new DBAdmin();
	      dbAdmin.connect();
	      	Admin nuevo = dbAdmin.find(Admin.class, Integer.parseInt(req.getParameter("ID")));
	      dbAdmin.close();	
	    	if (nuevo == null){
		    	  response.sendRedirect("/listadoG.html");
		      } else {
	    	
	      	Set<Gallery> listaGalerias = dbAdmin.getGalleries(Integer.parseInt(req.getParameter("ID")));
	      	
	      	out.println(docType +
	         "<html>\n" +
	            "<head> <link type='text/css' rel='stylesheet' href='styles.css'><title>" + title + 
	            "</title></head>\n" +
	            "<body bgcolor = \"#f0f0f0\">\n" +
	               "<h1 align = \"center\">" + title + "</h1>\n" +
	               "<div class='cuadro'><table border='1'>");
	     			for (Gallery a : listaGalerias){
	      	            	 out.println(docType + 
	      	            			 "<tr><td>" + a.getId() +
	      	            			 "</td><td>" + a.getName() +
	      	            			 "</td><td>" + a.getDescription() +
	      	            			 "</td></tr>");
	     			}
		      		
	     	out.println(docType +
	     			"</tr></table></div></body> </html>"
	      );
	}
}
		
}

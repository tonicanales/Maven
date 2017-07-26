package com.poo.gae;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;


/**
 * Servlet implementation class SRAdmin
 */
public class SradminA extends HttpServlet {
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
	      ArrayList<Admin> listaAdmins = dbAdmin.selectAll(Admin.class);
	      dbAdmin.close();

	      
	      out.println(docType +
	         "<html>\n" +
	            "<head> <link type='text/css' rel='stylesheet' href='styles.css'><title>" + title + 
	            "</title></head>\n" +
	            "<body bgcolor = \"#f0f0f0\">\n" +
	               "<h1 align = \"center\">" + title + "</h1>\n" +
	               "<div class='cuadro'><table border='1'>");
	     			for (Admin a : listaAdmins){
	      	            	 out.println(docType + 
	      	            			 "<tr><td>" + a.getName() +
	      	            			 "</td><td>" + a.getId() +
	      	            			 "</td></tr>");
	     			}
	     			
	     	out.println(docType +
	     			"</tr></table></div></body> </html>"
	      );
	}
		
}

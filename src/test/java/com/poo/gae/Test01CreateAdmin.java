package com.poo.gae;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Admin;
import model.Gallery;


public class Test01CreateAdmin {
	DBAdmin dbAdmin; 

	
	@Before
	public void init(){
		dbAdmin = new DBAdmin(); 	
		dbAdmin.connect();
		dbAdmin.deleteAll(Admin.class);
		dbAdmin.close();
	}
	
	@Test
	public void testSbConection(){
		DBAdmin dbAdmin = new DBAdmin();
		Gallery gallery1 = new Gallery();
		Gallery gallery2 = new Gallery();
		
		gallery1.setName("Galería 1");
		gallery2.setName("Galería 2");
		gallery1.setDescription("Descripción 1");
		gallery2.setDescription("Descripción 2");

		
		
		Admin admin = new Admin();
		
		admin.setName("Admin1");
		
		gallery1.setAdmin(admin);
		gallery2.setAdmin(admin);
		admin.getGalleries().add(gallery1);
		admin.getGalleries().add(gallery2);

		dbAdmin.createGallery(admin, gallery1);
	}
	
	
	//@Test
	public void TestCreateAdmin(){
		
		DBAdmin dbAdmin = new DBAdmin();

		Admin admin = new Admin();
		
		admin.setName("Toni");
		
		dbAdmin.createAdmin(admin);
		
		dbAdmin.connect();
	    	Admin edited = dbAdmin.find(Admin.class, admin.getId());
	    dbAdmin.close();

	    Assert.assertEquals("Toni",edited.getName());
		
	}
	
	@Test
	public void TestDelete(){
		
		DBAdmin dbAdmin = new DBAdmin();
	      dbAdmin.connect();
	    	Admin nuevo = dbAdmin.find(Admin.class, 1);
	      dbAdmin.close();
	      
	      if (nuevo == null){
	    	  System.out.print("fallo");;
	      } else{
	      dbAdmin.removeAdmin(nuevo);
	      }
	}
	

}

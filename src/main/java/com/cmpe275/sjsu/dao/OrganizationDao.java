package com.cmpe275.sjsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cmpe275.sjsu.blueprint.Organization;
import com.cmpe275.sjsu.blueprint.Profile;

public class OrganizationDao {

	Connection conn = null;
    Statement stmt = null,stmt1=null;
	public OrganizationDao()
	  {
		   try{
		      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/befriend","root","mankena");
		   }
		   catch (SQLException e) {
					e.printStackTrace();
					
			}
	  }
	public void addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		try {
			 stmt = conn.createStatement();
			 String query = "INSERT INTO organization(name,password,address,description,phone,email,website)"
			 		+ " VALUES (" + "'" + organization.getName() + "'," + "'" + organization.getPassword() + "'," + 
			  "'" + organization.getAddress() + "'," + 
					 "'" + organization.getDescription() + "'," + "'" +organization.getPhone() + "',"
					 + "'" +organization.getPhone() + "',"
					 + "'" +organization.getWebsite() + "')";
			 System.out.println(query);
			 stmt.executeUpdate(query);
			 	
		  				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  }

	public void updateOrganization(Organization p) {
		try {
		 stmt = conn.createStatement();
		 String query = "UPDATE organization SET phone=" + "'" +p.getPhone() + "',"
				 + "description=" + "'" +p.getDescription() + "',"
				 + "address=" + "'" +p.getAddress() + "'," 
				 + "website=" + "'" +p.getWebsite() + "'" 
				 +  "WHERE name=" + "'" +p.getName() + "'";
		 System.out.println(query);
		 stmt.executeUpdate(query);
	  	
	  				} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	public Organization getOrganization(String name) {
		ResultSet rs;
		Organization p=new Organization();
		  try {
		 stmt = conn.createStatement();
		 String query_select = "Select * from organization where name=" + "'"+name + "'";
		
		 	System.out.println(query_select);
	  		rs = stmt.executeQuery(query_select);
	  		
	  		System.out.println(rs);
	  		
	  		rs.next();
	  		if(rs.wasNull())
	  			return null;
	  		p.setName(name);
	  		p.setPhone(rs.getString("phone"));
	  		p.setEmail(rs.getString("email"));
	  		p.setAddress(rs.getString("address"));
	  		p.setDescription(rs.getString("description"));
	  		p.setWebsite(rs.getString("website"));
	  		
	  				} catch (SQLException e) {
			e.printStackTrace();
		} 
		  return p;
	}


}

package com.cmpe275.sjsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cmpe275.sjsu.blueprint.Login;

public class LoginDao {
	Connection conn = null;
    Statement stmt = null,stmt1=null;
	public LoginDao(){
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
	public boolean authenticate(Login loginObj) throws SQLException{
		
		ResultSet rs;
		try {
			 stmt = conn.createStatement();
			 String query = "SELECT password from profile where username=" + "'" +loginObj.getUsername() + "'";
			 System.out.println(query);
			 rs = stmt.executeQuery(query);
			 rs.next();
			 String password = rs.getString("password");
			 rs.close();
			 if(password.equals(loginObj.getPassword()))
				 return true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			stmt.close();
		}
			 
		return false;
	
	}

}

package com.cmpe275.sjsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrgPostDao {
	Connection conn = null;
    Statement stmt = null,stmt1=null;
	public OrgPostDao(){
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
	public void insertPost(String username, String post) throws SQLException{
		try{
		stmt = conn.createStatement();
		 String query = "INSERT into orgpost values(" + "'" +username + "'," + "'" +post + "')"; 
				 System.out.println(query);
		 stmt.executeUpdate(query);
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			stmt.close();
			
		}
	
	}

	public String[] getPosts(String username) throws SQLException{
		String[] posts = new String[50];
		ResultSet rs;
		try {
			int i=0;
			 stmt = conn.createStatement();
			 String query = "SELECT message from orgpost WHERE name="+ "'" +username + "'";
			 System.out.println(query);
			 rs = stmt.executeQuery(query);
			 while(rs.next()){
				 posts[i] = rs.getString("message");
				 System.out.println(posts[i]);
				 i++;
			 }
			 rs.close();
			 return posts;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			stmt.close();
			
		}
		return posts;
	}
}

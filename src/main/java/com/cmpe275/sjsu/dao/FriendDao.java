package com.cmpe275.sjsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FriendDao {
	Connection conn = null;
    Statement stmt = null,stmt1=null,stmt2=null,stmt_prof_exist=null;
	public FriendDao(){
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
	public String addFriendRequest(String username, String email) throws SQLException {
		ResultSet rs_pe;
		try {
			 stmt = conn.createStatement();
			 stmt_prof_exist = conn.createStatement();
			 String prof_exist = "SELECT * from profile WHERE email=" + "'" +email + "'";
			 rs_pe = stmt_prof_exist.executeQuery(prof_exist);
			 if(!rs_pe.next()) // if will be executed if resultset is null, meaning some user exists with the email
			 {}
			 else
				 return "There doesn't exist any profile with this email"; 
			 String query = "INSERT into friendrequests values(" + "'" +username + "'," + "'" +email + "')";
			 System.out.println(query);
			 stmt.executeUpdate(query);
			 rs_pe.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			stmt.close();
		}
		return "friend request sent";		
	}
	public String[] viewfriendrequests(String username) throws SQLException{

		String friendrequests[] = new String[20];
		ResultSet rs;
		try {
			int i=0;
			 stmt = conn.createStatement();
			 String query = "SELECT friendemail from friendrequests WHERE username="+ "'" +username + "'";
			 System.out.println(query);
			 rs = stmt.executeQuery(query);
			 while(rs.next()){
				 friendrequests[i] = rs.getString("friendemail");
				 System.out.println(friendrequests[i]);
				 i++;
			 }
			 rs.close();
			 return friendrequests;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			stmt.close();
			
		}
		
		return friendrequests;
	}


	public String addFriend(String username, String email) throws SQLException{
		
		ResultSet rs,rs2,rs_pe;
		try {
			 stmt1 = conn.createStatement();
			 stmt = conn.createStatement();
			 stmt_prof_exist = conn.createStatement();
			 String prof_exist = "SELECT * from profile WHERE email=" + "'" +email + "'";
			 System.out.println(prof_exist);
			 rs_pe = stmt_prof_exist.executeQuery(prof_exist);
			 if(!rs_pe.next()) // if will be executed if resultset is null, meaning some user exists with the email
				 return "There doesn't exist any profile with this email";
				  
			 String getUsernameQuery = "SELECT username from profile WHERE email="+ "'" +email + "'";
			 rs = stmt1.executeQuery(getUsernameQuery);
			 rs.next();
			 String username2 = rs.getString("username");
			 stmt2 = conn.createStatement();
			 String friendCheck = "SELECT * from friendship WHERE username1=" + "'" +username + "'" +
			 "and username2=" + "'" +username2 + "'";
			 System.out.println(friendCheck);
			 rs2 = stmt2.executeQuery(friendCheck);
			 if(!rs2.next()) // if will be executed if resultset is null, meaning the two are not friends
			 {}
			 else
				 return "He/she is already your friend "; 
			 //***************
			 String query = "INSERT into friendship values(" + "'" +username + "'," + "'" +username2 + "')";
			 System.out.println(query);
			 stmt.executeUpdate(query);
			 rs.close();
			 rs_pe.close();
			 rs2.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			stmt.close();
			stmt1.close();
			stmt2.close();
			stmt_prof_exist.close();
		}
		return "You are friends now";
	}
	
public void deleteFriend(String username, String email) throws SQLException{
		
		ResultSet rs;
		try {
			 stmt1 = conn.createStatement();
			 stmt = conn.createStatement();
			 String getUsernameQuery = "SELECT username from profile WHERE email="+ "'" +email + "'";
			 rs = stmt1.executeQuery(getUsernameQuery);
			 rs.next();
			 String username2 = rs.getString("username");
			 String query = "DELETE from friendship WHERE username1=" + "'" +username + "'" + "and username2=" + "'" +username2 + "'" ;
			 System.out.println(query);
			 stmt.executeUpdate(query);
			 rs.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			stmt.close();
			stmt1.close();
			
		}
		
	}

	public String[] viewFriends(String username1) throws SQLException{

		String friends[] = new String[20];
		ResultSet rs;
		try {
			int i=0;
			 stmt = conn.createStatement();
			 String query = "SELECT username2 from friendship WHERE username1="+ "'" +username1 + "'";
			 System.out.println(query);
			 rs = stmt.executeQuery(query);
			 while(rs.next()){
				 friends[i] = rs.getString("username2");
				 System.out.println(friends[i]);
				 i++;
			 }
			 rs.close();
			 return friends;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			stmt.close();
			
		}
		
		return friends;
	}
	public String deleteFriendRequest(String username, String email) throws SQLException {
		ResultSet rs_pe,rs_frq;
		try {
			 stmt = conn.createStatement();
			 stmt_prof_exist = conn.createStatement();
			 String prof_exist = "SELECT * from profile WHERE email=" + "'" +email + "'";
			 rs_pe = stmt_prof_exist.executeQuery(prof_exist);
			 if(!rs_pe.next()) // if will be executed if resultset is null, meaning some user exists with the email
			 {}
			 else
				 return "There doesn't exist any profile with this email"; 
			 stmt2 = conn.createStatement();
			 String frq_exist = "SELECT * from friendrequests WHERE email=" + "'" +email + "'" +
			 "and username=" + "'" +username + "'";
			 rs_frq = stmt2.executeQuery(frq_exist);
			 if(!rs_pe.next()) // if will be executed if resultset is null, meaning some user exists with the email
			 {}
			 else
				 return "There is nof friend request from this user"; 
			 String query = "DELETE FROM friendrequests WHERE username=" + "'" +username + "'," + 
				 "and email=" + "'" +email + "'";
			 System.out.println(query);
			 stmt.executeUpdate(query);
			 rs_pe.close();
			 rs_frq.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			stmt.close();
			stmt2.close();
			stmt_prof_exist.close();
		}
		return "friend request sent";	
	}
	
	
}

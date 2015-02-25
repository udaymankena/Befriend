package com.cmpe275.sjsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cmpe275.sjsu.blueprint.Profile;

public class ProfileDao {
	Connection conn = null;
    Statement stmt = null,stmt1=null;

// Constructure with JDBC connection
  public ProfileDao()
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
  
  public boolean addProfile(Profile profile)
  {
	 // ResultSet rs;
	  try {
	 stmt = conn.createStatement();
	 //stmt1 = conn.createStatement(); //insert into person values(col1,col2,..);
	 String query = "INSERT INTO profile(username,password,firstname,lastname,email,address,description)"
	 		+ " VALUES (" + "'" + profile.getUsername() + "'," + "'" + profile.getPassword() + "'," + 
	 "'" + profile.getFirstname() + "'," + "'" + profile.getLastname() + "'," + 
			 "'" + profile.getEmail() + "'," + "'" +profile.getAddress() + "',"
			 + "'" +profile.getDescription() + "')";
	 //String query_select = "Select * from Profile where email='"+profile.getEmail()+"'";
	 System.out.println(query);
	 stmt.executeUpdate(query);
	 	/*//System.out.println(query_select);
  		//rs = stmt.executeQuery(query_select);
  		//System.out.println(rs);
  		
  		rs.next();
  		System.out.println("Id from db"+rs.getString("pid"));
  		profile.setId(Long.parseLong(rs.getString("pid")));
  		System.out.println(profile.getId());*/
  				} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  return true;
  }

public Profile getProfile(String username) {
	ResultSet rs;
	Profile p=new Profile();
	  try {
	 stmt = conn.createStatement();
	 String query_select = "Select * from profile where username=" + "'"+username + "'";
	
	 	System.out.println(query_select);
  		rs = stmt.executeQuery(query_select);
  		
  		System.out.println(rs);
  		
  		rs.next();
  		if(rs.wasNull())
  			return null;
  		//System.out.println("Id from db"+rs.getString("pid"));
  		p.setUsername(username);
  		p.setFirstname(rs.getString("firstname"));
  		p.setLastname(rs.getString("lastname"));
  		p.setEmail(rs.getString("email"));
  		p.setAddress(rs.getString("address"));
  		p.setDescription(rs.getString("description"));
  		//Retrieved Profile
  		 /*String query_friends = "Select * from friendship where pid="+id;
  		rs = stmt.executeQuery(query_friends);
  		ArrayList<Profile> friendsForProfile=new ArrayList<Profile>();
  		while(rs.next())
  		{
  			Profile pf=new Profile();
  			pf.setId(rs.getInt(2));
  			friendsForProfile.add(pf);	
  			
  		}
  		p.setFriends(friendsForProfile);*/
  		
  				} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  return p;	}

public Profile updateProfile(Profile p) {
	ResultSet rs;
	  try {
		// p= getProfile(id);
	 stmt = conn.createStatement();
	 //stmt1 = conn.createStatement();
	 //System.out.println("id = " + p.getId()); 
	 String query = "UPDATE profile SET firstname=" + "'" +p.getFirstname() + "',"
			 + "lastname=" + "'" +p.getLastname() + "',"
			 + "address=" + "'" +p.getAddress() + "',"
			 + "description=" + "'" +p.getDescription() + "'" +
			 "WHERE username=" + "'" +p.getUsername() + "'";
	 System.out.println(query);
	 stmt.executeUpdate(query);
  	/*// rs = stmt.executeU(query);
  	//String query_select = "Select * from Profile where pid="+p.getId();
  	 rs = stmt.executeQuery(query_select);
  		rs.next();
  		System.out.println("Id from db"+rs.getString("pid"));
  		p.setId(Long.parseLong(rs.getString("pid")));
  		p.setFirstname(rs.getString("firstname"));
  		p.setLastname(rs.getString("lastname"));
  		p.setEmail(rs.getString("email"));*/
  				} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  return p;
}}
  /*
//  public boolean checkUser(User user)
//  {
//	  try {
//			 stmt = conn.createStatement();
//			 String query = "
//			 stmt.executeUpdate(query);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	  
//  }
  
  public int addFriend(String id1, String id2){
	  try{
		 stmt = conn.createStatement();
		 
		 String Profile_pid ="select EXISTS" + "(" + "select 1 from Profile where pid=" +id1 + ")"; 
		 String Profile_fid ="select EXISTS" + "(" + "select 1 from Profile where pid=" +id2 + ")";
		 String query_friendship ="select EXISTS" + "(" + "select 1 from friendship where pid=" +id1 + " and fid="+id2 + ")"; 
		 //System.out.println(query_pid);
		 //System.out.println(query_fid);
		 //System.out.println(query_friendship);
		 ResultSet rs = stmt.executeQuery(Profile_pid);
		 rs.next();
		 System.out.println("Add Friend"+rs.getInt(1));
		 if(rs.getInt(1) != 1){
			 return 1;
		 }
		  rs = stmt.executeQuery(Profile_fid);
			 rs.next();
		 if(rs.getInt(1) != 1){
			 return 1;
		 }
		 rs = stmt.executeQuery(query_friendship);
		 rs.next();
		 if(rs.getInt(1) == 1){
			System.out.println("Friends");
			 return 2;
		 }
		 String query = "INSERT INTO friendship (pid, fid) VALUES ('" + id1 + "', '" + id2 + "' )";
		 System.out.println(query);
		 stmt.executeUpdate(query);
		
	  }
	  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  return 3;
	  }
  
  public int deleteFriend(String id1, String id2){
	  try{
		 stmt = conn.createStatement();
		 
		 String Profile_pid ="select EXISTS" + "(" + "select 1 from Profile where pid=" +id1 + ")"; 
		 String Profile_fid ="select EXISTS" + "(" + "select 1 from Profile where pid=" +id2 + ")";
		 String query_friendship ="select EXISTS" + "(" + "select 1 from friendship where pid=" +id1 + " and fid="+id2 + ")"; 
		 //System.out.println(query_pid);
		 //System.out.println(query_fid);
		 //System.out.println(query_friendship);
		 ResultSet rs = stmt.executeQuery(Profile_pid);
		 rs.next();
		 System.out.println("Add Friend"+rs.getInt(1));
		 if(rs.getInt(1) != 1){
			 return 1;
		 }
		  rs = stmt.executeQuery(Profile_fid);
			 rs.next();
		 if(rs.getInt(1) != 1){
			 return 1;
		 }
		 rs = stmt.executeQuery(query_friendship);
		 rs.next();
		 if(rs.getInt(1) != 1){
			System.out.println("Friends");
			 return 2;
		 }
		 String query = "delete * from Profile where pid="+id1;
		 System.out.println(query);
		 stmt.executeUpdate(query);
		
	  }
	  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  return 3;
	  }
  

public Profile deleteProfile(String id) {
	Profile p = null;
	try{
		 stmt = conn.createStatement();
		 
		 p=getProfile(id);
		 String Profile_friends ="delete from friendship where pid=" +id +" or fid="+id;
		 String Profile_pid ="delete from Profile where pid=" +id;
		 stmt.executeUpdate(Profile_friends);
		 stmt.executeUpdate(Profile_pid);
		 
		
	  }
	  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  return p;

}
}
*/
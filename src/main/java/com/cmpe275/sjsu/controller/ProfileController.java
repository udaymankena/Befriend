package com.cmpe275.sjsu.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmpe275.sjsu.blueprint.Friend;
import com.cmpe275.sjsu.blueprint.Post;
import com.cmpe275.sjsu.blueprint.Profile;
import com.cmpe275.sjsu.dao.FriendDao;
import com.cmpe275.sjsu.dao.PostDao;
import com.cmpe275.sjsu.dao.ProfileDao;

@Controller
public class ProfileController {
	
	String displayMessage=null;
	@RequestMapping(value = "createprofile",method = RequestMethod.GET)
	public String sendProfileCreationPage(){
		return "createprofile";
	}
@RequestMapping("createprofile")
public String createProfile(@ModelAttribute("profile") Profile profile){
	System.out.println(profile.getDescription());
	ProfileDao profileDao = new ProfileDao();
	profileDao.addProfile(profile);
	System.out.println(profile.getDescription());
	return "success";
}

@RequestMapping("updateprofile")
public String updateProfile(@ModelAttribute("profile") Profile profile, HttpSession session){
	System.out.println(profile.getDescription());
	Profile sessionProfile = (Profile)session.getAttribute("sessionProfile");
	
	profile.setUsername(sessionProfile.getUsername());
	profile.setEmail(sessionProfile.getEmail());
	if(profile.getFirstname() == null ||profile.getFirstname() == "" )
	profile.setFirstname(sessionProfile.getFirstname());
	if(profile.getLastname() == null ||profile.getLastname() == "")
		profile.setLastname(sessionProfile.getLastname());
	if(profile.getAddress() == null ||profile.getAddress() == "")
		profile.setAddress(sessionProfile.getAddress());
	if(profile.getDescription() == null ||profile.getDescription() == "")
		profile.setDescription(sessionProfile.getDescription());
	
	ProfileDao profileDao = new ProfileDao();
	profileDao.updateProfile(profile);
	return "success";
}

@RequestMapping(value = "addfriendrequest", method = RequestMethod.POST)
public String addFriendRequest(@ModelAttribute("friend") Friend friend, HttpSession session) throws SQLException{
	Profile sessionprofile = (Profile)session.getAttribute("sessionProfile");
	FriendDao friendDao = new FriendDao();
	displayMessage = friendDao.addFriendRequest(sessionprofile.getUsername(),friend.getEmail());
	session.setAttribute("displayMessage", displayMessage);
	return "myprofile";
}

@RequestMapping(value = "viewfriendrequests*", method = RequestMethod.GET)
public String viewFriendRequests(HttpSession session) throws SQLException{
	Profile sessionprofile = (Profile)session.getAttribute("sessionProfile");
	FriendDao friendDao = new FriendDao();
	System.out.println(sessionprofile.getUsername());
	String[] friendrequests = friendDao.viewfriendrequests(sessionprofile.getUsername());
	session.setAttribute("friendrequests", friendrequests);
	System.out.println(friendrequests[0]);
	return "friendrequests";
}
@RequestMapping(value = "deletefriendrequest", method = RequestMethod.POST)
public String deleteFriendRequest(@ModelAttribute("friend") Friend friend, HttpSession session) throws SQLException{
	Profile sessionprofile = (Profile)session.getAttribute("sessionProfile");
	FriendDao friendDao = new FriendDao();
	displayMessage = friendDao.deleteFriendRequest(sessionprofile.getUsername(),friend.getEmail());
	session.setAttribute("displayMessage", displayMessage);
	return "friendrequests";
}

@RequestMapping(value = "addfriend", method = RequestMethod.POST)
public String addFriend(@ModelAttribute("friend") Friend friend, HttpSession session) throws SQLException{
	Profile sessionprofile = (Profile)session.getAttribute("sessionProfile");
	FriendDao friendDao = new FriendDao();
	displayMessage = friendDao.addFriend(sessionprofile.getUsername(),friend.getEmail());
	session.setAttribute("displayMessage", displayMessage);
	return "friendrequests";
}

@RequestMapping(value = "deletefriend", method = RequestMethod.POST)
public String deleteFriend(@ModelAttribute("friend") Friend friend, HttpSession session) throws SQLException{
	Profile sessionprofile = (Profile)session.getAttribute("sessionProfile");
	FriendDao friendDao = new FriendDao();
	friendDao.addFriend(sessionprofile.getUsername(),friend.getEmail());
	return "addfriendsuccess";
}
@RequestMapping(value = "viewfriends*", method = RequestMethod.GET)
public String viewFriends(HttpSession session) throws SQLException{
	Profile sessionprofile = (Profile)session.getAttribute("sessionProfile");
	FriendDao friendDao = new FriendDao();
	System.out.println(sessionprofile.getUsername());
	String[] friends = friendDao.viewFriends(sessionprofile.getUsername());
	session.setAttribute("friends", friends);
	System.out.println(friends[0]);
	return "viewfriends";
}
@RequestMapping(value = "createpost", method = RequestMethod.POST)
public String addFriend(@ModelAttribute("post") Post post, HttpSession session) throws SQLException{
	Profile sessionprofile = (Profile)session.getAttribute("sessionProfile");
	PostDao postDao = new PostDao();
	postDao.insertPost(sessionprofile.getUsername(), post.getMessage());
	return "postsuccess";
}
@RequestMapping(value = "viewposts*", method = RequestMethod.GET)
public String viewposts(HttpSession session) throws SQLException{
	Profile sessionprofile = (Profile)session.getAttribute("sessionProfile");
	PostDao postDao = new PostDao();
	System.out.println(sessionprofile.getUsername());
	String[] posts = postDao.getPosts(sessionprofile.getUsername());
	session.setAttribute("posts", posts);
	System.out.println(posts[0]);
	return "viewposts";
}


}

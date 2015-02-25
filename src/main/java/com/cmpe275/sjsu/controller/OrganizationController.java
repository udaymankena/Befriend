package com.cmpe275.sjsu.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmpe275.sjsu.blueprint.Organization;
import com.cmpe275.sjsu.blueprint.Post;
import com.cmpe275.sjsu.blueprint.Profile;
import com.cmpe275.sjsu.dao.OrgPostDao;
import com.cmpe275.sjsu.dao.OrganizationDao;
import com.cmpe275.sjsu.dao.PostDao;
@Controller
public class OrganizationController {

	@RequestMapping(value = "createorganization",method = RequestMethod.GET)
	public String sendOrganizationCreationPage(){
		return "createOrganization";
	}
	
	@RequestMapping(value = "createorganization",  method = RequestMethod.POST)
	public String createOrganization(@ModelAttribute("organization") Organization organization){
		System.out.println(organization.getDescription());
		OrganizationDao organizationDao = new OrganizationDao();
		organizationDao.addOrganization(organization);
		System.out.println(organization.getDescription());
		return "organizationsuccess";
	}
	
	@RequestMapping("updateorganization")
	public String updateOrganization(@ModelAttribute("organization") Organization organization, HttpSession session){
		System.out.println(organization.getDescription());
		Organization sessionOrganization = (Organization)session.getAttribute("sessionOrganization");
		
		organization.setName(sessionOrganization.getName());
		organization.setEmail(sessionOrganization.getEmail());
		organization.setPassword(sessionOrganization.getPassword());
		
		if(organization.getPhone() == null ||organization.getPhone() == "" )
		organization.setPhone(sessionOrganization.getPhone());
		if(organization.getAddress() == null ||organization.getAddress() == "")
			organization.setAddress(sessionOrganization.getAddress());
		if(organization.getDescription() == null ||organization.getDescription() == "")
			organization.setDescription(sessionOrganization.getDescription());
		if(organization.getWebsite() == null ||organization.getWebsite() == "")
			organization.setWebsite(sessionOrganization.getWebsite());
		
		
		OrganizationDao organizationDao = new OrganizationDao();
		organizationDao.updateOrganization(organization);
		return "organizationsuccess";
	}

	@RequestMapping(value = "orgcreatepost", method = RequestMethod.POST)
	public String addFriend(@ModelAttribute("post") Post post, HttpSession session) throws SQLException{
		Organization sessionorganization = (Organization)session.getAttribute("sessionOrganization");
		OrgPostDao postDao = new OrgPostDao();
		postDao.insertPost(sessionorganization.getName(), post.getMessage());
		return "orgpostsuccess";
	}
	@RequestMapping(value = "orgviewposts*", method = RequestMethod.GET)
	public String viewposts(HttpSession session) throws SQLException{
		Organization sessionorganization = (Organization)session.getAttribute("sessionOrganization");
		OrgPostDao orgpostDao = new OrgPostDao();
		System.out.println(sessionorganization.getName());
		String[] posts = orgpostDao.getPosts(sessionorganization.getName());
		session.setAttribute("posts", posts);
		System.out.println(posts[0]);
		return "vieworgposts";
	}
}

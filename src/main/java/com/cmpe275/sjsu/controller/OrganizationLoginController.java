package com.cmpe275.sjsu.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmpe275.sjsu.blueprint.Organization;
import com.cmpe275.sjsu.blueprint.OrganizationLogin;
import com.cmpe275.sjsu.dao.OrganizationDao;
import com.cmpe275.sjsu.dao.OrganizationLoginDao;

@Controller
public class OrganizationLoginController {

	@RequestMapping(value = "organizationlogin", method = RequestMethod.GET)
	public String sendLogin(){
		return "organizationlogin";
	}
	
	@RequestMapping(value = "organizationlogin", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute("organizationloginObj") OrganizationLogin organizationloginObj, HttpSession session) throws SQLException{
		
		OrganizationLoginDao ldao = new OrganizationLoginDao();
		boolean authenticated = ldao.authenticate(organizationloginObj);
		if(!authenticated)
			return "loginerror";
		OrganizationDao organizationDao = new OrganizationDao();
		Organization organization = organizationDao.getOrganization(organizationloginObj.getName());
		session.setAttribute("sessionOrganization",organization );
		return "orgprofile";
			
		}
}

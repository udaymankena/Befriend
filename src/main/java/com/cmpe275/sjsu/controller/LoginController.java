package com.cmpe275.sjsu.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmpe275.sjsu.blueprint.Login;
import com.cmpe275.sjsu.blueprint.Profile;
import com.cmpe275.sjsu.dao.LoginDao;
import com.cmpe275.sjsu.dao.ProfileDao;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String sendLogin(){
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute("loginObj") Login loginObj, HttpSession session) throws SQLException{
		
		LoginDao ldao = new LoginDao();
		boolean authenticated = ldao.authenticate(loginObj);
		if(!authenticated)
			return "loginerror";
		ProfileDao profileDao = new ProfileDao();
		Profile profile = profileDao.getProfile(loginObj.getUsername());
		session.setAttribute("sessionProfile",profile );
		return "myprofile";
			
		}
		
	}


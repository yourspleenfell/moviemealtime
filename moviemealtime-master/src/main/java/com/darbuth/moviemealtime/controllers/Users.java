package com.darbuth.moviemealtime.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.darbuth.moviemealtime.models.User;
import com.darbuth.moviemealtime.services.UserService;



@Controller
public class Users {
	private UserService userServ;
	
	public Users(UserService userServ) {
	    this.userServ = userServ;
	}
	@RequestMapping("/")
	public String index(@Valid @ModelAttribute("user") User user, Principal p, Model m) {
		if(p == null) {
			return "index.jsp";
		}
		m.addAttribute("user", userServ);
		return "index.jsp";
	}
	
}

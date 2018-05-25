package com.darbuth.moviemealtime.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.darbuth.moviemealtime.models.User;
import com.darbuth.moviemealtime.services.UserService;
import com.darbuth.moviemealtime.validators.UserValidator;

@Controller
public class Users {
	
	private UserValidator uv;
	private UserService us;
	
	public Users(UserValidator uv,
			UserService us) {
		this.uv = uv;
		this.us = us;
	}

	@RequestMapping("/")
	public String index(@Valid @ModelAttribute("user") User user,
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required=false) String logout,
			Model model,
			Principal p) {
		if (error != null) {
			model.addAttribute("error", "Invalid email or password, try again");
		}
		if (logout != null) {
			model.addAttribute("error", "You have successfully logged out");
		}
		if (p != null) {
			model.addAttribute("currentUser", us.findUserByEmail(p.getName()));
		}
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user") User user,
			BindingResult res) {
		uv.validate(user, res);
		if (res.hasErrors()) {
			return "index.jsp";
		}
		us.saveWithUserRole(user);
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/" + "?logout";
	}
	
	@PostMapping("/users/update")
	public String updateUser(@Valid @ModelAttribute("currentUser") User user,
			BindingResult res,
			Principal p,
			Model model) {
		User currentUser = us.findUserByEmail(p.getName());
		user.setPassword(currentUser.getPassword());
		user.setPasswordConfirmation(currentUser.getPassword());
		uv.validate(user, res);
		if (res.hasErrors()) {
			model.addAttribute("editing", true);
			model.addAttribute("user", new User());
			model.addAttribute("currentUser", user);
			return "index.jsp";
		}
		user.setId(currentUser.getId());
		us.updateUser(user);
		return "redirect:/";
	}
}

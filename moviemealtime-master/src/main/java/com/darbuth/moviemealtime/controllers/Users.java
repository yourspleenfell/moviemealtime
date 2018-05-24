package com.darbuth.moviemealtime.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.darbuth.moviemealtime.models.User;
import com.darbuth.moviemealtime.services.UserService;
import com.darbuth.moviemealtime.validators.UserValidator;



@Controller
public class Users {
	private final UserValidator uv;
	private final UserService us;
	
	public Users(UserValidator uv, UserService us) {
		this.uv = uv;
		this.us = us;
	}
	
	@RequestMapping("/login")
	public String home(@ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid credentials, try again");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout successful");
		}
		return "index.jsp";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		uv.validate(user, result);
		if (result.hasErrors()) {
			System.out.println("potato");
            return "index.jsp";
        }
		us.saveWithUserRole(user);
        return "redirect:/login";
	}

	@RequestMapping("/")
	public String index(@Valid @ModelAttribute("user") User user, Principal p, Model m) {
		if(p == null) {
		return "index.jsp";
	}
		m.addAttribute("user", us);
		return "index.jsp";
	}

}

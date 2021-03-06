package com.eric.proman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class NavigationController {
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/dashboard";
	}

	@RequestMapping("/dashboard")
	public String index() {
		return "dashboard";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	
	@RequestMapping("login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

}


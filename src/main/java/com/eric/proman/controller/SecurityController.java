package com.eric.proman.controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SecurityController {
	
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
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		
		System.out.println("Invalidated session");
		
		if (session != null) {			
			session.invalidate();
			session = null;
		}
		
		for (Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
		}
		return "redirect:/login";
	}

	
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

}


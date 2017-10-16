package com.eric.proman.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eric.proman.model.User;
import com.eric.proman.repository.UserRepository;

@Controller
public class IndexController {
	@Autowired
	UserRepository userRepository;
	
	
	@RequestMapping(path = {"/dashboard" }, method = GET)
	public String index(Model model, Principal principal) {
		User user = userRepository.findByUsername(principal.getName());
		model.addAttribute("value", "DashBoard");
		model.addAttribute("name" , user.getFirstname() );
		return "dashboard";
	}

}
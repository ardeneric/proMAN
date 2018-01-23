package com.eric.proman.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eric.proman.entity.Supervisor;
import com.eric.proman.repository.UserRepository;
@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/User")
	public String map(Model model, Principal principal){
		Supervisor supervisor = userRepository.findByUsername(principal.getName());
		model.addAttribute("value", "DashBoard");
		model.addAttribute("name" , supervisor.getFirstname() );
		model.addAttribute("value", "User Profile");
		return "user";
	}
	

}

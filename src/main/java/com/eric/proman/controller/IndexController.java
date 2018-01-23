package com.eric.proman.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eric.proman.entity.Supervisor;
import com.eric.proman.repository.UserRepository;
import com.eric.proman.service.UserService;

@Controller
public class IndexController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	UserService userservice;
	
	@RequestMapping(path = {"/dashboard" }, method = GET)
	public String index(Model model, Principal principal) {
		List<Supervisor> userList = new ArrayList<>();
		Supervisor supervisor = userRepository.findByUsername(principal.getName());
		userList = userservice.findByCreatedBy(supervisor.getId());
		model.addAttribute("value", "DashBoard");
		model.addAttribute("name" , supervisor.getFirstname() );
		model.addAttribute("userlist", userList);
		return "dashboard";
	}

}
	package com.eric.proman.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.eric.proman.model.User;
import com.eric.proman.repository.UserRepository;
import com.eric.proman.service.UserService;

@Controller
public class UserListController {
	
	@Autowired 
//	@Qualifier("userServiceImpl")
	UserService userservice;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userrepository;
	
	@RequestMapping("/userList")
	private String userlist(Model model) {
		List<User> userlist = new ArrayList<>();
		userlist = userservice.AllUsers();
		model.addAttribute("users", userlist);
		model.addAttribute("value", "User List");
		model.addAttribute("user", new User());
		return "userList";
	}
	
/*
	@RequestMapping(path = "/addUser",  method = RequestMethod.POST)
	public String addUser(Model model, User user) {
		//save
		return "redirect:/User";
	}*/
	
	@PostMapping("/addUser")
	public String addUserPost(User user) {
		//save
		//return
		System.out.println("user " + user.getFirstname());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userservice.AddUser(user);
		return "redirect:/userList";
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable String id){
		System.out.println("Id from UI " + id);
		userrepository.delete(Integer.parseInt(id));
		return "redirect:/userList";
	}
	
	@PutMapping("/updateUser/{id}")
	public String updateUser(@PathVariable String id) {
		return id;
		
	}
		

}

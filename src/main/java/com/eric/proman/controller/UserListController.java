	package com.eric.proman.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eric.proman.entity.User;
import com.eric.proman.repository.UserRepository;
import com.eric.proman.service.UserService;

@Controller
public class UserListController {
	
	@Autowired 
	UserService userservice;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userrepository;
	
	@RequestMapping("/userList")
	private String userlist(Model model, Principal principal) {
		List<User> userlist = new ArrayList<>();
		User user = userrepository.findByUsername(principal.getName());
		userlist = userservice.findByCreatedBy(user.getId());
		model.addAttribute("users", userlist);
		model.addAttribute("value", "User List");
		model.addAttribute("name" , user.getFirstname() );
		model.addAttribute("user", new User());
		return "userList";
	}
	

	@PostMapping("/addUser")
	public String addUserPost(User user, Principal principal) {
		System.out.println("user " + user.getFirstname());
		User userCreator = userrepository.findByUsername(principal.getName());
		user.setCreatedBy(userCreator.getId());
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
	
	@PostMapping("/updateUser")
	public String updateUser(User user, Model model, Principal principal) {
		User userCreator = userrepository.findByUsername(principal.getName());
		user.setCreatedBy(userCreator.getId());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userservice.AddUser(user);
		return "redirect:/userList";	
	}
	
	@ResponseBody
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Integer id) {
		User user = userrepository.findOne(id);
		return user;
	}
		

}

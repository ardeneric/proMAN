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

import com.eric.proman.entity.Supervisor;
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
		List<Supervisor> userlist = new ArrayList<>();
		Supervisor supervisor = userrepository.findByUsername(principal.getName());
		userlist = userservice.findByCreatedBy(supervisor.getId());
		model.addAttribute("users", userlist);
		model.addAttribute("value", "User List");
		model.addAttribute("name" , supervisor.getFirstname() );
		model.addAttribute("user", new Supervisor());
		return "userList";
	}
	

	@PostMapping("/addUser")
	public String addUserPost(Supervisor supervisor, Principal principal) {
		Supervisor userCreator = userrepository.findByUsername(principal.getName());
		supervisor.setCreatedBy(userCreator.getId());
		supervisor.setPassword(passwordEncoder.encode(supervisor.getPassword()));
		userservice.AddUser(supervisor);
		return "redirect:/userList";
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable String id){
		System.out.println("Id from UI " + id);
		userrepository.delete(Integer.parseInt(id));
		return "redirect:/userList";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(Supervisor supervisor, Model model, Principal principal) {
		Supervisor userCreator = userrepository.findByUsername(principal.getName());
		supervisor.setCreatedBy(userCreator.getId());
		supervisor.setPassword(passwordEncoder.encode(supervisor.getPassword()));
		userservice.AddUser(supervisor);
		return "redirect:/userList";	
	}
	
	@ResponseBody
	@GetMapping("/user/{id}")
	public Supervisor getUser(@PathVariable Integer id) {
		Supervisor supervisor = userrepository.findOne(id);
		return supervisor;
	}
		

}

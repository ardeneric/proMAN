package com.eric.proman.service;

import java.util.List;

import com.eric.proman.model.User;

public interface UserService {
	
	public List<User> AllUsers();
	public User AddUser(User user);
	

}

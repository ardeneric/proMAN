package com.eric.proman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eric.proman.model.User;
import com.eric.proman.repository.UserRepository;
import com.eric.proman.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userrepository;

	@Override
	public List<User> AllUsers() {
		return userrepository.findAll();
	}

	@Override
	public User AddUser(User user) {
		userrepository.save(user);
		return user;
	}

	@Override
	public List<User> findByCreatedBy(Integer createdBy) {
		return userrepository.findByCreatedBy(createdBy);
	}

	

}

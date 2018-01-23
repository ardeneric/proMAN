package com.eric.proman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.proman.entity.Supervisor;
import com.eric.proman.repository.UserRepository;
import com.eric.proman.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userrepository;

	@Override
	public List<Supervisor> AllUsers() {
		return userrepository.findAll();
	}

	@Override
	public Supervisor AddUser(Supervisor supervisor) {
		userrepository.save(supervisor);
		return supervisor;
	}

	@Override
	public List<Supervisor> findByCreatedBy(Integer createdBy) {
		return userrepository.findByCreatedBy(createdBy);
	}

	

}

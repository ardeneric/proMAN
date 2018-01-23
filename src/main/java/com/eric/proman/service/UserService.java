package com.eric.proman.service;

import java.util.List;

import com.eric.proman.entity.Supervisor;

public interface UserService {
	
	public List<Supervisor> AllUsers();
	public Supervisor AddUser(Supervisor supervisor);
	public List<Supervisor> findByCreatedBy(Integer createdBy);
	

}

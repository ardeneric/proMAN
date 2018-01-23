package com.eric.proman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eric.proman.entity.Supervisor;
import com.eric.proman.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Supervisor supervisor=userRepository.findByUsername(username);
		if(supervisor==null) {		
			throw new UsernameNotFoundException("User not found");
		}
		return  supervisor;
		
	}	

}

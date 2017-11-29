package com.eric.proman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.proman.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	

}

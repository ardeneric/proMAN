package com.eric.proman.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eric.proman.entity.Supervisor;

@Repository
public interface UserRepository extends JpaRepository<Supervisor, Integer>{
	
 @Query("from Supervisor s where s.username=:username")
  public Supervisor findByUsername(@Param("username") String username);
 
 public List<Supervisor> findByCreatedBy(Integer createdBy);

}

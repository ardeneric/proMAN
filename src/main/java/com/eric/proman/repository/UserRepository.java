package com.eric.proman.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eric.proman.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
 @Query("from User u where u.username=:username")
  public User findByUsername(@Param("username") String username);
 
 public List<User> findByCreatedBy(Integer createdBy);

}

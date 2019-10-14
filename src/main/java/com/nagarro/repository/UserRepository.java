package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	// method to find user by username
	User findByUsername(String username);	

}

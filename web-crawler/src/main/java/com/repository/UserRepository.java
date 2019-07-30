package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
	User loginQuery(String email,String password);
	
}

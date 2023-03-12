package com.ftmApp.fullstackbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftmApp.fullstackbackend.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
}

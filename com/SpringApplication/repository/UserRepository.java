package com.SpringApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringApplication.model.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	
	Optional<User>findByEmail(String Email);

}

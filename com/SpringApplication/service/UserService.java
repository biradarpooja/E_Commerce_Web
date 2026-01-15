package com.SpringApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.SpringApplication.model.User;
import com.SpringApplication.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User u)
	{
		if(userRepo.findByEmail(u.getEmail()).isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exist");
		}
		userRepo.save(u);
		return ResponseEntity.ok("Signed Up Successfully");
	}
	
	@PostMapping("/Login")
	public ResponseEntity<?> login(@RequestBody User u)
	{
		Optional<User> found= userRepo.findByEmail(u.getEmail());
		if(found.isPresent() && found.get().getPassword().equals(u.getPassword()))
		{
			return ResponseEntity.ok("Login Successfully");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Invalid Data");
	}

}
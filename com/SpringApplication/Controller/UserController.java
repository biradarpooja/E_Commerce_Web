package com.SpringApplication.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringApplication.model.User;
import com.SpringApplication.service.UserService;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserService userservice;
    
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User u)
    {
    	var res=userservice.signup(u);
    	return ResponseEntity.ok("Signup successfully");
    }
    
    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody User u)
    {
    	var res=userservice.login(u);
    	return ResponseEntity.ok("Login Successfully");
    }
}
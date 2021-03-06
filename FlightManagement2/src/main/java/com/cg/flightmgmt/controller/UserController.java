package com.cg.flightmgmt.controller;

import java.math.BigInteger;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.service.IUserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/fms/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	// creating logger object
	public static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	// adding user details
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		LOG.info("ResponseEntity<User> addUser()");
		User userData = userService.addUser(user);
		return new ResponseEntity<User>(userData,HttpStatus.OK);
	}
	
	// Updating user details
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws UserNotFoundException{
		LOG.info("ResponseEntity<User> updateUser()");
		User userData = userService.updateUser(user);
		if(userData==null) {
			throw new UserNotFoundException("Enter valid user id");
		}
		return new ResponseEntity<User>(userData,HttpStatus.OK);
	}
	
	// Deleting User Details
	@DeleteMapping("/removeUser/{userId}")
	public ResponseEntity<String> removeUser(@Valid @PathVariable BigInteger userId) throws UserNotFoundException{
		LOG.info("ResponseEntity<User> removeUser()");
		userService.removeUser(userId);
		String message = "User Successfully Removed";
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	// Validating User data
	@GetMapping("/validateUser")
	public ResponseEntity<User> validateUser(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("userType") String userType) throws UserNotFoundException{
		LOG.info("ResponseEntity<User> validateUser()");
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserType(userType);
		User userFromRepo = userService.validateUser(user);
		return new ResponseEntity<User>(userFromRepo, HttpStatus.OK);
	}

}
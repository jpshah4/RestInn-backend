package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserModel;
import com.example.demo.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/User")
	@CrossOrigin
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel user)
	{
		UserModel model = userService.createUser(user);
		return new ResponseEntity<UserModel>(model, HttpStatus.CREATED);
	}
	
	@GetMapping("/User")
	public ResponseEntity<UserModel> getUserByEmail(@RequestParam(required = false) String email)
	{
		UserModel user;
		if(email != null)
		{
			user = userService.getUserByEmail(email);
			if(user!=null)
				return new ResponseEntity<UserModel>(user, HttpStatus.OK);
		}
			
		return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.NOT_FOUND);
	}
	
}

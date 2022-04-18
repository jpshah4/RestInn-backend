package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserModel;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/Auth")
	public ResponseEntity<String> login(@RequestBody UserModel user)
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
			return new ResponseEntity<String>("User LoggedIn Successfully", HttpStatus.OK);
		}
		catch(BadCredentialsException ex)
		{
			return new ResponseEntity<String>("Username or password incorrect", HttpStatus.UNAUTHORIZED);
		}
		
	}
}

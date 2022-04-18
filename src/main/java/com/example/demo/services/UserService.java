package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserModel;
import com.example.demo.repository.UserDao;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserModel getUserByEmail(String email)
	{
		Optional<UserModel> user = userDao.findByEmail(email);
		
		if(user.isPresent())
			return user.get();
		return null;
	}
	
	public UserModel createUser(UserModel user) 
	{
		String encodedPass = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPass);
		return userDao.insert(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException
	{
		UserModel user = userDao.findByUserName(name);
		
		String userName = user.getUserName();
		String pass = user.getPassword();
		
		return new User(userName, pass, new ArrayList<>());
	}
}

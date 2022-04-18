package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserModel;

@Repository
public interface UserDao extends MongoRepository<UserModel, String>
{
	Optional<UserModel> findByEmail(String email);
	UserModel findByUserName(String userName);
}

package com.userservice.dao;

import java.util.List;

import com.userservice.entities.UserEntity;

public interface UserServiceDao {

//	Create User
	public UserEntity createUser(UserEntity user);

// GetAll Users
	public List<UserEntity> getAllUsers();

//	Get user by user name
	public UserEntity getUserById(String id);

//	UpdateUserById
	public String updateUserById(String id);

//	Delete user by user Id
	 public String delteUserById(String id);
	
}

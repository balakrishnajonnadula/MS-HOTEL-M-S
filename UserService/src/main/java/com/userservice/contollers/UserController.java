package com.userservice.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.dao.UserServiceDao;
import com.userservice.dao.impl.UserServiceDaoImpl;
import com.userservice.entities.UserEntity;

@RestController
@RequestMapping("/api/user/")
public class UserController {

	@Autowired
	private UserServiceDao uService;

	@PostMapping("")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
		UserEntity createUser = uService.createUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);

	}

	@GetMapping("{userId}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable String userId) {
		UserEntity userById = uService.getUserById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(userById);
	}

	@GetMapping("")
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		List<UserEntity> allUsers = uService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
}

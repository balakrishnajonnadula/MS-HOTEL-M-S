package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, String> {

}

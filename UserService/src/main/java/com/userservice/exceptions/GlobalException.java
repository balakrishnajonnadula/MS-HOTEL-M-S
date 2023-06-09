package com.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userservice.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException ex) {
		ApiResponse response = ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}

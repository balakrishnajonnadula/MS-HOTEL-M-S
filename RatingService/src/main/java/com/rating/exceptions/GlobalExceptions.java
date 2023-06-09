package com.rating.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(RatingNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleRetingNotFoundException(RatingNotFoundException ex) {
		Map<String, Object> responce = new HashMap<String, Object>();
		responce.put("timestamp", new Date());
		responce.put("message", ex.getMessage());
		responce.put("success", false);
		responce.put("status", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Map<String, Object>>(responce, HttpStatus.NOT_FOUND);
	}
}

package com.hotelservice.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotelservice.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ApiResponse> handleHotelNotFoundException(HotelNotFoundException ex) {

		ApiResponse hotel = ApiResponse.builder().message(ex.getMessage()).success(false).status(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<ApiResponse>(hotel, HttpStatus.NOT_FOUND);

	}
	
}

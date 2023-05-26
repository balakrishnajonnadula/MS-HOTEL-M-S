package com.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RatingsEntity {

	private String ratingId;

	private String userId;

	private String hotelId;

	private int rating;

	private String feedback;
	
	private HotelEntity hotel;
}

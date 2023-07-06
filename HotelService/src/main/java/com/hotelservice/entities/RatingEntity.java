package com.hotelservice.entities;

public class RatingEntity {
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	@Override
	public String toString() {
		return "RatingEntity [ratingId=" + ratingId + ", userId=" + userId + ", hotelId=" + hotelId + ", rating="
				+ rating + ", feedback=" + feedback + "]";
	}
	
	
}

package com.rating.ratingservice.dao;

import java.util.List;

import com.rating.entities.RatingEntity;

public interface RatingServiceDao {

	public RatingEntity createRating(RatingEntity rating);
	
	public RatingEntity getRatingById(String id);
	
	public List<RatingEntity> getAllRatings();
	
	public List<RatingEntity> getByUserId(String userId);
}

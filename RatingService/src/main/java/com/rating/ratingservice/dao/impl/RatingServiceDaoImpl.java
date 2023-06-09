package com.rating.ratingservice.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entities.RatingEntity;
import com.rating.exceptions.RatingNotFoundException;
import com.rating.ratingservice.dao.RatingServiceDao;
import com.rating.repositories.RatingRepo;

@Service
public class RatingServiceDaoImpl implements RatingServiceDao {

	@Autowired
	private RatingRepo repo;

	@Override
	public RatingEntity createRating(RatingEntity rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		return repo.save(rating);
	}

	@Override
	public RatingEntity getRatingById(String id) {
		return repo.findById(id).orElseThrow(() -> new RatingNotFoundException("Rating not found with id : " + id));
	}

	@Override
	public List<RatingEntity> getAllRatings() {
		return repo.findAll();
	}

	@Override
	public List<RatingEntity> getByUserId(String userId) {
		List<RatingEntity> userRatings = repo.findByUserId(userId);
		return userRatings;
	}

	@Override
	public List<RatingEntity> getByHotelId(String hotelId) {
		List<RatingEntity> ratings = repo.findByHotelId(hotelId);
		return ratings;
	}

}

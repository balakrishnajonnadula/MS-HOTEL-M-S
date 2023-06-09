package com.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.entities.RatingEntity;

@Repository
public interface RatingRepo extends JpaRepository<RatingEntity, String>{

	public List<RatingEntity> findByUserId(String userId);
	
	public List<RatingEntity> findByHotelId(String hotelId);
	
}

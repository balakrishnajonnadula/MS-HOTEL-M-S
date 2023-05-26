package com.hotelservice.dao;

import java.util.List;

import com.hotelservice.entities.HotelEntity;

public interface HotelServiceDao {
	
	public HotelEntity createHotel(HotelEntity hotel);
	
	public HotelEntity getHotelById(String hotelId);
	
	public List<HotelEntity> getAllHotels();
}

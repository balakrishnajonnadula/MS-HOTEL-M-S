package com.hotelservice.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.dao.HotelServiceDao;
import com.hotelservice.entities.HotelEntity;
import com.hotelservice.exceptions.HotelNotFoundException;
import com.hotelservice.repository.HotelRepo;

@Service
public class HotelServiceDaoImpl implements HotelServiceDao {

	@Autowired
	private HotelRepo hRepo;

	@Override
	public HotelEntity createHotel(HotelEntity hotel) {
		hotel.setHotelId(UUID.randomUUID().toString());
		return hRepo.save(hotel);
	}

	@Override
	public HotelEntity getHotelById(String hotelId) {

		return hRepo.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found : " + hotelId));

	}

	@Override
	public List<HotelEntity> getAllHotels() {

		return hRepo.findAll();
	}

}

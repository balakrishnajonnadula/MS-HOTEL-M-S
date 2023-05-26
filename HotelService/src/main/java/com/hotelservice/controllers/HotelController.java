package com.hotelservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.dao.HotelServiceDao;
import com.hotelservice.entities.HotelEntity;

@RestController
@RequestMapping("/api/hotel/")
public class HotelController {

	@Autowired
	private HotelServiceDao hotelService;

	@PostMapping
	public ResponseEntity<HotelEntity> createHotel(@RequestBody HotelEntity hotel) {
		HotelEntity createHotel = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(createHotel);
	}

	@GetMapping("{id}")
	public ResponseEntity<HotelEntity> getHotelById(@PathVariable String id) {
		HotelEntity hotelById = hotelService.getHotelById(id);
		return ResponseEntity.ok(hotelById);
	}

	@GetMapping("")
	public ResponseEntity<List<HotelEntity>> getAllHotels() {
		List<HotelEntity> allHotels = hotelService.getAllHotels();
		return ResponseEntity.status(HttpStatus.OK).body(allHotels);
	}
}

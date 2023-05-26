package com.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelservice.entities.HotelEntity;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity, String>{

}

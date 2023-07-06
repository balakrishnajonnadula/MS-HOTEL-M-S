package com.hotelservice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "HOTEL_SERVICE")
public class HotelEntity {

	@Id
	private String hotelId;
	
	private String hotelName;
	
	private String hotelLoaction;
	
	private String hotelInfo;
	
	@Transient
	private List<RatingEntity> ratings = new ArrayList<RatingEntity>();
}

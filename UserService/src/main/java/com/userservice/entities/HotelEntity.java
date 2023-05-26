package com.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelEntity {
	private String hotelId;

	private String hotelName;

	private String hotelLoaction;

	private String hotelInfo;
}

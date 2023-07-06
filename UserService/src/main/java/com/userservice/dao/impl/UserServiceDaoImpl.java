package com.userservice.dao.impl;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.dao.UserServiceDao;
import com.userservice.entities.HotelEntity;
import com.userservice.entities.RatingsEntity;
import com.userservice.entities.UserEntity;
import com.userservice.exceptions.UserNotFoundException;
import com.userservice.repository.UserRepo;

@Service
public class UserServiceDaoImpl implements UserServiceDao {

	@Autowired
	private UserRepo uRepo;

	@Autowired
	private RestTemplate restTemp;

	@Override
	public UserEntity createUser(UserEntity user) {

		user.setUserId(UUID.randomUUID().toString());
		return uRepo.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return uRepo.findAll();
	}

	@Override
	public UserEntity getUserById(String id) {
		UserEntity userInfo = uRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found : " + id));
//		ArrayList<RatingsEntity> forObject = restTemp
//				.getForObject("http://ojas-dd600.corp.ojas-it.com:3333/api/rating/user/" + id, ArrayList.class);
//		userInfo.setRatings(forObject);

		RatingsEntity[] ratings = restTemp.getForObject("http://RATING-SERVICE/api/rating/user/" + id,
				RatingsEntity[].class);

		List<RatingsEntity> ratingsList = Arrays.stream(ratings).toList();

		List<RatingsEntity> ratingListWithHotel = ratingsList.stream().map((rating) -> {
			
			HotelEntity hotel = restTemp
					.getForEntity("http://HOTEL-SERVICE/api/hotel/" + rating.getHotelId(),
							HotelEntity.class)
					.getBody();
			
			rating.setHotel(hotel);

			return rating;
		}).collect(Collectors.toList());
		userInfo.setRatings(ratingListWithHotel);
		return userInfo;
	}

	@Override
	public String updateUserById(String id) {

		return null;
	}

	@Override
	public String delteUserById(String id) {
		return null;
	}

}

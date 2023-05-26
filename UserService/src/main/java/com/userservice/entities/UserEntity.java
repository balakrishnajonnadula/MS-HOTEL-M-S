package com.userservice.entities;

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
@Table(name = "USER_SERVICE")
public class UserEntity {

	@Id
	private String userId;

	private String name;

	private String email;

	private String about;

	@Transient
	private List<RatingsEntity> ratings = new ArrayList<>();

}

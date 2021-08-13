package com.example.surveyapisystem.model;

import com.example.surveyapisystem.entity.User;
import lombok.Data;

@Data
public class UserAnonymDTO {

	private Long id;

	public UserAnonymDTO(Long id) {
		this.id = id;
	}
}

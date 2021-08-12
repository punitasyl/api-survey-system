package com.example.surveyapisystem.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class LoginDTO {

	@ApiModelProperty(value = "test username", position = 1)
	@NotBlank
	private String username;

	@ApiModelProperty(value = "test password", position = 2)
	@NotBlank
	private String password;
}


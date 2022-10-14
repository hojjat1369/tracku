package com.ampada.tracku.user.dto;


import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CreateUserRequest {

	@NotBlank(message = "username cannot be blank!")
	private String username;
	@NotBlank(message = "password cannot be blank!")
	private String password;
}

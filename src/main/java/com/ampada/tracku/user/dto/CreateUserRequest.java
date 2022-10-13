package com.ampada.tracku.user.dto;


import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CreateUserRequest {

	@NotNull
	private String username;
	@NotNull
	private String password;
}

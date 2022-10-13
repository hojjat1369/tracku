package com.ampada.tracku.user.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CreateUserResponse {

	private String username;
}

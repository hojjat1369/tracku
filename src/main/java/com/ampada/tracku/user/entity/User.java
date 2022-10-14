package com.ampada.tracku.user.entity;


import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ampada.tracku.common.entity.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {

	@NotBlank(message = "username cannot be blank!")
	private String username;
	@NotBlank(message = "password cannot be blank!")
	private String password;

}

package com.ampada.tracku.user.entity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

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
@Validated
public class User extends AbstractEntity {

	private String username;
	private String password;

}

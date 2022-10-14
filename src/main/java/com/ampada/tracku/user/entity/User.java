package com.ampada.tracku.user.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.ampada.tracku.common.entity.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "party_user", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
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

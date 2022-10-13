package com.ampada.tracku.user.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import com.ampada.tracku.common.entity.AbstractEntity;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "party_user", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
@Getter
@Setter
public class User extends AbstractEntity {

	@NotBlank
	private String username;
	private String password;

}

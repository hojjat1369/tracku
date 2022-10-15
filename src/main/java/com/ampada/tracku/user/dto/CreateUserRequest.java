package com.ampada.tracku.user.dto;


import com.ampada.tracku.common.dto.CommonRequest;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.ObjectUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CreateUserRequest extends CommonRequest {

	private static final long serialVersionUID = -6220367489167311324L;

	private String username;
	private String password;

	@Override
	public void validate() throws DomainException {

		ObjectUtil.notNull(username, "username cannot be blank!");
		ObjectUtil.notNull(password, "password cannot be blank!");
	}
}

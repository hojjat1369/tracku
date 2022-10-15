package com.ampada.tracku.user.dto;


import javax.validation.constraints.NotNull;

import com.ampada.tracku.common.dto.CommonRequest;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.ObjectUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class LoginRequest extends CommonRequest {

	private static final long serialVersionUID = 2901032733381519846L;
	@NotNull
	private String username;
	@NotNull
	private String password;

	@Override
	public void validate() throws DomainException {

		ObjectUtil.notNull(username, "username cannot be blank!");
		ObjectUtil.notNull(password, "password cannot be blank!");
	}
}

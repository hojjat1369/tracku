package com.ampada.tracku.user.service;


import javax.validation.constraints.NotNull;

import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.user.dto.CreateUserRequest;
import com.ampada.tracku.user.dto.CreateUserResponse;
import com.ampada.tracku.user.dto.LoginRequest;
import com.ampada.tracku.user.dto.LoginResponse;


public interface UserService {

	CreateUserResponse create(@NotNull CreateUserRequest createUserRequest) throws DomainException;

	LoginResponse authenticate(@NotNull LoginRequest loginRequest) throws DomainException;

}

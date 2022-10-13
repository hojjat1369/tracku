package com.ampada.tracku.user.service;


import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.user.dto.CreateUserRequest;
import com.ampada.tracku.user.dto.CreateUserResponse;
import com.ampada.tracku.user.dto.LoginRequest;
import com.ampada.tracku.user.dto.LoginResponse;


public interface UserService {

	CreateUserResponse create(CreateUserRequest createUserRequest) throws DomainException;

	LoginResponse create(LoginRequest loginRequest) throws DomainException;

}

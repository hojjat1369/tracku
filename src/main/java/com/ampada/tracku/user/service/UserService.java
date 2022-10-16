package com.ampada.tracku.user.service;


import java.util.List;

import javax.validation.constraints.NotNull;

import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.user.dto.CreateUserRequest;
import com.ampada.tracku.user.dto.CreateUserResponse;
import com.ampada.tracku.user.dto.LoginRequest;
import com.ampada.tracku.user.dto.LoginResponse;
import com.ampada.tracku.user.entity.User;


public interface UserService {

	CreateUserResponse create(@NotNull CreateUserRequest createUserRequest) throws DomainException;

	LoginResponse authenticate(@NotNull LoginRequest loginRequest) throws DomainException;

	List<User> getByIds(@NotNull List<String> ids) throws DomainException;
}

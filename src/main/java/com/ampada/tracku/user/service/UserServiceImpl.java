package com.ampada.tracku.user.service;


import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.user.dto.CreateUserRequest;
import com.ampada.tracku.user.dto.CreateUserResponse;
import com.ampada.tracku.user.dto.LoginRequest;
import com.ampada.tracku.user.dto.LoginResponse;
import com.ampada.tracku.user.entity.User;
import com.ampada.tracku.user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper;
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {

		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CreateUserResponse create(@NotNull CreateUserRequest request) throws DomainException {

		User user = modelMapper.map(request, User.class);
		userRepository.save(user);
		return CreateUserResponse.builder().username(user.getUsername()).build();
	}

	@Override
	public LoginResponse create(@NotNull LoginRequest request) throws DomainException {

		Optional<User> findByUsernameAndPassword = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());

		return LoginResponse.builder().username(findByUsernameAndPassword.get().getUsername()).build();
	}

}

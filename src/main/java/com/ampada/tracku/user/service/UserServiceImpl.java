package com.ampada.tracku.user.service;


import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.SecurityUtil;
import com.ampada.tracku.user.dto.CreateUserRequest;
import com.ampada.tracku.user.dto.CreateUserResponse;
import com.ampada.tracku.user.dto.LoginRequest;
import com.ampada.tracku.user.dto.LoginResponse;
import com.ampada.tracku.user.entity.User;
import com.ampada.tracku.user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	@Override
	public CreateUserResponse create(@NotNull CreateUserRequest request) throws DomainException {

		request.validate();
		User user = User.builder().username(request.getUsername()).password(SecurityUtil.getSHA512SecurePassword(request.getPassword())).build();
		userRepository.save(user);
		return CreateUserResponse.builder().username(user.getUsername()).build();
	}

	@Override
	public LoginResponse authenticate(@NotNull LoginRequest request) throws DomainException {

		request.validate();
		Optional<User> user = userRepository.findByUsernameAndPassword(request.getUsername(), SecurityUtil.getSHA512SecurePassword(request.getPassword()));
		if (!user.isPresent()){
			throw new DomainException("user not found!");
		}
		return LoginResponse.builder().username(user.get().getUsername()).build();
	}

	@Override
	public List<User> getByIds(@NotNull List<Long> ids) throws DomainException {

		return userRepository.findAll();
	}

}

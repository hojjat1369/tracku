package com.ampada.tracku.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.JwtTokenUtil;
import com.ampada.tracku.user.dto.CreateUserRequest;
import com.ampada.tracku.user.dto.CreateUserResponse;
import com.ampada.tracku.user.dto.LoginRequest;
import com.ampada.tracku.user.dto.LoginResponse;
import com.ampada.tracku.user.service.UserService;


@RestController
@RequestMapping(value = "/api")
@Validated
public class UserController {

	private final UserService userService;
	private final JwtTokenUtil jwtTokenUtil;

	public UserController(UserService userService, JwtTokenUtil jwtTokenUtil) {

		this.userService = userService;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@PostMapping(path = "/signUp")
	public ResponseEntity<CreateUserResponse> create(@Valid @RequestBody CreateUserRequest model, HttpServletRequest request) throws DomainException {

		return new ResponseEntity<>(userService.create(model), HttpStatus.OK);
	}

	@PostMapping(path = "/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest model, HttpServletRequest request) throws DomainException {

		LoginResponse loginResponse = userService.authenticate(model);
		loginResponse.setToken(jwtTokenUtil.generateAccessToken(model.getUsername()));
		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}

}

package com.ampada.tracku.unit.user;


import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.user.dto.LoginRequest;
import com.ampada.tracku.user.dto.LoginResponse;
import com.ampada.tracku.user.entity.User;
import com.ampada.tracku.user.repository.UserRepository;
import com.ampada.tracku.user.service.UserService;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@Transactional
@ActiveProfiles("jenkins")
@RunWith(SpringJUnit4ClassRunner.class)
@Category(UnitTest.class)
public class AuthenticateUserTest {

	@Autowired
	private UserService userService;
	@Mock
	private UserRepository userRepository;

	private LoginRequest request;
	private Optional<User> user;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() throws DomainException {

		request = LoginRequest.builder().username("test").password("test").build();
		User testUser = User.builder().username("test").password("test").build();
		user = Optional.of(testUser);
		Mockito.doReturn(user).when(userRepository).findByUsernameAndPassword("test", "test");
	}

	@Test
	public void nullUsername() throws DomainException {

		request.setUsername(null);
		thrown.expect(DomainException.class);
		thrown.expectMessage("user not found!");

		userService.authenticate(request);
	}

	@Test
	public void nullPassword() throws DomainException {

		request.setPassword(null);
		thrown.expect(DomainException.class);
		thrown.expectMessage("user not found!");

		userService.authenticate(request);
	}

	@Test
	public void invalidUsernameOrPassword() throws DomainException {

		request.setUsername("invalid");
		thrown.expect(DomainException.class);
		thrown.expectMessage("user not found!");

		userService.authenticate(request);
	}

	@Test
	public void ok() throws DomainException {

		LoginResponse response = userService.authenticate(request);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getUsername(), request.getUsername());

	}
}

package com.ampada.tracku.unit.user;


import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.user.dto.CreateUserRequest;
import com.ampada.tracku.user.dto.CreateUserResponse;
import com.ampada.tracku.user.repository.UserRepository;
import com.ampada.tracku.user.service.UserService;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@Transactional
@ActiveProfiles("jenkins")
@RunWith(SpringJUnit4ClassRunner.class)
@Category(UnitTest.class)
public class CreateUserTest {

	@Autowired
	private UserService userService;
	@Mock
	private UserRepository userRepository;

	private CreateUserRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		request = CreateUserRequest.builder().username("test").password("test").build();
		Mockito.doAnswer((Answer<Void>) invocation -> null).when(userRepository).save(Mockito.any());
	}

	@Test
	public void nullInput() throws DomainException {

		thrown.expect(IllegalArgumentException.class);

		userService.create(null);
	}

	@Test
	public void nullUsername() throws DomainException {

		request.setUsername(null);
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("username cannot be blank!");

		userService.create(request);
	}

	@Test
	public void nullPassword() throws DomainException {

		request.setPassword(null);
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("password cannot be blank!");

		userService.create(request);
	}

	@Test
	public void ok() throws DomainException {

		CreateUserResponse userResponse = userService.create(request);
		Assert.assertNotNull(userResponse);
		Assert.assertEquals(userResponse.getUsername(), request.getUsername());

	}
}

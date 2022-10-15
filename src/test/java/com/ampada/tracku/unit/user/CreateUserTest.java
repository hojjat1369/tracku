package com.ampada.tracku.unit.user;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.unit.common.TestUtil;
import com.ampada.tracku.user.dto.CreateUserRequest;
import com.ampada.tracku.user.dto.CreateUserResponse;
import com.ampada.tracku.user.entity.User;
import com.ampada.tracku.user.repository.UserRepository;
import com.ampada.tracku.user.service.UserServiceImpl;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@ActiveProfiles("jenkins")
@RunWith(SpringRunner.class)
@Category(UnitTest.class)
public class CreateUserTest {

	@InjectMocks
	private UserServiceImpl userService;
	@Mock
	private UserRepository userRepository;

	private CreateUserRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		request = CreateUserRequest.builder().username("test").password("test").build();
	}

	@Test
	public void nullUsername() throws DomainException {

		request.setUsername(null);
		thrown.expect(DomainException.class);
		thrown.expectMessage("username cannot be blank!");

		userService.create(request);
	}

	@Test
	public void nullPassword() throws DomainException {

		request.setPassword(null);
		thrown.expect(DomainException.class);
		thrown.expectMessage("password cannot be blank!");

		userService.create(request);
	}

	@Test
	public void ok() throws DomainException {

		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(TestUtil.getTestUser());
		CreateUserResponse userResponse = userService.create(request);
		Assert.assertNotNull(userResponse);
		Assert.assertEquals(userResponse.getUsername(), request.getUsername());

	}
}

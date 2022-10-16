package com.ampada.tracku.unit.card;


import java.util.Arrays;
import java.util.Optional;

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
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ampada.tracku.board.service.BoardServiceImpl;
import com.ampada.tracku.card.dto.CreateCardRequest;
import com.ampada.tracku.card.dto.CreateCardResponse;
import com.ampada.tracku.card.entity.Card;
import com.ampada.tracku.card.repository.CardRepository;
import com.ampada.tracku.card.service.CardServiceImpl;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.ErrorMessage;
import com.ampada.tracku.unit.common.TestUtil;
import com.ampada.tracku.user.entity.User;
import com.ampada.tracku.user.service.UserServiceImpl;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@ActiveProfiles("jenkins")
@RunWith(SpringJUnit4ClassRunner.class)
@Category(UnitTest.class)
public class CreateCardTest {

	@Mock
	private BoardServiceImpl boardService;
	@Mock
	private UserServiceImpl userService;
	@InjectMocks
	private CardServiceImpl cardService;

	@Mock
	private CardRepository cardRepository;

	private CreateCardRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		request = CreateCardRequest.builder().cardTitle("testBoardName").boardId("10").userId(Arrays.asList("1", "2")).build();
		Mockito.doAnswer((Answer<Void>) invocation -> null).when(cardRepository).save(Mockito.any());
	}

	@Test
	public void nullBoardId() throws DomainException {

		Mockito.when(boardService.getById(Mockito.any())).thenReturn(Optional.ofNullable(null));
		Mockito.when(userService.getByIds(Mockito.any())).thenReturn(Arrays.asList(User.builder().username("testUsername").build()));

		request.setBoardId(null);
		thrown.expect(DomainException.class);
		thrown.expectMessage(ErrorMessage.BOARD_NOT_BLANK);

		cardService.create(request);
	}

	@Test
	public void invalidBoardId() throws DomainException {

		Mockito.when(boardService.getById(Mockito.any())).thenReturn(Optional.ofNullable(null));
		Mockito.when(userService.getByIds(Mockito.any())).thenReturn(Arrays.asList(TestUtil.getTestUser()));

		request.setBoardId("invalidId");
		thrown.expect(DomainException.class);
		thrown.expectMessage(ErrorMessage.BOARD_NOT_FOUND);

		cardService.create(request);
	}

	@Test
	public void ok() throws DomainException {

		Mockito.when(cardRepository.save(Mockito.any(Card.class))).thenReturn(TestUtil.getTestCard());
		Mockito.when(boardService.getById(Mockito.any())).thenReturn(Optional.of(TestUtil.getTestBoard()));
		Mockito.when(userService.getByIds(Mockito.any())).thenReturn(Arrays.asList(TestUtil.getTestUser()));

		CreateCardResponse response = cardService.create(request);
		Assert.assertNotNull(response);
	}
}

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
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.board.service.BoardServiceImpl;
import com.ampada.tracku.card.dto.UpdateCardRequest;
import com.ampada.tracku.card.dto.UpdateCardResponse;
import com.ampada.tracku.card.entity.Card;
import com.ampada.tracku.card.repository.CardRepository;
import com.ampada.tracku.card.service.CardServiceImpl;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.user.entity.User;
import com.ampada.tracku.user.service.UserServiceImpl;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@ActiveProfiles("jenkins")
@RunWith(SpringJUnit4ClassRunner.class)
@Category(UnitTest.class)
public class UpdateCardTest {

	@Mock
	private BoardServiceImpl boardService;
	@Mock
	private UserServiceImpl userService;
	@InjectMocks
	private CardServiceImpl cardService;

	@Mock
	private CardRepository cardRepository;

	private UpdateCardRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		request = UpdateCardRequest.builder().id("20").cardTitle("testBoardName").boardId("10").userId(Arrays.asList("1", "2")).build();
		Mockito.doAnswer((Answer<Void>) invocation -> null).when(cardRepository).save(Mockito.any());
	}

	@Test
	public void ok() throws DomainException {

		Mockito.when(cardRepository.findById(Mockito.any())).thenReturn(Optional.of(Card.builder().cardTitle("testCardTitle").build()));
		Mockito.when(boardService.getById(Mockito.any())).thenReturn(Optional.of(Board.builder().boardName("testBoardName").build()));
		Mockito.when(userService.getByIds(Mockito.any())).thenReturn(Arrays.asList(User.builder().username("testUsername").build()));

		UpdateCardResponse response = cardService.update(request);
		Assert.assertNotNull(response);
	}
}

package com.ampada.tracku.unit.board;


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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ampada.tracku.board.dto.UpdateBoardRequest;
import com.ampada.tracku.board.dto.UpdateBoardResponse;
import com.ampada.tracku.board.repository.BoardRepository;
import com.ampada.tracku.board.service.BoardServiceImpl;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.ErrorMessage;
import com.ampada.tracku.unit.common.TestUtil;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@ActiveProfiles("jenkins")
@RunWith(SpringRunner.class)
@Category(UnitTest.class)
public class UpdateBoardTest {

	@InjectMocks
	private BoardServiceImpl boardService;
	@Mock
	private BoardRepository boardRepository;

	private UpdateBoardRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		request = UpdateBoardRequest.builder().boardName("testBoardName2").id("10").build();
	}

	@Test
	public void nullId() throws DomainException {

		Mockito.when(boardRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));
		request.setId("-1");
		thrown.expect(DomainException.class);
		thrown.expectMessage(ErrorMessage.BOARD_NOT_FOUND);

		boardService.update(request);
	}

	@Test
	public void ok() throws DomainException {

		Mockito.when(boardRepository.findById(Mockito.any())).thenReturn(Optional.of(TestUtil.getTestBoard()));
		UpdateBoardResponse response = boardService.update(request);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getBoardName(), request.getBoardName());
	}
}

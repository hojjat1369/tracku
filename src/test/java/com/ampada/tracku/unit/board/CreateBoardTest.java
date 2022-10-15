package com.ampada.tracku.unit.board;


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

import com.ampada.tracku.board.dto.CreateBoardRequest;
import com.ampada.tracku.board.dto.CreateBoardResponse;
import com.ampada.tracku.board.entity.Board;
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
public class CreateBoardTest {

	@InjectMocks
	private BoardServiceImpl boardService;
	@Mock
	private BoardRepository boardRepository;

	private CreateBoardRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		request = CreateBoardRequest.builder().boardName("testBoardName").build();
	}

	@Test
	public void nullBoardName() throws DomainException {

		request.setBoardName(null);
		thrown.expect(DomainException.class);
		thrown.expectMessage(ErrorMessage.BOARD_NAME_NOT_BLANK);

		boardService.create(request);
	}

	@Test
	public void ok() throws DomainException {

		Mockito.when(boardRepository.save(Mockito.any(Board.class))).thenReturn(TestUtil.getTestBoard());
		CreateBoardResponse response = boardService.create(request);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getBoardName(), request.getBoardName());
	}
}

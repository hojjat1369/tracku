package com.ampada.tracku.unit.board;


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

import com.ampada.tracku.board.dto.CreateBoardRequest;
import com.ampada.tracku.board.dto.CreateBoardResponse;
import com.ampada.tracku.board.repository.BoardRepository;
import com.ampada.tracku.board.service.BoardService;
import com.ampada.tracku.common.exception.DomainException;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@Transactional
@ActiveProfiles("jenkins")
@RunWith(SpringJUnit4ClassRunner.class)
@Category(UnitTest.class)
public class CreateBoardTest {

	@Autowired
	private BoardService boardService;
	@Mock
	private BoardRepository boardRepository;

	private CreateBoardRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		request = CreateBoardRequest.builder().boardName("testBoardName").build();
		Mockito.doAnswer((Answer<Void>) invocation -> null).when(boardRepository).save(Mockito.any());
	}

	@Test
	public void nullInput() throws DomainException {

		thrown.expect(IllegalArgumentException.class);

		boardService.create(null);
	}

	@Test
	public void nullBoardName() throws DomainException {

		request.setBoardName(null);
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("boardName cannot be blank!");

		boardService.create(request);
	}

	@Test
	public void ok() throws DomainException {

		CreateBoardResponse response = boardService.create(request);
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getBoardName(), request.getBoardName());
	}
}

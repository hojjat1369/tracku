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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ampada.tracku.board.dto.DeleteBoardRequest;
import com.ampada.tracku.board.dto.DeleteBoardResponse;
import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.board.repository.BoardRepository;
import com.ampada.tracku.board.service.BoardServiceImpl;
import com.ampada.tracku.common.exception.DomainException;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@Transactional
@ActiveProfiles("jenkins")
@RunWith(SpringJUnit4ClassRunner.class)
@Category(UnitTest.class)
public class DeleteBoardTest {

	@InjectMocks
	private BoardServiceImpl boardService;
	@Mock
	private BoardRepository boardRepository;

	private DeleteBoardRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		request = DeleteBoardRequest.builder().id(10l).build();
	}

	@Test
	public void nullId() throws DomainException {

		Mockito.when(boardRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));
		request.setId(-1l);
		thrown.expect(DomainException.class);
		thrown.expectMessage("board not found!");

		boardService.delete(request);
	}

	@Test
	public void ok() throws DomainException {

		Mockito.when(boardRepository.findById(Mockito.any())).thenReturn(Optional.of(Board.builder().boardName("testBoardName").build()));
		DeleteBoardResponse response = boardService.delete(request);
		Assert.assertNotNull(response);
	}
}
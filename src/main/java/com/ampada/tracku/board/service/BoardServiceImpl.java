package com.ampada.tracku.board.service;


import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.ampada.tracku.board.dto.CreateBoardRequest;
import com.ampada.tracku.board.dto.CreateBoardResponse;
import com.ampada.tracku.board.dto.DeleteBoardRequest;
import com.ampada.tracku.board.dto.DeleteBoardResponse;
import com.ampada.tracku.board.dto.GetBoardRequest;
import com.ampada.tracku.board.dto.GetBoardResponse;
import com.ampada.tracku.board.dto.UpdateBoardRequest;
import com.ampada.tracku.board.dto.UpdateBoardResponse;
import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.board.repository.BoardRepository;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.ErrorMessage;
import com.ampada.tracku.user.service.UserService;


@Service
public class BoardServiceImpl implements BoardService {

	private BoardRepository repository;
	private UserService userService;

	public BoardServiceImpl(BoardRepository repository, UserService userService) {

		this.repository = repository;
		this.userService = userService;
	}

	@Override
	public CreateBoardResponse create(@NotNull CreateBoardRequest request) throws DomainException {

		request.validate();
		Board board = Board.builder().boardName(request.getBoardName()).build();
		repository.save(board);
		return CreateBoardResponse.builder().boardName(board.getBoardName()).build();
	}

	@Override
	public UpdateBoardResponse update(@NotNull UpdateBoardRequest request) throws DomainException {

		request.validate();
		Optional<Board> board = repository.findById(request.getId());
		if (board.isPresent()){
			board.get().setBoardName(request.getBoardName());
			repository.save(board.get());
		}
		else{
			throw new DomainException(ErrorMessage.BOARD_NOT_FOUND);
		}
		return UpdateBoardResponse.builder().id(request.getId()).boardName(request.getBoardName()).build();
	}

	@Override
	public DeleteBoardResponse delete(@NotNull DeleteBoardRequest request) throws DomainException {

		request.validate();
		Optional<Board> board = repository.findById(request.getId());
		if (board.isPresent()){
			board.get().setEnable(false);
			repository.save(board.get());
		}
		else{
			throw new DomainException(ErrorMessage.BOARD_NOT_FOUND);
		}
		return DeleteBoardResponse.builder().id(request.getId()).build();
	}

	@Override
	public GetBoardResponse get(@NotNull GetBoardRequest request) throws DomainException {

		Optional<Board> board = repository.findById(request.getId());
		if (board.isPresent())
			return GetBoardResponse.builder().boardName(board.get().getBoardName()).id(board.get().getId()).build();
		throw new DomainException("board not found!");
	}

	@Override
	public Optional<Board> getById(@NotNull String id) throws DomainException {

		return repository.findById(id);
	}

}

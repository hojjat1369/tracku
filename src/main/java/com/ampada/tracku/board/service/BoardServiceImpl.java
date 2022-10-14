package com.ampada.tracku.board.service;


import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ampada.tracku.board.dto.CreateBoardRequest;
import com.ampada.tracku.board.dto.CreateBoardResponse;
import com.ampada.tracku.board.dto.DeleteBoardRequest;
import com.ampada.tracku.board.dto.DeleteBoardResponse;
import com.ampada.tracku.board.dto.UpdateBoardRequest;
import com.ampada.tracku.board.dto.UpdateBoardResponse;
import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.board.repository.BoardRepository;
import com.ampada.tracku.common.exception.DomainException;


@Service
public class BoardServiceImpl implements BoardService {

	private ModelMapper modelMapper;
	private BoardRepository repository;

	public BoardServiceImpl(BoardRepository repository, ModelMapper modelMapper) {

		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CreateBoardResponse create(@NotNull CreateBoardRequest request) throws DomainException {

		Board board = modelMapper.map(request, Board.class);
		repository.save(board);
		return CreateBoardResponse.builder().boardName(board.getBoardName()).build();
	}

	@Override
	public UpdateBoardResponse update(@NotNull UpdateBoardRequest request) throws DomainException {

		Optional<Board> board = repository.findById(request.getId());
		if (board.isPresent()){
			board.get().setBoardName(request.getBoardName());
			repository.save(board.get());
		}
		else{
			throw new DomainException("board not found!");
		}
		return UpdateBoardResponse.builder().id(request.getId()).boardName(request.getBoardName()).build();
	}

	@Override
	public DeleteBoardResponse delete(@NotNull DeleteBoardRequest request) throws DomainException {

		Optional<Board> board = repository.findById(request.getId());
		if (board.isPresent()){
			board.get().setEnable(false);
			repository.save(board.get());
		}
		else{
			throw new DomainException("board not found!");
		}
		return DeleteBoardResponse.builder().id(request.getId()).build();
	}

	@Override
	public Optional<Board> getById(@NotNull Long id) throws DomainException {

		return repository.findById(id);
	}

}

package com.ampada.tracku.board.service;


import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.ampada.tracku.board.dto.CreateBoardRequest;
import com.ampada.tracku.board.dto.CreateBoardResponse;
import com.ampada.tracku.board.dto.DeleteBoardRequest;
import com.ampada.tracku.board.dto.DeleteBoardResponse;
import com.ampada.tracku.board.dto.UpdateBoardRequest;
import com.ampada.tracku.board.dto.UpdateBoardResponse;
import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.common.exception.DomainException;


public interface BoardService {

	CreateBoardResponse create(@NotNull CreateBoardRequest request) throws DomainException;

	UpdateBoardResponse update(@NotNull UpdateBoardRequest request) throws DomainException;

	DeleteBoardResponse delete(@NotNull DeleteBoardRequest request) throws DomainException;

	Optional<Board> getById(@NotNull Long id) throws DomainException;

}

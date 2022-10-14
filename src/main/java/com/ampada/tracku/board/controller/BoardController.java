package com.ampada.tracku.board.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ampada.tracku.board.dto.CreateBoardRequest;
import com.ampada.tracku.board.dto.CreateBoardResponse;
import com.ampada.tracku.board.dto.DeleteBoardRequest;
import com.ampada.tracku.board.dto.DeleteBoardResponse;
import com.ampada.tracku.board.dto.GetBoardRequest;
import com.ampada.tracku.board.dto.GetBoardResponse;
import com.ampada.tracku.board.dto.UpdateBoardRequest;
import com.ampada.tracku.board.dto.UpdateBoardResponse;
import com.ampada.tracku.board.service.BoardService;
import com.ampada.tracku.common.exception.DomainException;


@RestController
@RequestMapping(value = "/api/board")
@Validated
public class BoardController {

	private final BoardService service;

	public BoardController(BoardService boardService) {

		this.service = boardService;
	}

	@PostMapping
	public ResponseEntity<CreateBoardResponse> create(@Valid @RequestBody CreateBoardRequest model, HttpServletRequest request) throws DomainException {

		return new ResponseEntity<>(service.create(model), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UpdateBoardResponse> update(@Valid @RequestBody UpdateBoardRequest model, HttpServletRequest request) throws DomainException {

		return new ResponseEntity<>(service.update(model), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<DeleteBoardResponse> delete(@Valid @RequestBody DeleteBoardRequest model, HttpServletRequest request) throws DomainException {

		return new ResponseEntity<>(service.delete(model), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<GetBoardResponse> get(@Valid @RequestBody GetBoardRequest model, HttpServletRequest request) throws DomainException {

		return new ResponseEntity<>(service.get(model), HttpStatus.OK);
	}

}

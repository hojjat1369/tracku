package com.ampada.tracku.card.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ampada.tracku.card.dto.CreateCardRequest;
import com.ampada.tracku.card.dto.CreateCardResponse;
import com.ampada.tracku.card.dto.DeleteCardRequest;
import com.ampada.tracku.card.dto.DeleteCardResponse;
import com.ampada.tracku.card.dto.GetCardRequest;
import com.ampada.tracku.card.dto.GetCardResponse;
import com.ampada.tracku.card.dto.UpdateCardRequest;
import com.ampada.tracku.card.dto.UpdateCardResponse;
import com.ampada.tracku.card.service.CardService;
import com.ampada.tracku.common.aspect.Auth;
import com.ampada.tracku.common.exception.DomainException;


@RestController
@RequestMapping(value = "/api/{boardId}/cards")
@Validated
public class CardController {

	private final CardService service;

	public CardController(CardService cardService) {

		this.service = cardService;
	}

	@PostMapping
	@Auth
	public ResponseEntity<CreateCardResponse> create(@PathVariable("boardId") Long boardId, @Valid @RequestBody CreateCardRequest model, HttpServletRequest request) throws DomainException {

		model.setBoardId(boardId);
		return new ResponseEntity<>(service.create(model), HttpStatus.OK);
	}

	@PutMapping
	@Auth
	public ResponseEntity<UpdateCardResponse> update(@PathVariable("boardId") Long boardId, @Valid @RequestBody UpdateCardRequest model, HttpServletRequest request) throws DomainException {

		model.setBoardId(boardId);
		return new ResponseEntity<>(service.update(model), HttpStatus.OK);
	}

	@DeleteMapping
	@Auth
	public ResponseEntity<DeleteCardResponse> delete(@Valid @RequestBody DeleteCardRequest model, HttpServletRequest request) throws DomainException {

		return new ResponseEntity<>(service.delete(model), HttpStatus.OK);
	}

	@GetMapping(path = "/list")
	@Auth
	public ResponseEntity<GetCardResponse> get(@Valid @RequestBody GetCardRequest model, HttpServletRequest request) throws DomainException {

		return new ResponseEntity<>(service.getCards(model), HttpStatus.OK);
	}

}

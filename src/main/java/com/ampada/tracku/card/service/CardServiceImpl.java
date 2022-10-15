package com.ampada.tracku.card.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.board.service.BoardService;
import com.ampada.tracku.card.dto.CreateCardRequest;
import com.ampada.tracku.card.dto.CreateCardResponse;
import com.ampada.tracku.card.dto.DeleteCardRequest;
import com.ampada.tracku.card.dto.DeleteCardResponse;
import com.ampada.tracku.card.dto.GetCardRequest;
import com.ampada.tracku.card.dto.GetCardResponse;
import com.ampada.tracku.card.dto.UpdateCardRequest;
import com.ampada.tracku.card.dto.UpdateCardResponse;
import com.ampada.tracku.card.entity.Card;
import com.ampada.tracku.card.entity.Card.CardBuilder;
import com.ampada.tracku.card.repository.CardRepository;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.ErrorMessage;
import com.ampada.tracku.user.entity.User;
import com.ampada.tracku.user.service.UserService;


@Service
public class CardServiceImpl implements CardService {

	private CardRepository repository;
	private BoardService boardService;
	private UserService userService;

	public CardServiceImpl(CardRepository repository, UserService userService, BoardService boardService) {

		this.repository = repository;
		this.userService = userService;
		this.boardService = boardService;
	}

	@Override
	public CreateCardResponse create(@NotNull CreateCardRequest request) throws DomainException {

		request.validate();
		Optional<Board> board = boardService.getById(request.getBoardId());
		List<User> users = userService.getByIds(request.getUserId());
		if (!board.isPresent()){
			throw new DomainException(ErrorMessage.BOARD_NOT_FOUND);
		}
		Card card = Card.builder().board(board.get()).cardTitle(request.getCardTitle()).users(new HashSet<>(users)).build();
		repository.save(card);
		return CreateCardResponse.builder().cardTitle(card.getCardTitle()).id(card.getId()).build();
	}

	@Override
	public UpdateCardResponse update(@NotNull UpdateCardRequest request) throws DomainException {

		request.validate();
		Optional<Board> board = boardService.getById(request.getBoardId());
		List<User> users = userService.getByIds(request.getUserId());
		CardBuilder builder = Card.builder();
		if (board.isPresent())
			builder.board(board.get());
		if (!users.isEmpty())
			builder.users(new HashSet<>(users));
		Card card = builder.cardTitle(request.getCardTitle()).build();
		repository.save(card);
		return UpdateCardResponse.builder().cardTitle(card.getCardTitle()).id(card.getId()).build();
	}

	@Override
	public DeleteCardResponse delete(@NotNull DeleteCardRequest request) throws DomainException {

		request.validate();
		Optional<Card> card = repository.findById(request.getId());
		if (card.isPresent()){
			card.get().setEnable(false);
			repository.save(card.get());
		}
		else{
			throw new DomainException(ErrorMessage.CARD_NOT_FOUND);
		}
		return DeleteCardResponse.builder().id(request.getId()).build();
	}

	@Override
	public GetCardResponse getCards(GetCardRequest request) {

		GetCardResponse response = GetCardResponse.builder().cards(new ArrayList<>()).build();
//		List<Card> cards = dslRepository.getCards(request);
//		if (!cards.isEmpty()){
//			for (Card card : cards){
//				response.getCards().add(CardDetail.builder().boardId(card.getBoard().getId()).cardTitle(card.getCardTitle()).userId(card.getUserIds()).build());
//			}
//		}
		return response;
	}

}

package com.ampada.tracku.card.service;


import javax.validation.constraints.NotNull;

import com.ampada.tracku.card.dto.CreateCardRequest;
import com.ampada.tracku.card.dto.CreateCardResponse;
import com.ampada.tracku.card.dto.DeleteCardRequest;
import com.ampada.tracku.card.dto.DeleteCardResponse;
import com.ampada.tracku.card.dto.GetCardRequest;
import com.ampada.tracku.card.dto.GetCardResponse;
import com.ampada.tracku.card.dto.UpdateCardRequest;
import com.ampada.tracku.card.dto.UpdateCardResponse;
import com.ampada.tracku.common.exception.DomainException;


public interface CardService {

	CreateCardResponse create(@NotNull CreateCardRequest request) throws DomainException;

	UpdateCardResponse update(@NotNull UpdateCardRequest request) throws DomainException;

	DeleteCardResponse delete(@NotNull DeleteCardRequest request) throws DomainException;

	GetCardResponse getCards(GetCardRequest request);

}

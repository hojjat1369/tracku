package com.ampada.tracku.card.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.ampada.tracku.card.dto.GetCardRequest;
import com.ampada.tracku.card.entity.Card;


@Repository
public interface CardDslRepository {

	public List<Card> getCards(GetCardRequest request);

}

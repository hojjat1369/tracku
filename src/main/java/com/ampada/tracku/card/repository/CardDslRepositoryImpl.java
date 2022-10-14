package com.ampada.tracku.card.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ampada.tracku.card.dto.GetCardRequest;
import com.ampada.tracku.card.entity.Card;


public class CardDslRepositoryImpl implements CardDslRepository {

	@Autowired
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public List<Card> getCards(GetCardRequest request) {

		return null;
	}

}

package com.ampada.tracku.card.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ampada.tracku.card.dto.GetCardRequest;
import com.ampada.tracku.card.entity.Card;
import com.ampada.tracku.card.entity.QCard;
import com.querydsl.jpa.impl.JPAQuery;

import ir.fanap.crm.utility.util.Validator;


public class CardDslRepositoryImpl implements CardDslRepository {

	@Autowired
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public List<Card> getCards(GetCardRequest request) {

		return getCardsQuery(request).fetch();
	}

	public JPAQuery<Card> getCardsQuery(GetCardRequest request) {

		JPAQuery<Card> jpaQuery = new JPAQuery<>(entityManager);

		QCard qCard = QCard.card;

		JPAQuery<Card> query = jpaQuery.from(qCard).where(qCard.enable.eq(Boolean.TRUE)).orderBy(qCard.modifiedOn.desc());

		if (Validator.notNull(request.getCardTitle()))
			query.where(qCard.cardTitle.like("%" + request.getCardTitle() + "%"));

		query.limit(request.getBegin());
		query.offset(request.getLength());
		return query;
	}

}

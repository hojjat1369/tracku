package com.ampada.tracku.card.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ampada.tracku.card.dto.GetCardRequest;
import com.ampada.tracku.card.entity.Card;


public class CardDslRepositoryImpl implements CardDslRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Card> getCards(GetCardRequest request) {

		Query query = new Query();
		if (request.getCardTitle() != null){
			query.addCriteria(Criteria.where("cardTitle").is(request.getCardTitle()));
		}
		query.with(new Sort(Direction.DESC, "modifiedOn"));
		return mongoTemplate.find(query, Card.class);
	}

}

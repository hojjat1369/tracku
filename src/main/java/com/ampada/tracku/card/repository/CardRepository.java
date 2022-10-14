package com.ampada.tracku.card.repository;


import org.springframework.stereotype.Repository;

import com.ampada.tracku.card.entity.Card;
import com.ampada.tracku.common.repository.BaseRepository;


@Repository
public interface CardRepository extends BaseRepository<Card , Long>, CardDslRepository {

}

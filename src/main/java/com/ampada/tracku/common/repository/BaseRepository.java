package com.ampada.tracku.common.repository;


import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ampada.tracku.common.entity.AbstractEntity;


public interface BaseRepository<T extends AbstractEntity, id extends Serializable> extends MongoRepository<T , String> {

}

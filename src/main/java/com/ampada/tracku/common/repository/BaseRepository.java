package com.ampada.tracku.common.repository;


import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ampada.tracku.common.entity.AbstractEntity;


@NoRepositoryBean
public interface BaseRepository<T extends AbstractEntity, id extends Serializable> extends PagingAndSortingRepository<T , Long> {

}

package com.ampada.tracku.board.repository;


import org.springframework.stereotype.Repository;

import com.ampada.tracku.board.entity.Board;
import com.ampada.tracku.common.repository.BaseRepository;


@Repository
public interface BoardRepository extends BaseRepository<Board , String>, BoardDslRepository {

}

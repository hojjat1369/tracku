package com.ampada.tracku.user.repository;


import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ampada.tracku.common.repository.BaseRepository;
import com.ampada.tracku.user.entity.User;


@Repository
public interface UserRepository extends BaseRepository<User , Long>, UserDslRepository {

	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username, String password);

	Boolean existsByUsername(String username);

}

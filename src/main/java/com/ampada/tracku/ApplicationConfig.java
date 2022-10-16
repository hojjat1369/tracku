package com.ampada.tracku;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ampada.tracku.card.repository.CardDslRepository;
import com.ampada.tracku.card.repository.CardDslRepositoryImpl;
import com.ampada.tracku.common.util.JwtTokenUtil;


@Configuration
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	@Bean
	public JwtTokenUtil jwtTokenUtil() {

		return new JwtTokenUtil();
	}

	@Bean
	public CardDslRepository cardDslRepository() {

		return new CardDslRepositoryImpl();
	}
}

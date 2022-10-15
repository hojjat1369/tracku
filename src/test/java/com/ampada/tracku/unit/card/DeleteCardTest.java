package com.ampada.tracku.unit.card;


import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ampada.tracku.card.dto.DeleteCardRequest;
import com.ampada.tracku.card.dto.DeleteCardResponse;
import com.ampada.tracku.card.entity.Card;
import com.ampada.tracku.card.repository.CardRepository;
import com.ampada.tracku.card.service.CardServiceImpl;
import com.ampada.tracku.common.exception.DomainException;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
@Transactional
@ActiveProfiles("jenkins")
@RunWith(SpringJUnit4ClassRunner.class)
@Category(UnitTest.class)
public class DeleteCardTest {

	@InjectMocks
	private CardServiceImpl cardService;
	@Mock
	private CardRepository cardRepository;

	private DeleteCardRequest request;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {

		request = DeleteCardRequest.builder().id("10").build();
	}

	@Test
	public void nullId() throws DomainException {

		Mockito.when(cardRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));
		request.setId("-1");
		thrown.expect(DomainException.class);
		thrown.expectMessage("card not found!");

		cardService.delete(request);
	}

	@Test
	public void ok() throws DomainException {

		Mockito.when(cardRepository.findById(Mockito.any())).thenReturn(Optional.of(Card.builder().cardTitle("testCardTitle").build()));
		DeleteCardResponse response = cardService.delete(request);
		Assert.assertNotNull(response);
	}
}

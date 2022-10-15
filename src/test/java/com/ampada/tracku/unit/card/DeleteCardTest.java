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

import com.ampada.tracku.card.dto.DeleteCardRequest;
import com.ampada.tracku.card.dto.DeleteCardResponse;
import com.ampada.tracku.card.repository.CardRepository;
import com.ampada.tracku.card.service.CardServiceImpl;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.ErrorMessage;
import com.ampada.tracku.unit.common.TestUtil;

import ir.fanap.crm.utility.test.UnitTest;


@SpringBootTest
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
		request.setId(null);
		thrown.expect(DomainException.class);
		thrown.expectMessage(ErrorMessage.CARD_NOT_BLANK);

		cardService.delete(request);
	}

	@Test
	public void invalidId() throws DomainException {

		Mockito.when(cardRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));
		request.setId("invalidId");
		thrown.expect(DomainException.class);
		thrown.expectMessage(ErrorMessage.CARD_NOT_FOUND);

		cardService.delete(request);
	}

	@Test
	public void ok() throws DomainException {

		Mockito.when(cardRepository.findById(Mockito.any())).thenReturn(Optional.of(TestUtil.getTestCard()));
		DeleteCardResponse response = cardService.delete(request);
		Assert.assertNotNull(response);
	}
}

package com.ampada.tracku.card.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class UpdateCardResponse {

	private Long id;
	private String cardTitle;
}

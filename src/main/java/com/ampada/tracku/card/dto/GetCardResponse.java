package com.ampada.tracku.card.dto;


import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class GetCardResponse {

	private List<CardDetail> cards;
}

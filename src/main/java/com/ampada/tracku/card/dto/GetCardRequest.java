package com.ampada.tracku.card.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class GetCardRequest {

	private String cardTitle;
	private Long userId;
	private int begin;
	private int length;
}

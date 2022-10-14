package com.ampada.tracku.card.dto;


import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class UpdateCardRequest {

	@NotBlank(message = "card cannot be blank!")
	private Long id;
	private String cardTitle;
	private Long boardId;

	private List<Long> userId;
}

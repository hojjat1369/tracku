package com.ampada.tracku.card.dto;


import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CreateCardRequest {

	@NotBlank(message = "cardTitle cannot be blank!")
	private String cardTitle;

	@NotNull(message = "boardId cannot be null!")
	private String boardId;

	private List<Long> userId;
}

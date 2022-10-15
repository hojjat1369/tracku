package com.ampada.tracku.card.dto;


import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class DeleteCardRequest {

	@NotBlank(message = "card cannot be blank!")
	private String id;
}

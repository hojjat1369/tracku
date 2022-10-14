package com.ampada.tracku.board.dto;


import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class UpdateBoardRequest {

	@NotBlank(message = "board cannot be blank!")
	private Long id;
	@NotBlank(message = "boardName cannot be blank!")
	private String boardName;
}

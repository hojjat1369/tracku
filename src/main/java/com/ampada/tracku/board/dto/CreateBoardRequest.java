package com.ampada.tracku.board.dto;


import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CreateBoardRequest {

	@NotBlank(message = "boardName cannot be blank!")
	private String boardName;
}

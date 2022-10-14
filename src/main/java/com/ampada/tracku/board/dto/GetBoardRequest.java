package com.ampada.tracku.board.dto;


import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class GetBoardRequest {

	@NotNull(message = "board id cannot be null")
	private Long id;
}

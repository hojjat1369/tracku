package com.ampada.tracku.board.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class GetBoardResponse {

	private String boardName;

	private String id;
}

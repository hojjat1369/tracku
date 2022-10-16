package com.ampada.tracku.card.dto;


import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CardDetail {

	private String cardTitle;
	private String boardId;
	private List<String> userId;
}

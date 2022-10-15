package com.ampada.tracku.card.dto;


import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ampada.tracku.common.dto.CommonRequest;
import com.ampada.tracku.common.exception.DomainException;
import com.ampada.tracku.common.util.ErrorMessage;
import com.ampada.tracku.common.util.ObjectUtil;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CreateCardRequest extends CommonRequest {

	private static final long serialVersionUID = -6668493178162943297L;

	@NotBlank(message = ErrorMessage.CARD_TITLE_NOT_BLANK)
	private String cardTitle;

	@NotNull(message = ErrorMessage.BOARD_NOT_BLANK)
	private String boardId;

	private List<Long> userId;

	@Override
	public void validate() throws DomainException {

		ObjectUtil.notNull(cardTitle, ErrorMessage.CARD_TITLE_NOT_BLANK);
		ObjectUtil.notNull(boardId, ErrorMessage.BOARD_NOT_BLANK);
	}
}

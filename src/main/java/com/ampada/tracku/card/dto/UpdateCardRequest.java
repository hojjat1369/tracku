package com.ampada.tracku.card.dto;


import java.util.List;

import javax.validation.constraints.NotBlank;

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
public class UpdateCardRequest extends CommonRequest {

	private static final long serialVersionUID = -1729648181114784747L;

	@NotBlank(message = ErrorMessage.CARD_NOT_BLANK)
	private String id;
	private String cardTitle;
	private String boardId;

	private List<String> userId;

	@Override
	public void validate() throws DomainException {

		ObjectUtil.notNull(id, ErrorMessage.CARD_NOT_BLANK);
	}
}

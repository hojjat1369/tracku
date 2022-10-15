package com.ampada.tracku.card.dto;


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
public class DeleteCardRequest extends CommonRequest {

	private static final long serialVersionUID = 498702862332422942L;

	@NotBlank(message = ErrorMessage.CARD_NOT_BLANK)
	private String id;

	@Override
	public void validate() throws DomainException {

		ObjectUtil.notNull(id, ErrorMessage.CARD_NOT_BLANK);
	}
}

package com.ampada.tracku.board.dto;


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
public class DeleteBoardRequest extends CommonRequest {

	private static final long serialVersionUID = 7735463838090663631L;

	@NotBlank(message = ErrorMessage.BOARD_NOT_BLANK)
	private String id;

	@Override
	public void validate() throws DomainException {

		ObjectUtil.notNull(id, ErrorMessage.BOARD_NOT_BLANK);
	}
}

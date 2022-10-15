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
public class UpdateBoardRequest extends CommonRequest {

	private static final long serialVersionUID = -598727796988664653L;

	@NotBlank(message = ErrorMessage.BOARD_NOT_BLANK)
	private String id;
	private String boardName;

	@Override
	public void validate() throws DomainException {

		ObjectUtil.notNull(id, ErrorMessage.BOARD_NOT_BLANK);
	}
}

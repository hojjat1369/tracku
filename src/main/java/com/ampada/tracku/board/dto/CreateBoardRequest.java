package com.ampada.tracku.board.dto;


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
public class CreateBoardRequest extends CommonRequest {

	private static final long serialVersionUID = -7406990496116669285L;

	private String boardName;

	@Override
	public void validate() throws DomainException {

		ObjectUtil.notNull(boardName, ErrorMessage.BOARD_NAME_NOT_BLANK);
	}
}

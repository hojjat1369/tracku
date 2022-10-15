package com.ampada.tracku.common.dto;


import java.io.Serializable;

import com.ampada.tracku.common.exception.DomainException;


public class CommonRequest implements Serializable, Validator {

	private static final long serialVersionUID = 6174518727911577481L;

	@Override
	public void validate() throws DomainException {

		return;
	}

}

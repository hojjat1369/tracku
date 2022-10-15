package com.ampada.tracku.common.dto;


import com.ampada.tracku.common.exception.DomainException;


public interface Validator {

	public void validate() throws DomainException;
}

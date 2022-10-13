package com.ampada.tracku.common.util;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ampada.tracku.common.dto.ServiceErrorResponse;
import com.ampada.tracku.common.exception.DomainException;


@ControllerAdvice
@EnableWebMvc
public class ExceptionHandlingController {

	@ExceptionHandler(MissingRequestHeaderException.class)
	@ResponseBody
	public ResponseEntity<ServiceErrorResponse> missingRequestHeaderException(HttpServletRequest request, Exception e) {

		return ResponseEntity.badRequest().body(null);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ServiceErrorResponse exceptionException(HttpServletRequest request, Exception e) {

		return null;
	}

	@ExceptionHandler(DomainException.class)
	@ResponseBody
	public ServiceErrorResponse domainException(DomainException domainException, @ModelAttribute("mappingFEMsg") final Object mappingFEMsgObject) {

		return null;
	}

}

package com.accenture.exception;

import java.io.Serializable;

import com.accenture.util.enums.ErrorEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * General exception API
 * 
 * @author infrahector@hotmail.com
 * 
 * @see ApiExceptionHandlerAdvice
 */
@Getter
@Setter
public class ApiClientException extends ApiException implements Serializable{
	
	public ApiClientException(ErrorEnum error) {
		super(error);
	}
	
	private static final long  serialVersionUID= 1L;

}

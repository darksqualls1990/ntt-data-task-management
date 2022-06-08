package com.accenture.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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
@ResponseStatus( value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Error del API" )
public class ApiException  extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final ErrorEnum error;
	
	private final HttpServletRequest request;

	/**
	 * Constructor
	 * @param error
	 */
	public ApiException(ErrorEnum error) {
		super();
		this.error = error;
		this.request=null;
	}

	/**
	 * 
	 * @param error
	 * @param request
	 */
	public ApiException(ErrorEnum error, HttpServletRequest request) {
		super();
		this.error = error;
		this.request = request;
	}

	/**
	 * 
	 * @param error
	 * @param ex
	 */
	public ApiException(ErrorEnum error,Exception ex) {
		super(ex);
		this.error = error;
		this.request=null;
	}
	
	
	
	
}

package com.accenture.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.accenture.util.enums.ErrorEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * Validation exception API 
 * 
 * @author infrahector@hotmail.com
 *
 * @see ApiExceptionHandlerAdvice
 */
@Getter
@Setter
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Error de validacion de datos")
public class ApiValidationException extends RuntimeException implements Serializable{
	
	/**
	 * clave  serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * descripcion
	 */
	private String  description;
	
	/**
	 * error enumm
	 */
	private final ErrorEnum error= ErrorEnum.MSJ_INPUT;
	
	/**
	 * request
	 */
	private final HttpServletRequest request;

	/**
	 * constructor
	 */
	public ApiValidationException() {
		super();
		this.request= null;
	}

	/**
	 * 
	 * @param request
	 */
	public ApiValidationException(HttpServletRequest request) {
		super();
		this.request = request;
	}

	/**
	 * 
	 * @param description
	 */
	public ApiValidationException(String description) {
		this();
		this.description = description;
	}

}

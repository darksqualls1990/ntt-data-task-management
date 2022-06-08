package com.accenture.util.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Error enum
 * 
 * @author infrahector@hotmail.com
 */
@Getter
public enum ErrorEnum {
	
	MSJ_INPUT(ErrorTypeEnum.MSJ,
			"001",
			"Error en mensaje de entrada",
			HttpStatus.BAD_REQUEST),
	COM_ERROR(ErrorTypeEnum.COM, 
			"002", 
			"Error interno del servidor", 
			HttpStatus.INTERNAL_SERVER_ERROR),
	MSJ_NOT_DATA(ErrorTypeEnum.COM,
			"003",
			"La Consulta no devuelve datos",
			HttpStatus.NOT_FOUND);
	
	private ErrorTypeEnum type;
	private String condition;
	private String description;
	private HttpStatus httpCode;
	private ErrorEnum(ErrorTypeEnum type, String condition, String description, HttpStatus httpCode) {
		this.type = type;
		this.condition = condition;
		this.description = description;
		this.httpCode = httpCode;
	}	

}

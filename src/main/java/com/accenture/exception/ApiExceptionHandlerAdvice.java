package com.accenture.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.exception.response.ApiError;
import com.accenture.exception.response.ApiErrorResponse;
import com.accenture.util.enums.ErrorEnum;

/**
 * Class that catches an ApiException and handle it to in order to send a clean
 * response to the the client.
 * 
 * @author infrahector@hotmail.com
 * 
 */
@ControllerAdvice
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
public class ApiExceptionHandlerAdvice{

	
	/**
	 * Method that generates a single error response
	 * 
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ ApiException.class })
	public ResponseEntity<List<ApiErrorResponse>> handleApiException(ApiException ex, HttpServletRequest request) {

		List<ApiErrorResponse> listResponse = new ArrayList<>();
		ApiErrorResponse errorResponse = new ApiErrorResponse();

		if (ex == null) {
			ex = new ApiException(ErrorEnum.COM_ERROR);
		}
		
		ApiError apiError = ApiError.builder().errorCode(String.valueOf(ex.getError().getHttpCode().value()))
				.code(ex.getError().getCondition()).errorType(ex.getError().getType().name())
				.description(ex.getError().getDescription()).build();
		
		errorResponse.setError(apiError);
		listResponse.add(errorResponse);

		return new ResponseEntity<>(listResponse, ex.getError().getHttpCode());
	}
	

	/**
	 * Method that generates a list of error validation
	 * 
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ ApiValidationException.class })
	public ResponseEntity<List<ApiErrorResponse>> handleApiException(ApiValidationException ex) {

		List<ApiErrorResponse> listResponse = new ArrayList<>();

			ApiErrorResponse errorResponse = new ApiErrorResponse();
			ApiError apiError = ApiError.builder().errorCode(String.valueOf(ErrorEnum.MSJ_INPUT.getHttpCode().value()))
					.code(ErrorEnum.MSJ_INPUT.getCondition()).errorType(ErrorEnum.MSJ_INPUT.getType().name())
					.description(ErrorEnum.MSJ_INPUT.getDescription())
					.detail(ex.getDescription()).build();
			errorResponse.setError(apiError);
			listResponse.add(errorResponse);

		return new ResponseEntity<>(listResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}

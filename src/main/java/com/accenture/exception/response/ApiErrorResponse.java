package com.accenture.exception.response;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorResponse implements Serializable {
	
	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Error
	 */
	private ApiError error;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	/***
	 * Returns the representation of the object in JSON format
	 * @return string
	 */
	public String toStringJson() {
		return new Gson().toJson(this);
	}	

}

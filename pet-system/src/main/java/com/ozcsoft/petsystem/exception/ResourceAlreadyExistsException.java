package com.ozcsoft.petsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceAlreadyExistsException extends RuntimeException{

	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	public ResourceAlreadyExistsException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s already exists with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}

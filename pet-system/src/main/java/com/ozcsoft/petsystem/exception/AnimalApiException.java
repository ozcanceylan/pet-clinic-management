package com.ozcsoft.petsystem.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
@Getter
public class AnimalApiException extends RuntimeException{
	
	HttpStatus status;
	String message;
	public AnimalApiException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public AnimalApiException(String message, HttpStatus status, String message1) {
		super(message);
		this.status = status;
		this.message = message1;
	}
	
	
}

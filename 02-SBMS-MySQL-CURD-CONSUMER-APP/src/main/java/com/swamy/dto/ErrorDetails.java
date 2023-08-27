package com.swamy.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorDetails {

	private String message;
	private HttpStatus status;
	private Integer statusCode;
	private String path;
}

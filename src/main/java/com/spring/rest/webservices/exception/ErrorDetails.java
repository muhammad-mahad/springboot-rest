package com.spring.rest.webservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timestamp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public String getDetails() {
		return details;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}
}

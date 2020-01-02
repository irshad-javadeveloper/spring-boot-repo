package com.restful.exception;

import java.util.Date;

public class ExceptionResponse {

	// exception message
	private String message;
	// exception details
	private String details;
	// exception timestamp
	private Date timestamp;

	public ExceptionResponse(String message, String details, Date timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}
	
	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}

package com.raquelheredia.api.netflix.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

public class NotFoundException extends NetflixExceptions {
	
	private static final long serialVersionUID = -6378472149201593916L;

	public NotFoundException(final String message) {
		super(HttpStatus.NOT_FOUND.value(), message);
	}

	public NotFoundException(final String message, final ErrorDto data) {
		super(HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}

}

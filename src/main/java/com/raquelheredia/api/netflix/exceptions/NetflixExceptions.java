package com.raquelheredia.api.netflix.exceptions;

import java.util.ArrayList;
import java.util.List;


public class NetflixExceptions extends Exception {
	
	private static final long serialVersionUID = 6419931754960024017L;

	private final int code;

	private final List<ErrorDto> errorList = new ArrayList<>();

	public NetflixExceptions(final int code, final String message) {
		super(message);
		this.code = code;
	}

	public NetflixExceptions(final int code, final String message, final List<ErrorDto> errorList) {
		super(message);
		this.code = code;
		this.errorList.addAll(errorList);
	}

	public int getCode() {
		return this.code;
	}

	public List<ErrorDto> getErrorList() {
		return errorList;
	}

}

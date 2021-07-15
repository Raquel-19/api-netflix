package com.raquelheredia.api.netflix.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.raquelheredia.api.netflix.responses.NetflixResponse;
import com.raquelheredia.api.netflix.util.ExceptionConstants;

@ControllerAdvice
@SuppressWarnings({ "rawtypes", "unchecked" })
public class NetflixRestExceptionHandler {

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public NetflixResponse unhandledErrors(HttpServletRequest req, Exception ex) {
		return new NetflixResponse(ExceptionConstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
				ex.getMessage());
	}

	@ExceptionHandler({ NetflixExceptions.class })
	@ResponseBody
	public NetflixResponse handleLmException(final HttpServletRequest request, final HttpServletResponse response,
			final NetflixExceptions ex) {
		response.setStatus(ex.getCode());
		return new NetflixResponse(ExceptionConstants.ERROR, String.valueOf(ex.getCode()), ex.getMessage(),
				ex.getErrorList());
	}

}

package com.test.product.exceptions;

import java.net.SocketTimeoutException;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(SocketTimeoutException.class)
	public ResponseEntity<Object> handleSocketTimeoutException(SocketTimeoutException e, WebRequest request, HttpServletRequest httpRequest){
		ErrorDetail errorDetail = ErrorDetail.builder()
				.timestamp(Instant.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.error(e.toString())
				.path(httpRequest.getRequestURI())
				.build();
		
		return handleExceptionInternal(e, errorDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}

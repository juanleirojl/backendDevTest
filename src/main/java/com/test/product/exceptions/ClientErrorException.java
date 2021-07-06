package com.test.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ClientErrorException(String string) {
		super(string);
	}


}

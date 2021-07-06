package com.test.product.config;

import org.springframework.http.HttpStatus;

import com.test.product.exceptions.ClientErrorException;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class FeignClientErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		
		Exception exception = defaultErrorDecoder.decode(methodKey, response);

        if(exception instanceof RetryableException){
            return exception;
        }
        
        if (HttpStatus.valueOf(response.status()).is5xxServerError()){
        	return new RetryableException(response.status(), response.reason(), response.request().httpMethod(), null, response.request());
        } else {
        	return new ClientErrorException("Client Error Status: " + response.status() + " Reason: "+ response.reason()+ " URL:" + response.request().url());
        }
	}

}

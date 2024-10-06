package com.ds.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ds.payload.response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceExceptioin(ProductServiceException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}

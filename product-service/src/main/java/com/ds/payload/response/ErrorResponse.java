package com.ds.payload.response;

public class ErrorResponse {

	private String errorMessage;
	
	private String errorCode;
	
	public ErrorResponse() {
		
	}
	
	public ErrorResponse(String errorMessage, String errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}

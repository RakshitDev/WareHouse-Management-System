package com.jsp.whms.util;

public class ErrorStructure<T> {
	
	private int status;
	private String message;
	private String cause;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public String getCause() {
		return cause;
	}
	public ErrorStructure<T> setStatus(int status) {
		this.status = status;
		return this;
	}
	public ErrorStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	public ErrorStructure<T> setCause(String cause) {
		this.cause = cause;
		return this;
	}
	
	
	
	

}

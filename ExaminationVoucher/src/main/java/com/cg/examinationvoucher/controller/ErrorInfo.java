package com.cg.examinationvoucher.controller;

public class ErrorInfo {
	
	private int statusCode;
	private String status;
	private String errors;
	private String path;
	
	//getters & setters
	
	public String getPath() {
		return path;
	} 
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getErrors() {
		return errors;
	}
	
	public void setErrors(String errors) {
		this.errors = errors;
	}
	
	//Parameterized constructor
	
	public ErrorInfo(int statusCode, String status, String errors, String path) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.errors = errors;
		this.path = path;
	}
	
	//Default Constructor
	
	public ErrorInfo() {
		super();
	}
	
	//Overriding toString method
	
	@Override
	public String toString() {
		return "ErrorInfo [statusCode=" + statusCode + ", status=" + status + ", errors=" + errors + ", path=" + path
				+ "]";
	}
	
}

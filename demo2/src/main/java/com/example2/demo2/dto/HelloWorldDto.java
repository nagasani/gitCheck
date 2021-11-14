package com.example2.demo2.dto;

public class HelloWorldDto {
	
	public HelloWorldDto() {
		
	}
	
	public HelloWorldDto(String message) {
		this.message = message;
	}
	
	private String message;
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}

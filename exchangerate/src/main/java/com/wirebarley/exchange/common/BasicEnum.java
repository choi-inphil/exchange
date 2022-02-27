package com.wirebarley.exchange.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BasicEnum {

	OK(200,"OK" ,"OK"),
	SUCCESS(201,"SUCCESS", "succeed");

	private int status;
	private String Code;
	private String message;
	
}

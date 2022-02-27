package com.wirebarley.exchange.exception;


import org.springframework.http.ResponseEntity;

import com.wirebarley.exchange.bean.BaseResult;

public class ExchangeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	protected String message = null;
	private ResponseEntity<BaseResult> res;
	
	private int errorCode;
	private String desc;
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ResponseEntity<BaseResult> getRes() {
		return res;
	}

	public void setRes(ResponseEntity<BaseResult> res) {
		this.res = res;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ExchangeException(ResponseEntity<BaseResult> res) {
		this.res=res;
	}
	
	public ExchangeException(String message) {
		this.message = message;
	}
	
	public ExchangeException(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ExchangeException setException(int errorCode, String message) {
		return new ExchangeException(errorCode, message);
	}
	
	public static ExchangeException setException(String message) {
		return new ExchangeException(message);
	}
}

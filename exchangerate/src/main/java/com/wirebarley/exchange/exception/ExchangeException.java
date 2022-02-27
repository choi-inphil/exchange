package com.wirebarley.exchange.exception;

import com.wirebarley.exchange.common.ErrorCode;

import lombok.Getter;

@Getter
public class ExchangeException extends RuntimeException {

	/**
	 * ExchangeException
	 */
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;

	public ExchangeException(String message, ErrorCode errorCode) {
		super(message);
		//this.message = message;
		this.errorCode = errorCode;
	}
}

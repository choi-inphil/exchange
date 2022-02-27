package com.wirebarley.exchange.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
	NOT_FOUND(404,"COMMON-ERR-404","PAGE NOT FOUND"),
	INPUT_ERORR(400, "INPUT-ERR-400","INPUT ERROR"),
	RATE_ERROR(401, "RATE-ERR-401","RATE ERROR"),
	RATE_API_ERROR(402, "RATE-API-ERROR-401","RATE API ERROR"),
	INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR-500" ,"INTER SERVER ERROR"); 
	;
	private int status;
	private String errorCode;
	private String message;
} 

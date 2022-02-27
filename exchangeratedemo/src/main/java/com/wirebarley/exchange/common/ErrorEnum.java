package com.wirebarley.exchange.common;

public enum ErrorEnum {

	OK(200, "OK"),
	SUCCESS(201, "succeed"),

	FAIL(400, "잘모 입력되 값 입니다."),
	RATE_ERORR(401, "환율 정보에 오류가 발생했습니다."),
	NONE(500, "서버에 문제가 발생했습니다."); 
	
	private int code;
	private String desc;
	
	ErrorEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}

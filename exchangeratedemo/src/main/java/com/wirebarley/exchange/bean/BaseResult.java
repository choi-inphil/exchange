package com.wirebarley.exchange.bean;

import com.wirebarley.exchange.common.ErrorEnum;

public class BaseResult {
	
	/**
	 * 성공여부 , 성공 = true, 실패 = false
	 */
	private boolean result = true;
	
	private String resultStatus = ErrorEnum.SUCCESS.getDesc();
    
	/**
	 * 에러 코드
	 */
	private int resultCode = ErrorEnum.OK.getCode();
	
	/**
	 * 에러 코드 성명
	 */
    private String resultMessage =  ErrorEnum.OK.getDesc();
    
	/**
	 * 결과 Data
	 */
    private Object resultData = null;
    
	/**
	 * 에러 추가 정보 
	 */
	private String errorMsg;
    
	/*
	 * 블록체인 value
	 */
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isResult() {
		return result;
	}
	
	public void setResult(boolean result) {
		this.result = result;
		if(result) {
			this.resultCode = ErrorEnum.SUCCESS.getCode();
			this.resultMessage = ErrorEnum.SUCCESS.getDesc();
		}
	}
	
	public void setErrorCode(ErrorEnum errorEnum) {
		this.result = false;
		this.resultCode = errorEnum.getCode();
		this.errorMsg = errorEnum.getDesc();
	}

	public void setErrorCode(int errorCode, String errMessge) {
		this.result = false;
		this.resultCode = errorCode;
		this.resultMessage = errMessge;
	}
	
    public String getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}
	
	public int getResultCode() {
        return resultCode;
    }

    public BaseResult setResultCode(int resultCode) {
        this.resultCode = resultCode;
        return this;
    }
    public BaseResult setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
        return this;
    }

    public BaseResult setResultData(Object resultData) {
        this.resultData = resultData;
        return this;
    }
    public String getResultMessage() {
        return resultMessage;
    }

    public Object getResultData() {
        return resultData;
    }
    
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


}
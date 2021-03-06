package com.wirebarley.exchange.bean;

import com.wirebarley.exchange.common.BasicEnum;

public class BaseResult {
	
	/**
	 * 성공여부 , 성공 = true, 실패 = false
	 */
	private boolean result = true;
	
	private int resultStatus = BasicEnum.SUCCESS.getStatus();
    
	/**
	 * 에러 코드
	 */
	private String resultCode = BasicEnum.OK.getCode();
	
	/**
	 * 에러 코드 성명
	 */
    private String resultMessage =  BasicEnum.OK.getMessage();
    
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
			this.resultCode = BasicEnum.SUCCESS.getCode();
			this.resultMessage = BasicEnum.SUCCESS.getMessage();
		}
	}
	
	public void setErrorCode(BasicEnum errorEnum) {
		this.result = false;
		this.resultCode = errorEnum.getCode();
		this.errorMsg = errorEnum.getMessage();
	}

	public void setErrorCode(String errorCode, String errMessge) {
		this.result = false;
		this.resultCode = errorCode;
		this.resultMessage = errMessge;
	}
	
    public int getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
	
	public String getResultCode() {
        return resultCode;
    }

    public BaseResult setResultCode(String resultCode) {
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
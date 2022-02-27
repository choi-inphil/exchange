package com.wirebarley.exchange.util;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;

import com.wirebarley.exchange.common.Constants;
import com.wirebarley.exchange.model.ExRsultDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtiltLib {
    @Value("${currencylayer.cycleTime}")
    private int cycleTime;
	/**
	 * decimal 포멧
	 * @param number
	 * @return
	 */
	public String format(Number number) {
		return new DecimalFormat(Constants.FORMAT_DEC).format(number);
	}
	
    /**
     * 현재 시간과 API를 통해 호출한 timestamp의 차이
     * application.properties에 저장해 놓은 주기 시간보다 크면 API를 호출하도록 하는 메소드
     * @return
     */
    public boolean ischeck(ExRsultDTO exRsultDTO){
        if(exRsultDTO == null){
            return true;
        }
        long currentTime = TimeUnit.MICROSECONDS.toMinutes(System.currentTimeMillis());
        log.debug("cycleTime : " + cycleTime);
        log.debug("SystemTime : " + System.currentTimeMillis());
        return currentTime - exRsultDTO.getTimestamp() > cycleTime;
    }

}

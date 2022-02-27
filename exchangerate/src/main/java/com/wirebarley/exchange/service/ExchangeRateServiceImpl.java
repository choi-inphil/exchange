package com.wirebarley.exchange.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wirebarley.exchange.common.ErrorCode;
import com.wirebarley.exchange.exception.ExchangeException;
import com.wirebarley.exchange.model.ExRsultDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 환율 국가별
 * @author aero
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {
    @Value("${currencylayer.source}")
    private String sendCountry;

    private final ExchangeAPIService exchangeAPIService;

    /**
     * 송금액 국가별 메소드
     * @param sendamount
     * @return
     */
    @Override
    public Double getExchangeRate(String receiveCountry) {
        ExRsultDTO exRsultDTO = exchangeAPIService.getExRsultDTO();
        String sendReceiveCountry = sendCountry + receiveCountry;
        log.debug("sendReceiveCountry : " + sendReceiveCountry);
        Double convertedCurrency = exRsultDTO.getQuotes().get(sendReceiveCountry);
        if (convertedCurrency <= 0) {
        	throw new ExchangeException("환율 정보 조회 중 오류가 발생했습니다.",ErrorCode.RATE_API_ERROR);
        }
        log.debug("convertedCurrency : " + convertedCurrency);
        return convertedCurrency;
    }
}

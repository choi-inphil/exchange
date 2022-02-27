package com.wirebarley.exchange.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wirebarley.exchange.model.ExRsultDTO;
import com.wirebarley.exchange.service.ExchangeAPIService;
import com.wirebarley.exchange.service.ExchangeRateService;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeRateServiceImplTest {

    @Autowired
    ExchangeAPIService exchangeAPIService;
    @Autowired
    ExchangeRateService exchangeRateService;

    @Test
    /*
     * 송금액 잘 가져왔는지 확인
     */
    public void isSendExchangeAPICallCheck() {
        ExRsultDTO exRsultDTO = exchangeAPIService.getExRsultDTO();
        Double exchangeFromDirectAPI = exRsultDTO.getQuotes().get("USDPHP");
        Double exchangeFromConverterService = exchangeRateService.getExchangeRate("PHP");
        Assert.assertEquals(exchangeFromDirectAPI, exchangeFromConverterService);
    }
}
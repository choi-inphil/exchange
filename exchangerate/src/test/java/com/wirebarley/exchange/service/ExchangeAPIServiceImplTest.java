package com.wirebarley.exchange.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wirebarley.exchange.model.ExRsultDTO;
import com.wirebarley.exchange.service.ExchangeAPIServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeAPIServiceImplTest {
    @Autowired
    private ExchangeAPIServiceImpl exchangeAPIServiceImpl;

    @Test
    /**
     * Exchange API로 환율정보 호출
     */
    public void isExchangeLayerAPI(){
        ExRsultDTO exRsultDTO = exchangeAPIServiceImpl.getExRsultDTO();
        Assert.assertNotNull(exRsultDTO);
    }
}
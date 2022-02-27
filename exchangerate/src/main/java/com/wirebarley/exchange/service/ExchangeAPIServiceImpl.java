package com.wirebarley.exchange.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wirebarley.exchange.model.ExRsultDTO;
import com.wirebarley.exchange.util.UtiltLib;

import lombok.extern.slf4j.Slf4j;

/**
 * 환율  currencylayer 서비스 
 * @author ipchoi
 *
 */
@Slf4j
@Service
public class ExchangeAPIServiceImpl implements ExchangeAPIService {
    @Value("${currencylayer.accessKey}")
    private String accessKey;
    @Value("${currencylayer.url}")
    private String url;
    @Value("${currencylayer.source}")
    private String source;
    @Value("${currencylayer.currencies}")
    private String currencies;
    @Value("${currencylayer.cycleTime}")
    private int cycleTime;

    private RestTemplate restTemplate;
    private ExRsultDTO exRsultDTO;
    
    private UtiltLib utillib = new UtiltLib();

    public ExchangeAPIServiceImpl(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }

    /**
     * 환율 호출 API
     * @param 
     * @return
     */
    @Override
    public ExRsultDTO getExRsultDTO() {
        if(utillib.ischeck(exRsultDTO)){
    	exRsultDTO = restTemplate.getForObject(
                    url + "?access_key=" + accessKey
                    + "&source=" + source
                    + "&currencies=" + currencies,
                    ExRsultDTO.class);
            log.debug("url : " + url);
            log.debug("currency : " + exRsultDTO);
        }
        return exRsultDTO;
    }
    
}

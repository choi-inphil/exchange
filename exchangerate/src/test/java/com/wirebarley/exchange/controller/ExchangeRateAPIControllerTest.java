package com.wirebarley.exchange.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wirebarley.exchange.service.ExchangeRateService;
import com.wirebarley.exchange.util.UtiltLib;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeRateAPIControllerTest {
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private ExchangeRateAPIController exchangeRateAPIController;

    @MockBean
    private ExchangeRateService exchangeRateService;
    
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getExchangeRate() throws Exception {
        String uri = "/api/exchangerates?receiveCountry=KRW";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }
    
}
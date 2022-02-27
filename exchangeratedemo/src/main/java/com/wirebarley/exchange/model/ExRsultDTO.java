package com.wirebarley.exchange.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 환율 계산기 result bean
 * @author ipchoi
 *
 */
@Getter
@Setter
public class ExRsultDTO {
    private boolean success;
    private int timestamp;
    private String source;
    private Map<String, Double> quotes;
    private Map<String, String> error;
}

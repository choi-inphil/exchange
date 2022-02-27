package com.wirebarley.exchange.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 환율계산기 input bean
 * @author ipchoi
 *
 */
@Getter
@Setter
public class ExInputDTO {
    @NotBlank
    private String receiveCountry;

    @Min(0)
    @Max(10000)
    private double sendAmount;
}

package com.wirebarley.exchange.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wirebarley.exchange.bean.BaseResult;
import com.wirebarley.exchange.common.ErrorEnum;
import com.wirebarley.exchange.exception.ExchangeException;
import com.wirebarley.exchange.model.ExInputDTO;
import com.wirebarley.exchange.service.ExchangeRateService;
import com.wirebarley.exchange.util.UtiltLib;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * main controller
 * 
 * @author ipchoi
 *
 */
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExchangeRateAPIController {

	private final ExchangeRateService exchangeRateService;
	private final UtiltLib utiltLib = new UtiltLib();

	/**
	 * 국가에 따른 환율을 가져오는 메소드
	 * 
	 * @param receiveCountry
	 * @return
	 */
	@GetMapping("/exchangerates")
	public ResponseEntity<BaseResult> getExchangeRate(@RequestParam(name = "receiveCountry") String receiveCountry) throws ExchangeException {
		BaseResult result = new BaseResult();
		try {
			Double exchangeRate = exchangeRateService.getExchangeRate(receiveCountry);
			// 환율 정보 validation
			result = this.rateCheck(result,exchangeRate);
			result.setResultData(utiltLib.format(exchangeRate));
		} catch (Exception e) {
			throw ExchangeException.setException(ErrorEnum.NONE.getCode(), ErrorEnum.NONE.getDesc());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/**
	 * 송금액을 계산하는 메소드
	 * 
	 * @param sendamount
	 * @return
	 * @throws ExchangeException
	 */
	@PostMapping("/sendamount")
	public ResponseEntity<BaseResult> getSendAmount(@Valid @RequestBody ExInputDTO exInputDTO) throws ExchangeException {
		BaseResult result = new BaseResult();
		try {
			Double exchangeRate = exchangeRateService.getExchangeRate(exInputDTO.getReceiveCountry());
			// 환율 정보 validation
			result = this.rateCheck(result,exchangeRate);
			Double sendAmount = (exchangeRate * exInputDTO.getSendAmount());
			String formatSendAmount = utiltLib.format(sendAmount);
			result.setResultData(formatSendAmount);
		} catch (Exception e) {
			throw ExchangeException.setException(ErrorEnum.NONE.getCode(), ErrorEnum.NONE.getDesc());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	/**
	 * 화율 정보 체크
	 * @param result
	 * @param exchangeRate
	 * @return
	 */
	private BaseResult rateCheck(BaseResult result, Double exchangeRate) {
		if (exchangeRate <= 0) {
			result.setResult(false);
			result.setResultMessage("환율 정보 오류가 발생 했습니다.");
		}
		return result;
	}

}

package com.fenyun.ws.manager;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.StringUtils;

import static org.junit.Assert.assertTrue;

public class Test5 extends BaseTest{

	@ParameterizedTest
	@ValueSource(strings = { "s", "", "" })
	public void palindromes(String candidate) {
		assertTrue("string is not null",StringUtils.isEmpty(candidate));
	}

	@RepeatedTest(10)
	public  void ps(){
		System.out.println("11");
	}

}

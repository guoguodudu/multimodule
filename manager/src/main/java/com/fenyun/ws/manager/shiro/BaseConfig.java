package com.fenyun.ws.manager.shiro;

import com.fenyun.common.base.base.response.BaseResponseUtilR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

	private  final Logger logger = LoggerFactory.getLogger(BaseConfig.class);

	@Bean("")
	public BaseResponseUtilR get(){
		return new BaseResponseUtilR();
	}
}

package com.fenyun.common.base.base.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static com.fenyun.common.base.base.enums.EmErrorMsg.FAIL;
import static com.fenyun.common.base.base.enums.EmErrorMsg.SUCCESS;

/**
 * @author dupihua
 */

@Slf4j
@Data
@PropertySource(value = "classpath:person.properties")
public class BaseResponseUtilR {

    @Value("${person.url}")
    private  String url;

    public static <T extends Serializable> BaseResponse resultSuccesssTest(T t) {
        return new BaseResponse(1, SUCCESS.getIndex(), SUCCESS.getName(), "");
    }

    public static <T extends Serializable> BaseResponse resultSuccesss(T t) {
        return new BaseResponse(1, SUCCESS.getIndex(), SUCCESS.getName(), t);
    }

    public static <T extends Serializable> BaseResponse resultSuccesss(Object t) {
        return new BaseResponse(1, SUCCESS.getIndex(), SUCCESS.getName(), null);
    }

    public static <T extends Serializable> BaseResponse resultFail(T t) {
        return new BaseResponse(0, FAIL.getIndex(), FAIL.getName(), t);
    }


}

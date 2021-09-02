package com.fenyun.ws.manager.shiro;

import com.fenyun.common.base.base.response.BaseResponse;
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

@Configuration
@PropertySource(value = "classpath:person.properties")
@ConfigurationProperties(prefix = "person")
public class BaseResponseUtil {

    public  String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}

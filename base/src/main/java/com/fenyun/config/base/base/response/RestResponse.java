package com.fenyun.config.base.base.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class RestResponse implements Serializable {
    private Integer result;
    private Integer retCode;
    private String retMsg;
    private Object retObj;
    private LocalDateTime retDateTime;
}

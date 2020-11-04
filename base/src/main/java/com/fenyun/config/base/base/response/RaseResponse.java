package com.fenyun.config.base.base.response;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author mapper
 */

public class RaseResponse<T> implements Serializable {
    private Integer result;
    private Integer retCode;
    private String retMsg;
    private T t;
    private LocalDateTime retDateTime = LocalDateTime.now();


    public RaseResponse(Integer result, Integer retCode, String retMsg, T t) {
        this.result = result;
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.t = t;
    }


    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

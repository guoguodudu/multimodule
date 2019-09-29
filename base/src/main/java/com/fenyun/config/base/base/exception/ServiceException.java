package com.fenyun.config.base.base.exception;

import com.fenyun.config.base.base.enums.EmErrorMsg;
import lombok.Data;

@Data
public class ServiceException extends RuntimeException{

    private Integer code;
    private String msg;
    private Object object;

    public ServiceException(EmErrorMsg eErrorMsg) {
        this.code = eErrorMsg.getIndex();
        this.msg = eErrorMsg.getName();
        this.object = null;
    }

    public ServiceException(EmErrorMsg eErrorMsg, Object object) {
        this.code = eErrorMsg.getIndex();
        this.msg = eErrorMsg.getName();
        this.object = object;
    }

    public ServiceException(Integer code,String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }


}

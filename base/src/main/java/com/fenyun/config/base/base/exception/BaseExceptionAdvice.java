package com.fenyun.config.base.base.exception;

import com.fenyun.config.base.base.enums.EmErrorMsg;
import com.fenyun.config.base.base.response.BaseController;
import com.fenyun.config.base.base.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mapper
 */
@Slf4j
public abstract class BaseExceptionAdvice extends BaseController {

    @ExceptionHandler({ServiceException.class})
    public RestResponse handleServiceException(ServiceException e) {
        log.info("method=handleServiceException,msg=【{}】",e.getMsg());
        return responseService(e.getCode(), e.getMsg(), e.getObject());
    }
    @ExceptionHandler({DataIntegrityViolationException.class})
    public RestResponse handleDataBaseException(DataIntegrityViolationException e) {
        log.info("method=handleDataBaseException", e);
        return this.failResponse(EmErrorMsg.FAILDATABASE);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public RestResponse handleIllegalArgumentException(Exception e) {
        log.info("method=handleIllegalArgumentException,msg=【{}】",e.getMessage());
        return failResponse(EmErrorMsg.FAILPARAM,e.getMessage());
    }


    @ExceptionHandler({Exception.class})
    public RestResponse handleException(Exception e) {
        log.error("method=handleException", e);
        return failResponse(EmErrorMsg.FAIL);
    }

}

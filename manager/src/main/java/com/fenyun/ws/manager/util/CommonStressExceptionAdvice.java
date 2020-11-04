package com.fenyun.ws.manager.util;

import com.fenyun.config.base.base.exception.BaseExceptionAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Repository
@RestControllerAdvice
public class CommonStressExceptionAdvice extends BaseExceptionAdvice {


   /* @ExceptionHandler(LockedAccountException.class)
    public RaseResponse handleLockedAccountException(LockedAccountException e) {
        return failResponse(EmErrorMsg.FAILNOTLOGINNAMELOCK);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public RaseResponse handleIncorrectCredentialsException(IncorrectCredentialsException e) {
        return failResponse(EmErrorMsg.FAILLOGIN);
    }

    @ExceptionHandler(UnknownAccountException.class)
    public RaseResponse handleUnknownAccountException(UnknownAccountException e) {
        return failResponse(EmErrorMsg.FAILLOGINNAMENOTEXEIT);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public RaseResponse handleUnauthenServiceException(UnauthenticatedException e) {
        return failResponse(EmErrorMsg.FAILNOTLOGIN);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public RaseResponse handleUnauthenServiceException(UnauthorizedException e) {
        return failResponse(EmErrorMsg.FAILACCESS);
    }*/

}

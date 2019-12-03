package com.fenyun.config.base.base.response;


import com.fenyun.config.base.base.enums.EmErrorMsg;

import java.time.LocalDateTime;

public abstract class BaseController {

    protected RestResponse successResponse() {
        RestResponse restResponse = new RestResponse();
        restResponse.setResult(EmErrorMsg.SUCCESS.getIndex());
        restResponse.setRetCode(EmErrorMsg.SUCCESS.getIndex());
        restResponse.setRetMsg(EmErrorMsg.SUCCESS.getName());
        restResponse.setRetDateTime(LocalDateTime.now());
        return restResponse;
    }

    protected RestResponse successResponse(Object obj) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResult(EmErrorMsg.SUCCESS.getIndex());
        restResponse.setRetCode(EmErrorMsg.SUCCESS.getIndex());
        restResponse.setRetMsg(EmErrorMsg.SUCCESS.getName());
        restResponse.setRetDateTime(LocalDateTime.now());
        restResponse.setRetObj(obj);
        return restResponse;
    }

    protected RestResponse selectResponse(Object obj) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResult(EmErrorMsg.SUCCESS.getIndex());
        restResponse.setRetCode(EmErrorMsg.SUCCESSSLECT.getIndex());
        restResponse.setRetMsg(EmErrorMsg.SUCCESSSLECT.getName());
        restResponse.setRetDateTime(LocalDateTime.now());
        restResponse.setRetObj(obj);
        return restResponse;
    }

    protected RestResponse updateResponse(int result) {
        if (result > 0) {
            RestResponse restResponse = new RestResponse();
            restResponse.setResult(EmErrorMsg.SUCCESS.getIndex());
            restResponse.setRetCode(EmErrorMsg.SUCCESSUPDATE.getIndex());
            restResponse.setRetMsg(EmErrorMsg.SUCCESSUPDATE.getName());
            restResponse.setRetDateTime(LocalDateTime.now());
            restResponse.setRetObj(null);
            return restResponse;
        } else {
            RestResponse restResponse = new RestResponse();
            restResponse.setResult(EmErrorMsg.FAIL.getIndex());
            restResponse.setRetCode(EmErrorMsg.FAILUPDATE.getIndex());
            restResponse.setRetMsg(EmErrorMsg.FAILUPDATE.getName());
            restResponse.setRetDateTime(LocalDateTime.now());
            restResponse.setRetObj(null);
            return restResponse;
        }
    }

    protected RestResponse insertResponse(int result) {
        if (result > 0) {
            RestResponse restResponse = new RestResponse();
            restResponse.setResult(EmErrorMsg.SUCCESS.getIndex());
            restResponse.setRetCode(EmErrorMsg.SUCCESSINSERT.getIndex());
            restResponse.setRetMsg(EmErrorMsg.SUCCESSINSERT.getName());
            restResponse.setRetDateTime(LocalDateTime.now());
            restResponse.setRetObj(null);
            return restResponse;
        } else {
            RestResponse restResponse = new RestResponse();
            restResponse.setResult(EmErrorMsg.FAIL.getIndex());
            restResponse.setRetCode(EmErrorMsg.FAILINSERT.getIndex());
            restResponse.setRetMsg(EmErrorMsg.FAILINSERT.getName());
            restResponse.setRetDateTime(LocalDateTime.now());
            restResponse.setRetObj(null);
            return restResponse;
        }
    }

    protected RestResponse deleteResponse(int result) {
        if (result > 0) {
            RestResponse restResponse = new RestResponse();
            restResponse.setResult(EmErrorMsg.SUCCESS.getIndex());
            restResponse.setRetCode(EmErrorMsg.SUCCESSDELETE.getIndex());
            restResponse.setRetMsg(EmErrorMsg.SUCCESSDELETE.getName());
            restResponse.setRetDateTime(LocalDateTime.now());
            restResponse.setRetObj(null);
            return restResponse;
        } else {
            RestResponse restResponse = new RestResponse();
            restResponse.setResult(EmErrorMsg.FAIL.getIndex());
            restResponse.setRetCode(EmErrorMsg.FAILDELETE.getIndex());
            restResponse.setRetMsg(EmErrorMsg.FAILDELETE.getName());
            restResponse.setRetDateTime(LocalDateTime.now());
            restResponse.setRetObj(null);
            return restResponse;
        }
    }


    protected RestResponse failResponse(EmErrorMsg eErrorMsg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResult(EmErrorMsg.FAIL.getIndex());
        restResponse.setRetCode(eErrorMsg.getIndex());
        restResponse.setRetMsg(eErrorMsg.getName());
        restResponse.setRetDateTime(LocalDateTime.now());
        restResponse.setRetObj(null);
        return restResponse;
    }

    protected RestResponse failResponse(EmErrorMsg eErrorMsg, Object obj) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResult(EmErrorMsg.FAIL.getIndex());
        restResponse.setRetCode(eErrorMsg.getIndex());
        restResponse.setRetMsg(eErrorMsg.getName());
        restResponse.setRetDateTime(LocalDateTime.now());
        restResponse.setRetObj(obj);
        return restResponse;
    }

    protected RestResponse responseService(Integer code, String msg, Object obj) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResult(EmErrorMsg.FAIL.getIndex());
        restResponse.setRetCode(code);
        restResponse.setRetMsg(msg);
        restResponse.setRetDateTime(LocalDateTime.now());
        restResponse.setRetObj(obj);
        return restResponse;
    }


}
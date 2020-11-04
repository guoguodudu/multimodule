package com.fenyun.common.base.base.response;

import java.io.Serializable;

import static com.fenyun.common.base.base.enums.EmErrorMsg.FAIL;
import static com.fenyun.common.base.base.enums.EmErrorMsg.SUCCESS;

/**
 * @author dupihua
 */

public class BaseResponseUtil {

    private BaseResponseUtil() { throw new IllegalStateException("Utility class");
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

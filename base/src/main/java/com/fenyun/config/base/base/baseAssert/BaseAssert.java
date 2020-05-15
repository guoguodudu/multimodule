package com.fenyun.config.base.base.baseAssert;

import com.fenyun.config.base.base.enums.EmErrorMsg;
import com.fenyun.config.base.base.exception.ServiceException;
import org.springframework.lang.Nullable;

/**
 * @ClassName BaseAssert
 * @Description: TODO
 * @Author 25216
 * @Date 2020/5/7
 * @Version V1.0
 **/
public abstract class BaseAssert {

    public static void notNull(@Nullable Object object, String message) {
        if (object == null) {
            throw new ServiceException(EmErrorMsg.FAILPARAM);
           // throw new IllegalArgumentException(message);
        }
    }

}

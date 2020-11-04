package com.fenyun.common.base.base.annotation;

import java.lang.annotation.*;

/**
 * @author dupihua
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseResult {
}

package com.fenyun.common.base.base.response;

import com.fenyun.common.base.base.annotation.BaseResult;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;

/**
 * @author dupihua
 */

@RestControllerAdvice
public class BaseResultAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        AnnotatedElement annotatedElement = methodParameter.getAnnotatedElement();
        BaseResult focusController = AnnotationUtils.findAnnotation(annotatedElement, BaseResult.class);
        return focusController != null;
    }


    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果是返回了RetResult类就直接返回不做处理
        if (o instanceof BaseResponse) {
            return o;
        }
        //如果返回的数据是string类型的时候做的处理

        return BaseResponseUtil.resultSuccesss(o);
    }
}

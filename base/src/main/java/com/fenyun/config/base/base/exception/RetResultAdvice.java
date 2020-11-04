package com.fenyun.config.base.base.exception;

import com.fenyun.config.base.base.annotation.BaseResult;
import com.fenyun.config.base.base.response.RaseResponse;
import com.fenyun.config.base.base.response.RestResponse;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.time.LocalDateTime;

@RestControllerAdvice
public class RetResultAdvice implements ResponseBodyAdvice<Object> {

    //需要忽略拦截的类

    //这个方法表示对于哪些请求要执行beforeBodyWrite，返回true执行，返回false不执行
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        AnnotatedElement annotatedElement = methodParameter.getAnnotatedElement();
        BaseResult focusController = AnnotationUtils.findAnnotation(annotatedElement, BaseResult.class);
        return focusController != null;
    }


    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果是返回了RetResult类就直接返回不做处理
        if (o instanceof RaseResponse) {
            return o;
        }
        //如果返回的数据是string类型的时候做的处理

        return RestResponse.makeErrRsp(o);
    }
}

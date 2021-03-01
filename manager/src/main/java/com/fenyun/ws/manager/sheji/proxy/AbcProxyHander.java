package com.fenyun.ws.manager.sheji.proxy;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class AbcProxyHander implements InvocationHandler {

    private Object abcProxy;
    public AbcProxyHander(Object abcProxy) {
        this.abcProxy = abcProxy;

    }
    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("123");
        Object result = method.invoke(abcProxy, args);
        return result;
    }




}

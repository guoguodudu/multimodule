package com.fenyun.ws.manager.sheji.proxy;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        AbcProxy abcProxy=new AbcProxyIml();
     //   abcProxy.get();


        //创建一个实例对象，这个对象是被代理的对象
        //AbcProxy zhangsan = new AbcProxyIml();

        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new AbcProxyHander("abc");

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        AbcProxy stuProxy = (AbcProxy) Proxy.newProxyInstance(AbcProxy.class.getClassLoader(), new Class<?>[]{AbcProxy.class}, stuHandler);

        //代理执行上交班费的方法
        stuProxy.get();
        Double d=11.2+112.4;
        System.out.println(d*0.15);

        IntStream.range(1, 3).forEach(e-> System.out.println(e));
        BigDecimal ll=Stream.of(BigDecimal.valueOf(13.5),BigDecimal.valueOf(100)).map(e->e.multiply(new BigDecimal(0.15).setScale(4,4))).reduce(BigDecimal::add).orElse(null);


        System.out.println(ll);
        BigDecimal llr=Stream.of(BigDecimal.valueOf(100),BigDecimal.valueOf(12.55555)).reduce(BigDecimal::add).map(e->e.multiply(new BigDecimal(String.valueOf(0.15)))).orElse(null);
        System.out.println(String.valueOf(llr));
        System.out.println(BigDecimal.valueOf(12.55555));
        System.out.println(BigDecimal.valueOf(0.55555));

    }
}

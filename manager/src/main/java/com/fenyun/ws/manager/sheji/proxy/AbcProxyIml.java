package com.fenyun.ws.manager.sheji.proxy;

import com.fenyun.ws.manager.sheji.Decorator.ABCInterface;

public class AbcProxyIml implements AbcProxy {
    @Override
    public void get() {

        System.out.println("12----");
    }


    @Override
    public void get2() {

        System.out.println("12----");
    }
}

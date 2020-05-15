package com.fenyun.ws.manager.sheji;

public class AbstractFactoryBuilder {

    public static AbstractFactory getAbstractFactoryABC() {
        return new AbstractFactoryABC();

    }

    public static AbstractFactory getAbstractFactorZSh() {
        return new AbstractFactoryZHW();
    }
}


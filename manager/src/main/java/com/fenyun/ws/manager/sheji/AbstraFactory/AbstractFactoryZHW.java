package com.fenyun.ws.manager.sheji.AbstraFactory;


public class AbstractFactoryZHW implements AbstractFactory {


    @Override
    public IBoMa getBoMa(String color) {
        return new ZSW();
    }

    @Override
    public ICaseClose getCaseClose(String color) {
        return new ZSwCase();
    }
}

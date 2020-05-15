package com.fenyun.ws.manager.sheji;

public class AbstractFactoryABC  implements AbstractFactory{
    @Override
    public IBoMa getBoMa(String color) {
        return new ABC();
    }

    @Override
    public ICaseClose getCaseClose(String color) {
        return new ABCCase();
    }
}

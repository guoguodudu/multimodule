package com.fenyun.ws.manager.sheji;

public interface AbstractFactory {

    public  IBoMa getBoMa(String color);

    public  ICaseClose getCaseClose(String color);
}

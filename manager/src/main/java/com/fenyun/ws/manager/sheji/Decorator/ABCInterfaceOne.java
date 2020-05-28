package com.fenyun.ws.manager.sheji.Decorator;

public class ABCInterfaceOne implements ABCInterface{
    @Override
    public void get() {
        System.out.println("Decorator");
    }
}

package com.fenyun.ws.manager.sheji.Decorator;

public class ABCInterfaceTwo implements ABCInterface {

    private ABCInterface abcInterface;

    public ABCInterfaceTwo(ABCInterface abcInterface) {

        this.abcInterface=abcInterface;
    }

    @Override
    public void get() {
        abcInterface.get();
        System.out.println("123");
    }
}

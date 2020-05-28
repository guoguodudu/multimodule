package com.fenyun.ws.manager.sheji.Decorator;

public class Main {

    public static void main(String[] args) {
        ABCInterface abcInterface=new ABCInterfaceOne();
        ABCInterface abcInterface1=new ABCInterfaceTwo(abcInterface);
        abcInterface1.get();
    }
}

package com.fenyun.ws.manager.demo;

public class StaticDemo {

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void ADD(String name) {
        stringBuilder.append(name);
    }

    public static void PUT(String name) {
        stringBuilder.append(name);
    }


    public static String getString() {
        return stringBuilder.toString();
    }
}

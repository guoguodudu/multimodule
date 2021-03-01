package com.fenyun.ws.manager.jvm;

public class Parcel7 {


    public static void main(String[] args) {
        Runnable runnable=()->{
            try {
                Thread.sleep(111L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(123);
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("1234");



    }
}
